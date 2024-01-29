
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import steps.UserStep;
import org.testng.Assert;


public class UserTest {

    private final UserStep steps = new UserStep();


    @Test
    void shouldBeCreateUser() {

        steps.createUser();
        steps.getUser();
        steps.deleteUser();
        steps.getEmptyUser();

        var responseUser = steps.getEmptyUser();

        Assertion.assertThat(responseUser.getMessage()).isEqualTo("User not found");

    }

    @Test
    void shouldBeDeleteUser() {

        steps.createUser();
        steps.getUser();
        steps.deleteUser();
        steps.deleteEmptyUser();

        var responseUser1 = RestAssured.delete("https://petstore.swagger.io/v2/user/Batman1");
        int statusCode = responseUser1.getStatusCode();

        Assert.assertEquals(statusCode, 404);
    }
}





