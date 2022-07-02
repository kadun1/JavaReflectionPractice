package p13annotation_init_example.app.databases;

import p13annotation_init_example.annotations.InitializerClass;
import p13annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class P13DatabaseConnection {

    @InitializerMethod
    public void connectToDatabase1() {
        System.out.println("Connection to database 1");
    }
//    @InitializerMethod
    public void connectToDatabase2() {
        System.out.println("Connection to database 2");
    }
}
