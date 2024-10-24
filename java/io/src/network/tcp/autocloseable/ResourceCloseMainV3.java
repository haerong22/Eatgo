package network.tcp.autocloseable;

public class ResourceCloseMainV3 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }
    }

    /*
        resource1 call
        resource2 callEx
        ex: network.tcp.autocloseable.CallException: resource2 ex
        자원 정리
        resource2 closeEx
        close ex: network.tcp.autocloseable.CloseException: resource2 ex
        resource1 closeEx
        close ex: network.tcp.autocloseable.CloseException: resource1 ex
        CallException 예외 처리
        Exception in thread "main" java.lang.RuntimeException: network.tcp.autocloseable.CallException: resource2 ex
     */

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;

        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx(); // CallException
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            System.out.println("자원 정리");
            if (resource2 != null) {
                try {
                    resource2.closeEx();
                } catch (CloseException e) {
                    // close 예외는 버림
                    System.out.println("close ex: " + e);
                }
            }

            if (resource1 != null) {

                try {
                    resource1.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
        }
    }
}