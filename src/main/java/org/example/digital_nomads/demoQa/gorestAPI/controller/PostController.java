package org.example.digital_nomads.demoQa.gorestAPI.controller;


import org.example.digital_nomads.demoQa.gorestAPI.HttpRequest;
import org.example.digital_nomads.demoQa.gorestAPI.endPoint.EndPoint;
import org.example.digital_nomads.demoQa.gorestAPI.models.Post;

public class PostController extends HttpRequest {

    public PostController(String url) {
        super(url);
    }

    public Post[] getAllUserPosts(){
        return super.get(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.USERS,EndPoint.POSTS)).as(Post[].class);
    }

    public Post[] getUserPostsById(Integer id){   //public/v2/users/876986/posts
        return super.get(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.USERS,String.valueOf(id),
                EndPoint.POSTS)).as(Post[].class);
    }

    public Post createUserPosts(Post post,Integer id){   //public/v2/users/876986/posts
        return super.post(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.USERS,String.valueOf(id),
                EndPoint.POSTS), post.toJson()).as(Post.class);
    }

    public void deletePost(Integer id){   //public/v2/users/876986
        super.delete(getEndpoint(EndPoint.PUBLIC,EndPoint.V2,EndPoint.POSTS,String.valueOf(id)));
    }


}
