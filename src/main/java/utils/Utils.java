package utils;
import com.google.gson.Gson;

public class Utils {  // преобразователь из обьекта в json и наоборот


    private Utils() {
        throw new IllegalArgumentException("This is utility class");
    }

    public static <T> String toJson ( T object ){
        return new Gson().toJson(object);
    }
}

