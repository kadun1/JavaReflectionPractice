package p13annotation_init_example.app.http;

import p13annotation_init_example.annotations.InitializerClass;
import p13annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class P13ServiceRegistry {

    @InitializerMethod
    public void registerService() {
        System.out.println("Service successfully registered");
    }
}
