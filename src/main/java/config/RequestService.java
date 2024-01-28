package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import static config.PropertyService.getPropertyFromApiFile;
import static io.restassured.filter.log.LogDetail.HEADERS;
import static io.restassured.filter.log.LogDetail.METHOD;
import static io.restassured.filter.log.LogDetail.PARAMS;
import static io.restassured.filter.log.LogDetail.URI;

public class RequestService {

    // Создаем хедеры, для отправления запроса

    private static final String APPLICATION_JSON = "application/json";
    private static final String CONTENT = "Content-Type";
    private static final String URL = String.valueOf(getPropertyFromApiFile("url"));
    // тянем с PropertyService, a тот в свою очередь тянет url с проперти файла

    public static RequestSpecification request() {
        return new RequestSpecBuilder()
                .addFilters(List.of(new RequestLoggingFilter(METHOD),
                        new RequestLoggingFilter(URI),
                        new RequestLoggingFilter(HEADERS),
                        new RequestLoggingFilter(PARAMS)))
                .setBaseUri(URL)
                .addHeader(CONTENT, APPLICATION_JSON)
                .build();
    }
}
