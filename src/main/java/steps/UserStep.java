package steps;

import builders.UserBuilder;
import config.Requests;
import config.ResponseService;
import dto.request.UserDto;
import endpoints.UserEndpoints;
import io.restassured.specification.RequestSpecification;

import static config.ResponseService.delete;
import static config.ResponseService.create;
import static io.restassured.RestAssured.given;


public class UserStep {

    Requests requests = new Requests();

    public UserDto createUser() {
        return requests.post( new UserBuilder().userDefaultBuilder(), UserEndpoints.CREATE_USER.getEndpoints())
                .then().spec(create()).extract().body().as(UserDto.class);

    }
    public UserDto verifyUserCreation() {
        return requests.get(new UserBuilder().userDefaultBuilder(), UserEndpoints.CREATE_USER.getEndpoints())
                .then().spec(create()).statusCode(200).extract().body().as(UserDto.class);

    }

    public void deleteUser(String user) {
        requests.delete(UserEndpoints.DELETE_USER.getEndpoints()+ "Batman1")
                .then().spec(delete());
    }

    public UserDto verifyUserDelete() {
        return requests.get(new UserBuilder().userDefaultBuilder(), UserEndpoints.CREATE_USER.getEndpoints()+"Batman1")
                .then().spec(delete()).extract().body().as(UserDto.class);

    }
}





