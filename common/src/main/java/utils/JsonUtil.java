package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 *
 * @author max.hu  @date 2023/11/29
 **/
@Slf4j
public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Object转json string
     *
     * @param obj object
     * @return json string
     */
    public static String toStr(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json string转object
     *
     * @param json  json string
     * @param clazz class
     * @param <T> class definition
     * @return T object
     */
    public static <T> T toObj(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json string转List<Obj>
     *
     * @param json  json string
     * @param clazz class
     * @param <T>   type
     * @return List<T> list Object
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json string转Map
     * @param json json string
     * @param kClass key Class
     * @param vClass value Class
     * @return map<K,V> map Object
     */
    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * json string转复杂对象
     * @param json json string
     * @param type type T
     * @return type Object
     */
    public static <T> T toTypeRef(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
