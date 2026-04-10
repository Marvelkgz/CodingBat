package api;

import lombok.extern.slf4j.Slf4j;

import org.example.digital_nomads.demoQa.gorestAPI.config.CsvUtils;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Comment;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Post;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.ToDo;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("API")
@Slf4j
public class EndToEndTest extends BaseGorestTest {

    private static final String CSV_PATH = "src/main/resources/users_data.csv";
    @Test
    @DisplayName("E2E: create user → create post → create comment → create todo → delete user")
    void shouldPerformFullUserWorkflowFromCreationToDeletion() {

        User user = randomDataGenerate.createRandomUser();
        User createdUser = userController.createNewUser(user);
        Integer id = createdUser.getId();

        Post post = randomDataGenerate.createRandomPost();
        Post createdPost = postController.createUserPost(post, id);
        Integer post_id = createdPost.getId();

        Comment comment = Comment.builder()
                .name(createdUser.getName())
                .email(createdUser.getEmail())
                .body(randomDataGenerate.randomBody())
                .build();
        commentController.createUserComments(comment, post_id);

        ToDo toDo = ToDo.builder()
                .title(randomDataGenerate.randomTitle())
                .due_on("10:00 am")
                .status("pending").build();
        toDoController.createUserToDo(toDo, id);
    }
    
    @Test
    void exportAllUsersToCsv() {
        List<User> users = Arrays.asList(userController.getAllUsers());
        CsvUtils.writeUsersToCsv(users, CSV_PATH);
    }
    
    @Test
    void shouldGetRandomUserFromCsv() {
        // взять рандомного пользователя целиком
        User randomUser = CsvUtils.getRandomUserFromCsv(CSV_PATH);
        Integer randomId = randomUser.getId();

        // работаем с рандомным id
        User userById = userController.getSingleUserById(randomId);
        assertThat(userController.getResponse().statusCode()).isEqualTo(200);
        assertThat(userById.getId()).isEqualTo(randomId);
    }
    
    @Test
    void shouldGetAllUsersFromCsvAndPickRandom() {
        // взять всех и поработать со списком
        List<User> users = CsvUtils.readUsersFromCsv(CSV_PATH);

        // рандомный id
        Integer randomId = users.get(new Random().nextInt(users.size())).getId();

        // все email-ы
        List<String> emails = users.stream().map(User::getEmail).toList();

        // все id-шки
        List<Integer> ids = users.stream().map(User::getId).toList();

        log.info("All ids: {}", ids);
        log.info("Random id picked: {}", randomId);
    }
}
