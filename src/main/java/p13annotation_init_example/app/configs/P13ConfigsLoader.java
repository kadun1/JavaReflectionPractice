package p13annotation_init_example.app.configs;

import p13annotation_init_example.annotations.InitializerClass;
import p13annotation_init_example.annotations.InitializerMethod;

@InitializerClass
public class P13ConfigsLoader {

    @InitializerMethod
    public void loadAllConfigs() {
        System.out.println("Loading all configuration files");
    }
}
