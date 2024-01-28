package config;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

public class ResponseService {

    // Пишем проверки
    public static ResponseSpecification ok(){
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK) // проверка на статус ок
                .build();
    }

    public static ResponseSpecification create() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_CREATED)
                .build();
    }

    public static ResponseSpecification delete() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_NO_CONTENT)
                .build();
    }
}
