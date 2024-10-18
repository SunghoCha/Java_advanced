package network.tcp.v1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println(google);

        /*
            자바는 InetAddress.getByName("호스트명") 메서드를 사용해서 해당하는 IP 주소를 조회함
            먼저 시스템의 호스트 파일을 확인하고 정의되어 있지 않다면 DNS 서버에 요청해서 IP 주소를 얻음
         */
        
    }
}
