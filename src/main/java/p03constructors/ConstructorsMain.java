package p03constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructorsMain {
    public static void main(String [] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        printConstructorsData(P03Person.class);

        P03Address address = createInstanceWithArguments(P03Address.class, "First Street", 10);

        P03Person person = createInstanceWithArguments(P03Person.class,  address, "John", 20);
        System.out.println(person);
    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object ... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if(constructor.getParameterTypes().length == args.length) {

                return (T) constructor.newInstance(args);
            }
        }
        System.out.println("An appropriate constructor was not found");
        return null;
    }

    public static void printConstructorsData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        System.out.println(String.format("class %s has %d declared constructors", clazz.getSimpleName(), constructors.length));

        for (int i = 0; i < constructors.length; i++) {
            Class<?>[] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(type -> type.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }
    }

    public static class P03Person {
        private final P03Address address;
        private final String name;
        private final int age;

        public P03Person() {
            this.name = "anonymous";
            this.age = 0;
            this.address = null;
        }

        public P03Person(String name) {
            this.name = name;
            this.age = 0;
            this.address = null;
        }

        public P03Person(String name, int age) {
            this.name = name;
            this.age = age;
            this.address = null;
        }

        public P03Person(P03Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static class P03Address {
        private String street;
        private int number;

        public P03Address(String street, int number) {
            this.street = street;
            this.number = number;
        }
    }
}
