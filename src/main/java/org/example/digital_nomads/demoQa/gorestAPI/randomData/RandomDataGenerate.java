package org.example.digital_nomads.demoQa.gorestAPI.randomData;


import com.github.javafaker.Faker;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Post;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.User;

public class RandomDataGenerate {

    private static final Faker faker = new Faker();

    public static String randomName(){
        return faker.name().fullName();
    }

    public static String randomEmail(){
        return faker.internet().emailAddress();
    }

    public static String randomTitle(){
        return faker.harryPotter().book();
    }
    public static String randomBody(){
        return faker.harryPotter().quote();
    }

    public static org.example.digital_nomads.demoQa.gorestAPI.goRestModels.User createRandomUser(){
        return User.builder().name(randomName()).email(randomEmail()).gender("female").status("active").build();
    }

    public static Post createRandomPost(){
        return Post.builder().title(randomTitle()).body(randomBody()).build();
    }
}
