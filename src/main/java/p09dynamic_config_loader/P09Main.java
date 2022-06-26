package p09dynamic_config_loader;

import p09data.GameConfig;
import p09data.UserInterfaceConfig;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.Scanner;

public class P09Main {

    private static final Path GAME_CONFIG_PATH = Path.of("src/main/resources/game-properties.cfg");
    private static final Path UI_CONFIG_PATH = Path.of("src/main/resources/user-interface.cfg");

    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        GameConfig config = createConfigObject(GameConfig.class, GAME_CONFIG_PATH);
//        UserInterfaceConfig config = createConfigObject(UserInterfaceConfig.class, UI_CONFIG_PATH);

        System.out.println(config);

    }

    public static <T> T createConfigObject(Class<T> clazz, Path filepath) throws IOException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Scanner scanner = new Scanner(filepath);

        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);

        T configInstance = (T) constructor.newInstance();

        while (scanner.hasNextLine()) {
            String configLine = scanner.nextLine();

            String[] nameValuePair = configLine.split("=");
            String propertyName = nameValuePair[0];
            String propertyValue = nameValuePair[1];

            Field field;
            try {
                field = clazz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                System.out.printf("Property name : %s is unsupported\n", propertyName);
                continue;
            }

            field.setAccessible(true);

            Object parseValue = parseValue(field.getType(), propertyValue);

            field.set(configInstance, parseValue);
        }

        return configInstance;
    }

    private static Object parseValue(Class<?> type, String value) {
        if (type.equals(int.class)) {
            return Integer.parseInt(value);
        } else if (type.equals(short.class)) {
            return Short.parseShort(value);
        } else if (type.equals(long.class)) {
            return Long.parseLong(value);
        } else if (type.equals(double.class)) {
            return Double.parseDouble(value);
        } else if (type.equals(float.class)) {
            return Float.parseFloat(value);
        } else if (type.equals(String.class)) {
            return value;
        }
        throw new RuntimeException(String.format("Type : %s unsupported", type.getTypeName()));

    }

}
