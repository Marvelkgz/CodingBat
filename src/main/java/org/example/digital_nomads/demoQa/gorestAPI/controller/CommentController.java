package org.example.digital_nomads.demoQa.gorestAPI.controller;


import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.models.Comment;

public class CommentController extends HttpRequest {

    public CommentController(String url) {
        super(url);
    }

    public Comment[] getUserCommentsById(Integer id) {
        return super.get(getEndpoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(id),
                EndPoint.COMMENTS)).as(Comment[].class);
    }

    public Comment createUserComments(Comment comment, Integer postId) {
        return super.post(getEndpoint(EndPoint.PUBLIC, EndPoint.V2, EndPoint.POSTS, String.valueOf(postId),
                EndPoint.COMMENTS), comment.toJson()).as(Comment.class);
    }
}
