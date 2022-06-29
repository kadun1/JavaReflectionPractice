package p11logging;

import java.io.IOException;

public class P11FileLogger {
    public void sendRequest(String data) throws IOException {
        throw new IOException("Fail saving request to a file");
//        System.out.println(String.format("Data : %s was logged to the file system", data));
    }
}
