package network.tcp.autocloseable;

public class ResourceCloseMainV1 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            e.printStackTrace();
        }
    }

    private static void logic() throws CallException, CloseException{
        ResourceV1 resource1 = new ResourceV1("resource1");
        ResourceV1 resource2 = new ResourceV1("resource2");
        
        resource1.call();
        resource2.closeEx(); // 예외 발생

        System.out.println("자원 정리"); // 호출 안됨
        resource2.closeEx(); // 나중에 생성한 자원 먼저 정리 (두 자원이 서로 관련 없을 땐 생성,종료 순서가 상관없지만 그래도 역순으로 하는 습관)
        resource1.closeEx();
    }
}
