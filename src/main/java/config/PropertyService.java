package config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyService {

    public  static Object getPropertyFromApiFile (String name){  // обращается к проперти где лежит url сайта
        Properties properties = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get( "src/main/resources/api.properties"))){
            properties.load(input);
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
        return properties.getProperty(name);
    }
}
