package com.bcump.demo.service;

import com.bcump.demo.domain.DemoPost;
import com.bcump.demo.domain.DemoUser;

public interface DemoPostService {

    public int addPost(DemoPost demoPost);

    public int updatePost(DemoPost demoPost);

    public DemoPost selectPostById(Long postId);

    public int deletePostById(Long postId);


}
