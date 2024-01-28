package builders;

import dto.request.UserDto;

public class UserBuilder {
    public UserDto userDefaultBuilder() {
        return UserDto.builder()
                .id( 124567890 )
                .username("Batman1")
                .firstName("Bruce")
                .lastName("Wayne")
                .email("batman.man@gmail.com")
                .password("Batman12!")
                .phone("0102030405")
                .userStatus(2)
                .build();
    }


}
