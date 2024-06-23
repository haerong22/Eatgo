package org.example.paymentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class PaymentserviceApplication

fun main(args: Array<String>) {
    runApplication<PaymentserviceApplication>(*args)
}
