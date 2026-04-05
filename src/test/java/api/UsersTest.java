package api;

import org.assertj.core.api.Assertions;
import org.example.digital_nomads.demoQa.gorestAPI.models.User;
import org.example.digital_nomads.demoQa.gorestAPI.randomData.RandomDataGenerate;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("API")
public class UsersTest extends BaseUserTest{

    @Test
    void createUser(){
        userController.getAllUsers();


        User user = RandomDataGenerate.createUser();
        User actualUser = userController.createNewUser(user);
        Integer id = actualUser.getId();
        Assertions.assertThat(userController.getResponse().getStatusCode())
                .as("Actual and expected status code are mismatch")
                .isEqualTo(201);

        Assertions.assertThat(actualUser)
                .as("Response body mismatch")
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(user);

        Assertions.assertThat(userController.getResponse().getTime()).
                as("More than 1 min").
                isLessThan(5000);

        Assertions.assertThat(userController.getResponse().getHeader("x-frame-options")).
                as("is not SAMEORIGIN").
                isEqualTo("SAMEORIGIN");

        Assertions.assertThat(userController.getResponse().asByteArray().length).
                as("Response size should be greater than 0").
                isGreaterThan(0);

        Assertions.assertThat(actualUser.getId()).as("ID is not NULL").
                isNotEqualTo(null);


//        Integer existingUserId = 5; // ID который есть в базе
//        Post post = RandomDataGenerate.createPost(existingUserId);
//        RandomDataGenerate postService = null;
//        Post created = postService.createPost(post);


    }
}
