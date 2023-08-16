package com.bcump.demo.service.impl;

import com.bcump.common.constant.UserConstants;
import com.bcump.common.utils.StringUtils;
import com.bcump.demo.domain.DemoUser;
import com.bcump.demo.domain.DemoUserPost;
import com.bcump.demo.mapper.DemoUserMapper;
import com.bcump.demo.mapper.DemoUserPostMapper;
import com.bcump.demo.service.DemoUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DemoUserServiceImpl implements DemoUserService {

    private final DemoUserMapper demoUserMapper;
    private final DemoUserPostMapper demoUserPostMapper;

    /**
     * 新增用户信息
     * @param demoUser
     * @return
     */
    @Override
    @Transactional
    public int add(DemoUser demoUser) {
        //新增用户信息
        int rows = demoUserMapper.add(demoUser);
        //新增用户岗位关联信息
        addUserPost(demoUser);
        return rows;
    }

    /**
     * 修改用户信息
     * @param demoUser
     * @return
     */
    @Override
    @Transactional
    public int updateUser(DemoUser demoUser) {
        Long userId = demoUser.getId();
        //删除用户与岗位关联信息
        demoUserPostMapper.deleteUserPostByUserId(userId);
        //新增用户与岗位关联信息
        addUserPost(demoUser);

//        //从数据库获取当前记录版本
//        long oldVersion = demoUserMapper.findVersionByUserId(userId);
//        demoUser.setVersion(oldVersion);

        //更新用户信息
        return demoUserMapper.updateUser(demoUser);
    }

    /**
     * 通过用户id删除用户
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public int deleteUserById(Long userId)
    {
        // 删除用户与岗位关联
        demoUserPostMapper.deleteUserPostByUserId(userId);
        return demoUserMapper.deleteUserById(userId);
    }

    /**
     * 根据条件分页查询用户列表
     * @param demoUser
     * @return
     */
    @Override
    public List<DemoUser> selectUserList(DemoUser demoUser) {
        return demoUserMapper.selectUserList(demoUser);

    }

    /**
     * 确认身份证号是否唯一
     * @param demoUser
     * @return
     */
    @Override
    public String checkNumberUnique(DemoUser demoUser) {
        DemoUser info = demoUserMapper.checkNumberUnique(demoUser.getNumber());

        //如果查出来有数据，并且该数据的id和提交数据的id不同，才不安全
        if(StringUtils.isNotNull(info) && info.getId().longValue() != demoUser.getId().longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增用户岗位关联信息
     * @param demoUser
     */
    private void addUserPost(DemoUser demoUser) {
        Long[] posts = demoUser.getPostIds();
        if (StringUtils.isNotEmpty(posts))
        {
            // 新增用户岗位关系
            List<DemoUserPost> list = new ArrayList<DemoUserPost>(posts.length);
            for (Long postId : posts)
            {
                DemoUserPost up = new DemoUserPost();
                up.setUserId(demoUser.getId());
                up.setPostId(postId);
                list.add(up);
            }
            demoUserPostMapper.batchUserPost(list);
        }
    }


//    public PageResult findAll(Integer pageNum, Integer pageSize){
//        PageHelper.startPage(pageNum, pageSize);
//        List<DemoUser> users = demoUserMapper.findAll();
//        PageInfo pageInfo = new PageInfo(users);
//        PageResult pageResult = new PageResult(pageInfo.getPageNum(),pageInfo.getPageSize(), pageInfo.getTotal(), users);
//        return pageResult;
//    }

}
