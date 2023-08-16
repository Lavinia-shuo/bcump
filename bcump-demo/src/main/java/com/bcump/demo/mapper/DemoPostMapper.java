package com.bcump.demo.mapper;

import com.bcump.demo.domain.DemoPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DemoPostMapper {

    /**
     * 新增员工
     * @param demoPost
     * @return
     */
    public int addPost(DemoPost demoPost);

    public int updatePost(DemoPost demoPost);

    int findVersionByPostId(long postId);

    /**
     * 根据岗位ID查询员工信息
     * @param postId
     * @return
     */
    DemoPost selectPostById(Long postId);

    /**
     * 通过岗位ID查询其关联的员工数量
     * @param postId
     * @return
     */
    public int deletePostById(Long postId);
}
