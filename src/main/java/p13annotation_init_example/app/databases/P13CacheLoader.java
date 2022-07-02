package p13annotation_init_example.app.databases;

import p13annotation_init_example.annotations.InitializerClass;
import p13annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class P13CacheLoader {

    @InitializerMethod
    public void loadCache() {
        System.out.println("Loading data from cache");
    }
    public void reloadCache() {
        System.out.println("Reload cache");
    }
}
