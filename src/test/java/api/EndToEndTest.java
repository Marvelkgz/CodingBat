package api;

import org.assertj.core.api.Assertions;
import org.example.digital_nomads.demoQa.gorestAPI.models.Post;
import org.example.digital_nomads.demoQa.gorestAPI.models.User;
import org.example.digital_nomads.demoQa.gorestAPI.randomData.RandomDataGenerate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("API")
public class EndToEndTest extends BaseUserTest{

    @Test
    @DisplayName("E2E: ctaete user -> create post -> create coment -> create todo -> delete user")
    void shouldPerformFullUserWorkflowFromCreationToDelete(){
        User user = RandomDataGenerate.createUser();
        User createUser = userController.createNewUser(user);
        Integer id = createUser.getId();
        Assertions.assertThat(userController.getResponse().getStatusCode())
                .as("Actual and expected status code are mismatch")
                .isEqualTo(201);

        Assertions.assertThat(createUser)
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

        Assertions.assertThat(createUser.getId()).as("ID is not NULL").
                isNotEqualTo(null);

        Post post = RandomDataGenerate.createPost();


    }
}
