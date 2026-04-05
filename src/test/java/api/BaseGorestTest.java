package api;

import org.example.digital_nomads.demoQa.gorestAPI.config.ConfigurationManager;
import org.example.digital_nomads.demoQa.gorestAPI.controller.CommentController;
import org.example.digital_nomads.demoQa.gorestAPI.controller.PostController;
import org.example.digital_nomads.demoQa.gorestAPI.controller.ToDoController;
import org.example.digital_nomads.demoQa.gorestAPI.controller.UserController;
import org.example.digital_nomads.demoQa.gorestAPI.randomData.RandomDataGenerate;
import org.junit.jupiter.api.BeforeAll;

public class BaseGorestTest {

        protected static UserController userController;
    protected static PostController postController;
    protected static CommentController commentController;
    protected static ToDoController toDoController;
    protected  static RandomDataGenerate randomDataGenerate;

    @BeforeAll
    static void innitControllersCheck() {
        // Диагностика
        String url = ConfigurationManager.getBaseConfig().gorestBaseUrl();
        System.out.println("DEBUG gorest url: " + url); // если null - проблема в чтении файла

            userController = new UserController(url);
            postController = new PostController(url);
            commentController = new CommentController(url);
            toDoController = new ToDoController(url);
            randomDataGenerate = new RandomDataGenerate();
    }

//    @BeforeAll
//    static void innitControllers() {
//        userController = new UserController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
//        postController = new PostController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
//        commentController = new CommentController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
//        toDoController = new ToDoController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
//    }
}
