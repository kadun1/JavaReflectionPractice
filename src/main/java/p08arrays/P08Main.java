package p08arrays;

import java.lang.reflect.Array;

public class P08Main {
    public static void main(String[] args) {

        int[] oneDimensionalArray = {1, 2};

        double [][] twoDimensionalArray = {{1.5, 2.5}, {3.5, 4.5}};

        int[][][] threeDimensionalArray = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}, {{9, 10}, {11, 12}}};

//        inspectArrayObject(twoDimensionalArray);

        inspectArrayValues(threeDimensionalArray);
    }


    public static void inspectArrayValues(Object arrayObject) {
        int arrayLength = Array.getLength(arrayObject);

        System.out.print("[");
        for (int i = 0; i < arrayLength; i++) {
            Object element = Array.get(arrayObject, i);

            if (element.getClass().isArray()) {
                inspectArrayValues(element);
            } else {
                System.out.print(element);
            }


            if (i != arrayLength - 1) {
                System.out.print(" , ");
            }
        }
        System.out.print("]");
    }
    public static void inspectArrayObject(Object arrayObject) {
        Class<?> clazz = arrayObject.getClass();

        System.out.println(String.format("Is array : %s", clazz.isArray()));

        Class<?> arrayComponentType = clazz.getComponentType();

        System.out.println(String.format("This is an array of type : %s", arrayComponentType.getTypeName()));
    }
}
