package p01myreflection;

import p01vehicles.Car;

import java.util.HashMap;
import java.util.Map;

public class R01FirstPractice {

    public static void main(String[] args) throws ClassNotFoundException {

        String stringObject = "some-string";

        Car car = new Car();

        Map<String, Integer> map =new HashMap<>();

        //방법1 객체의 타입을 가져온다. 원시 타입은 객체가 아니므로 가져올 수 없음음
        System.out.println(stringObject.getClass());
        System.out.println(car.getClass());
        System.out.println(map.getClass());

        //방법2
        Class booleanType = boolean.class;
        Class intType = int.class;
        Class doubleType = double.class;

        //방법3
        Class<?> stringType = Class.forName("java.lang.String");
        Class<?> carType = Class.forName("vehicle.Car");
        Class<?> engineType = Class.forName("p01vehicles.Car$Engine"); //내부정보에 접근하려면 달러$ 기호 사용

    }
}
