package org.example.digital_nomads.demoQa.gorestAPI.randomData;



import org.example.digital_nomads.demoQa.gorestAPI.models.Post;
import org.example.digital_nomads.demoQa.gorestAPI.models.User;

import java.util.Random;
import java.util.UUID;

public class RandomDataGenerate {

    public static User createUser() {
        String random = UUID.randomUUID().toString().substring(0, 5);
        String[] genders = {"male", "female"};
        String[] statuses = {"active", "inactive"};
        Random rnd = new Random();

        return User.builder()
                .name("User" + random)
                .email("user" + random + "@mail.com")
                .gender(genders[rnd.nextInt(genders.length)])
                .status(statuses[rnd.nextInt(statuses.length)])
                .build();
    }

    public static Post createPost() {
        String random = UUID.randomUUID().toString().substring(0, 5);
        Random rnd = new Random();

        return Post.builder()
                .userId(rnd.nextInt(10) + 1)
                .title("Title " + random)
                .body("Body " + random)
                .build();
    }
}
