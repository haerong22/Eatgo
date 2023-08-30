package org.example.io;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class JavaNIONonBlockingMultiServer {
    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService executorService = Executors.newFixedThreadPool(50);


    public static void main(String[] args) {
        log.info("start main");

        try (ServerSocketChannel serverSocket = ServerSocketChannel.open()) {
            serverSocket.bind(new InetSocketAddress("localhost", 8080));
            serverSocket.configureBlocking(false);


            while (true) {
                SocketChannel clientSocket = serverSocket.accept();

                if (clientSocket == null) {
                    Thread.sleep(100);
                    continue;
                }

                CompletableFuture.runAsync(() -> {
                    handleRequest(clientSocket);
                }, executorService);
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    private static void handleRequest(SocketChannel clientSocket) {
        ByteBuffer requestByteBuffer = ByteBuffer.allocateDirect(1024);

        while (clientSocket.read(requestByteBuffer) == 0) {
            log.info("Reading...");
        }
        requestByteBuffer.flip();
        String requestBody = StandardCharsets.UTF_8.decode(requestByteBuffer).toString();

        log.info("request: {}, count: {}", requestBody, count.incrementAndGet());

        Thread.sleep(10);

        ByteBuffer responseByteBuffer = ByteBuffer.wrap("This is server".getBytes());
        clientSocket.write(responseByteBuffer);
        clientSocket.close();
    }
}
