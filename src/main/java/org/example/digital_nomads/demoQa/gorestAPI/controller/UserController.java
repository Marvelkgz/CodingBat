package org.example.digital_nomads.demoQa.gorestAPI.controller;


import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.models.Post;
import org.example.digital_nomads.demoQa.gorestAPI.models.User;

public class UserController extends HttpRequest {

    public UserController(String url) {
        super(url);
    }

    public User[] getAllUsers() {
        return super.get(getEndpoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS)).as(User[].class);
    }

    public User createNewUser(User user) {
        return super.post(getEndpoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS), user.toJson()).as(User.class);
    }

    public Post createPost(Post post) {
        return (Post) super.post(
                getEndpoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.USERS,
                        String.valueOf(post.getUserId()), EndPoint.POSTS.toString()),
                post.toJson()
        );
    }
}
