package backend.helpers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonMapper {
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T mapJsonToPojo(String name, Class<T> pojo) {
        try {
            return objectMapper.readValue(new File("src/test/resources/json.templates/" + name), pojo);
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
    }

}
