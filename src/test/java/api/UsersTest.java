package api;
import org.assertj.core.api.Assertions;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Comment;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Post;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.ToDo;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class UsersTest extends BaseGorestTest{

    Integer idishka = 8421831;
    Integer newIdishka = 8421832;
    Integer post_id = 275331;
    @Tag("API")
    @Test
    void performFullCrudOperationsForUserTest() {
        userController.getAllUsers();


        User user = randomDataGenerate.createRandomUser();
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

        Assertions.assertThat(userController.getResponse().getTime())
                .as("More than 1 min")
                .isLessThan(1000);

        Assertions.assertThat(userController.getResponse().getHeader("x-frame-options"))
                .as("is not SAMEORIGIN")
                .isEqualTo("SAMEORIGIN");

        Assertions.assertThat(userController.getResponse().asByteArray().length)
                .as("Response size should be greater than 0")
                .isGreaterThan(0);

        Assertions.assertThat(actualUser.getId()).as("ID is NULL").isNotEqualTo(null);

        userController.getSingleUserById(id);

        User updatedUser = User.builder().name("NewNameUpdate").build();
        userController.partialUpdateUserDetailById(id, updatedUser);

        User userAllDetailsUpdated = randomDataGenerate.createRandomUser();
        userController.updateAllUserDetails(id, userAllDetailsUpdated);

        userController.deleteUser(id);
    }
    @Tag("API")
    @Test
    void postTest() {
        System.out.println("GET ALL USER'S POSTS: " + Arrays.toString(postController.getAllUsersPosts()));

        System.out.println("GET POST BY USER ID: " + Arrays.toString(postController.getUserPostsById(newIdishka)));

        Post post = randomDataGenerate.createRandomPost();
        Post createdPost = postController.createUserPost(post, newIdishka);
        System.out.println("CREATE USER POST: " + createdPost);

//        postController.deletePost(newIdishka);
    }
    @Tag("API")
    @Test
    void commentTest() {
        System.out.println("GET USER'S COMMENTS BY ID: " + Arrays.toString(commentController
                .getUserCommentsById(newIdishka)));

        Comment comment = Comment.builder().name("Sandy Hand").email("olivia.murazik@yahoo.com")
                .body(randomDataGenerate.randomBody()).build();
        Comment createdComment = commentController.createUserComments(comment, post_id);
        System.out.println("CREATE POST COMMENT: " + createdComment);
    }
    @Tag("API")
    @Test
    void toDoTest() {
        System.out.println("GET USER'S TODOS BY ID: " + Arrays.toString(toDoController.getUserToDosById(newIdishka)));

        ToDo toDo = ToDo.builder().title(randomDataGenerate.randomTitle()).due_on("5:30am").status("pending").build();
        ToDo createdToDo = toDoController.createUserToDo(toDo, newIdishka);
        System.out.println("CREATE POST COMMENT: " + createdToDo);
    }


}
