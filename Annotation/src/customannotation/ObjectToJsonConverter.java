package customannotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObjectToJsonConverter {
    private void checkIfSerializable(Object object) {
        if(Objects.isNull(object)) {
            throw new JsonSerializationException("The object serialize is null");
        }
        Class<?> c = object.getClass();
        if(!c.isAnnotationPresent(JsonSerializable.class)) {
            throw new JsonSerializationException("The class " + c.getSimpleName() +
                                    " is not annotation with JsonSerializable");
        }
    }
    private void initializeObject(Object object) throws Exception {
        Class<?> c = object.getClass();
        for (Method method : c.getDeclaredMethods()) {
            if(method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }

    private String getKey(Field field) {
        String value = field.getAnnotation(JsonElement.class).key();
        return value.isEmpty() ? field.getName() : value;
    }

    private String getJsonString(Object obj) throws Exception {
        Class<?> c = obj.getClass();
        Map<String , String> jsonElementMap = new HashMap<>();
        for(Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            if(field.isAnnotationPresent(JsonElement.class)) {
                jsonElementMap.put(getKey(field), field.get(obj) + "");
            }
        }
        String jsonString = jsonElementMap.entrySet().stream()
                        .map(entry -> "\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"")
                        .collect(Collectors.joining(",\n"));
        return "{\n" + jsonString + "\n}";
    }

    public String convertToJson(Object obj) throws JsonSerializationException {
        try {
            checkIfSerializable(obj);
            initializeObject(obj);
            return getJsonString(obj);
        } catch (Exception e) {
            throw new JsonSerializationException("Convert Error!");
        }
    }
}
