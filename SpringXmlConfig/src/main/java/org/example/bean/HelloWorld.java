package org.example.bean;

public class HelloWorld {

    private String message;

    private Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message + " [" + post.getPost() + "]");
    }

}
