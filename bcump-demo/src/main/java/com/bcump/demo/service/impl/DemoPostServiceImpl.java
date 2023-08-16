package com.bcump.demo.service.impl;

import com.bcump.common.exception.ServiceException;
import com.bcump.demo.domain.DemoPost;
import com.bcump.demo.domain.DemoUser;
import com.bcump.demo.mapper.DemoPostMapper;
import com.bcump.demo.mapper.DemoUserMapper;
import com.bcump.demo.mapper.DemoUserPostMapper;
import com.bcump.demo.service.DemoPostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DemoPostServiceImpl implements DemoPostService {

    private final DemoPostMapper demoPostMapper;

    private final DemoUserPostMapper demoUserPostMapper;

    @Override
    public int addPost(DemoPost demoPost) {
        return demoPostMapper.addPost(demoPost);
    }

    @Override
    public int updatePost(DemoPost demoPost) {
        return demoPostMapper.updatePost(demoPost);
    }

    @Override
    public DemoPost selectPostById(Long postId) {
        return demoPostMapper.selectPostById(postId);
    }


    @Override
    public int deletePostById(Long postId) {
        DemoPost post = selectPostById(postId);
        if(countUserPostById(postId) > 0){
            throw new ServiceException(String.format("%1$s已分配,不能删除", post.getPostName()));
        }
        return demoPostMapper.deletePostById(postId);
    }

    private int countUserPostById(Long postId) {
        return demoUserPostMapper.countUserPostById(postId);
    }

}
