package steps;
import builders.UserBuilder;
import config.Requests;
import dto.request.UserDto;
import dto.response.DeleteUserDto;
import dto.response.EmptyUserDto;
import dto.response.GetUserDto;
import endpoints.UserEndpoints;
import static config.RequestService.request;
import static config.ResponseService.delete;
import static config.ResponseService.ok;



public class UserStep {

    Requests requests = new Requests();


    public UserDto createUser() {
        return requests.post((new UserBuilder().userDefaultBuilder()),
                        UserEndpoints.CREATE_USER.getEndpoints()).then().spec(ok())
                .extract().body().as(UserDto.class);
    }

    public GetUserDto getUser() {
        return requests.get(request(),
                        UserEndpoints.GET_USER.getEndpoints() + "Batman1").then().spec(ok())
                .extract().body().as(GetUserDto.class);
    }
    public EmptyUserDto getEmptyUser() {
        return requests.get(request(),
                        UserEndpoints.GET_USER.getEndpoints() + "Batman1").then().spec(delete())
                .extract().body().as(EmptyUserDto.class);
    }


    public DeleteUserDto deleteUser() {
        return requests.delete(request(),
                        UserEndpoints.DELETE_USER.getEndpoints() + "Batman1").then().spec(ok())
                .extract().body().as(DeleteUserDto.class);
    }

    public io.restassured.response.ResponseBodyExtractionOptions deleteEmptyUser() {
        return requests.delete(request(),
                        UserEndpoints.DELETE_USER.getEndpoints() + "Batman1").then().spec(delete())
                .extract().body();
    }
}





