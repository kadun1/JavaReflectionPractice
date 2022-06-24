package exercises;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExercisesMain {

    public static void main(String[] args) throws ClassNotFoundException {

        // .class를 통한
        Class<String> stringClass = String.class;

        // 인스턴스를 통한
        Map<String, Integer> mapObject = new HashMap<>();
        Class<?> hashMapClass = mapObject.getClass();

        // forName을 통한
        Class<?> squareClass = Class.forName("exercises.ExercisesMain$Square");

//        printClassInfo(stringClass, hashMapClass, squareClass);

        var circleObject = new Drawable(){
            @Override
            public int getNumOfCorners() {
                return 0;
            }
        };

        printClassInfo(Collection.class, boolean.class, int[][].class, Color.class, circleObject.getClass());
    }

    // ... 은 가변인자를 나타낸다
    private static void printClassInfo(Class<?> ... classes){

        for (Class<?> clazz : classes) {
            System.out.println(String.format("Class name : %s, class package name : %s",
                    clazz.getSimpleName(),
                    clazz.getPackageName()));

            Class<?> [] implementedInterfaces = clazz.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s",
                        clazz.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + clazz.isArray());
            System.out.println("Is primitive : "+ clazz.isPrimitive());
            System.out.println("Is enum : " + clazz.isEnum());
            System.out.println("Is interface : " + clazz.isInterface());
            System.out.println("Is anonymous : " + clazz.isAnonymousClass());

            System.out.println();
            System.out.println();
        }
    }

    private static class Square implements Drawable{
        @Override
        public int getNumOfCorners() {
            return 4;
        }
    }

    private static interface Drawable {
        int getNumOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }
}
