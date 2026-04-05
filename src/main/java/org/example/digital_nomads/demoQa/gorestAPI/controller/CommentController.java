package org.example.digital_nomads.demoQa.gorestAPI.controller;


import io.restassured.response.Response;
import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.goRestModels.Comment;

public class CommentController extends HttpRequest  {

    public CommentController(String url) {
        super(url);
    }

    public Comment[] getUserCommentsById(Integer id){ //    /public/v2/posts/7911361/comments
        return super.get(getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(id),
                EndPoint.COMMENTS)).as(Comment[].class);
    }

    public Comment createUserComments(Comment comment, Integer post_id){
        Response response = super.post(
                getEndPoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS,
                        String.valueOf(post_id), EndPoint.COMMENTS),
                comment.toJson()
        );
        if (response.getStatusCode() != 201) {
            throw new RuntimeException("Failed to create comment: " + response.asPrettyString());
        }
        return response.as(Comment.class);
    }
}
