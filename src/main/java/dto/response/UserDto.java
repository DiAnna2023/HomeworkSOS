package dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    // беру Response body и конвертирую с json to java класс и меняю с public to private

    private int code;
    private String type;
    private String message;
}

