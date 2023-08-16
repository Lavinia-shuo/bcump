package com.bcump.demo.domain;

public class DemoPost {

    private Long postId;

    private String postName;

    private Long version;

    public DemoPost() {
    }

    public DemoPost(Long postId, String postName, Long version) {
        this.postId = postId;
        this.postName = postName;
        this.version = version;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
