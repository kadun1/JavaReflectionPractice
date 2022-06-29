package p11udp;

public class P11UdpClient {
    public void sendAndForget(String requestPayload) {
        System.out.println(String.format("Request : %s was sent through UDP", requestPayload));
    }
}
