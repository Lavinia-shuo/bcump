package com.bcump.demo.mapper;

import com.bcump.demo.domain.DemoUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DemoUserMapper {

    public List<DemoUser> findAll();

    public DemoUser checkNumberUnique(String number);

    public int add(DemoUser demoUser);

    public int updateUser(DemoUser demoUser);

    public int deleteUserById(Long userId);

    public List<DemoUser> selectUserList(DemoUser demoUser);

    public long findVersionByUserId(Long userId);
}
