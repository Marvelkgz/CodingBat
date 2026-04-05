package api;


import org.example.digital_nomads.demoQa.gorestAPI.config.ConfigurationManager;
import org.example.digital_nomads.demoQa.gorestAPI.controller.UserController;
import org.example.digital_nomads.demoQa.gorestAPI.randomData.RandomDataGenerate;
import org.junit.jupiter.api.BeforeAll;

public class BaseUserTest {

    protected static UserController userController;
    protected  static RandomDataGenerate randomDataGenerate;


    @BeforeAll
    static void initController() {
        userController = new UserController(ConfigurationManager.getBaseConfig().gorestBaseUrl());
        randomDataGenerate = new RandomDataGenerate();

    }
}
