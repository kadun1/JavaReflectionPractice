package p11polymorphism;

import p11database.P11DatabaseClient;
import p11http.P11HttpClient;
import p11logging.P11FileLogger;
import p11udp.P11UdpClient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P11Main {

    public static void main(String[] args) throws Throwable {
        P11DatabaseClient databaseClient = new P11DatabaseClient();
        P11HttpClient httpClient1 = new P11HttpClient("123.456.789.0");
        P11HttpClient httpClient2 = new P11HttpClient("11.33.55.0");
        P11FileLogger fileLogger = new P11FileLogger();
        P11UdpClient udpClient = new P11UdpClient();

        String requestBody = "request data";

        List<Class<?>> methodParameterTypes = Arrays.asList(new Class<?>[]{String.class});

        Map<Object, Method> requestExecutors =
                groupExecutors(Arrays.asList(databaseClient, httpClient1, httpClient2, fileLogger, udpClient),
                        methodParameterTypes);

        executeAll(requestExecutors, requestBody);

    }

    public static void executeAll(Map<Object, Method> requestExecutors, String requestBody) throws Throwable {
        try {
            for (Map.Entry<Object, Method> requestExecutorEntry : requestExecutors.entrySet()) {

                Object requestExecutor = requestExecutorEntry.getKey();
                Method method = requestExecutorEntry.getValue();

                Boolean result = (Boolean) method.invoke(requestExecutor, requestBody);

                if (result != null && result.equals(Boolean.FALSE)) {
                    System.out.println("Received negative result. Aborting ...");
                    return;
                }
            }
        } catch (InvocationTargetException e) {
            throw  e.getTargetException();
        }
    }

    public static Map<Object, Method> groupExecutors(List<Object> requestExecutors, List<Class<?>> methodParameterTypes) {
        Map<Object, Method> instanceToMethod = new HashMap<>();

        for (Object requestExecutor : requestExecutors) {
            Method [] allMethods = requestExecutor.getClass().getDeclaredMethods();

            for (Method method : allMethods) {
                if (Arrays.asList(method.getParameterTypes()).equals(methodParameterTypes)) {
                    instanceToMethod.put(requestExecutor, method);
                }
            }
        }
        return instanceToMethod;
    }
}
