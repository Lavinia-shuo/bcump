package com.bcump.demo.service;

import com.bcump.demo.domain.DemoUser;

import java.util.List;

public interface DemoUserService {

    public String checkNumberUnique(DemoUser demoUser);

    public int add(DemoUser demoUser);

    public int updateUser(DemoUser demoUser);

    public int deleteUserById(Long userId);

    public List<DemoUser> selectUserList(DemoUser demoUser);

}


