package com.bcump.demo.mapper;

import com.bcump.demo.domain.DemoUserPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DemoUserPostMapper {

    /**
     * 统计某个岗位关联了多少员工
     * @param postId
     * @return
     */
    public int countUserPostById(Long postId);

    /**
     * 批量新增用户岗位关联信息
     * @param userPostList
     * @return
     */
    public int batchUserPost(List<DemoUserPost> userPostList);

    /**
     * 通过用户ID删除用户和岗位关联
     * @param userId
     * @return
     */
    public int deleteUserPostByUserId(Long userId);
}
