package p10api_test;

import p10api.P10ClothingProduct;
import p10api.P10Product;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

//getter 테스트 프레임워크
public class P10ProductTest {
    public static void main(String[] args) {
        testGetters(P10ClothingProduct.class);
        testSetter(P10ClothingProduct.class);

    }

    public static void testSetter(Class<?> dataClass) {
        List<Field> fields = getAllFields(dataClass);

        for (Field field : fields) {
            String setterName = "set" + capitalizeFirstLeter(field.getName());

            Method setterMethod = null;
            try {
                setterMethod = dataClass.getMethod(setterName, field.getType());
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException(String.format("Setter : %s not found", setterName));
            }

        }
    }

    public static void testGetters(Class<?> dataClass) {
        List<Field> fields = getAllFields(dataClass);

        Map<String, Method> methodNameToMethod = mapMethodNameToMethod(dataClass);

        for (Field field : fields) {
            //getter 메소드 생성 규칙을 만들어준다.
            String getterName = "get" + capitalizeFirstLeter(field.getName());

            //getter메소드가 없다는 의미
            if (!methodNameToMethod.containsKey(getterName)) {
                throw new IllegalStateException(String.format("Field : %s doesn't have a getter method", field.getName()));
            }

            Method getter = methodNameToMethod.get(getterName);

            if (!getter.getReturnType().equals(field.getType())) {
                throw new IllegalStateException(
                        String.format("Getter method : %s has return type %s but expected %s",
                                getter.getName(),
                                getter.getReturnType().getTypeName(),
                                field.getType().getTypeName()));
            }

            if (getter.getParameterCount() > 0) {
                throw new IllegalStateException(String.format("Getter : %s has %d arguments", getterName));
            }
        }
    }

    private static List<Field> getAllFields(Class<?> clazz){
        if (clazz == null || clazz.equals(Object.class)) {
            return Collections.emptyList();
        }

        Field[] currentClassFields = clazz.getDeclaredFields();

        List<Field> inheritedFields = getAllFields(clazz.getSuperclass());

        List<Field> allFields = new ArrayList<>();

        allFields.addAll(Arrays.asList(currentClassFields));
        allFields.addAll(inheritedFields);

        return allFields;
    }

    //get 뒤의 문자열을 대문자로 지정한다.
    private static String capitalizeFirstLeter(String fieldName) {
        return fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1));
    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?> dataClass) {
        Method [] allMethods = dataClass.getMethods();

        Map<String, Method> nameToMethod = new HashMap<>();

        for (Method method : allMethods) {
            nameToMethod.put(method.getName(), method);
        }

        return nameToMethod;
    }
}
