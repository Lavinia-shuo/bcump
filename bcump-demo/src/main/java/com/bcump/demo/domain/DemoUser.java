package com.bcump.demo.domain;

import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class DemoUser {
    private Long id;
    private String name;
    private int age;
    private String number;
    private String password;
    private Long[] postIds;
    private String delFlag;

    public DemoUser() {
    }

    public DemoUser(Long id, String name, int age, String number, String password, Long[] postIds, String delFlag) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.number = number;
        this.password = password;
        this.postIds = postIds;
        this.delFlag = delFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "用户的姓名不能为空")
    @Size(min = 0, max = 20, message = "用户的姓名长度不能超过20个字符")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "用户的年龄不能为空")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @NotBlank(message = "用户的身份证号不能为空")
    @Size(min = 18, max = 18, message = "用户身份证号长度应为18个字符")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "用户的岗位不能为空")
    public Long[] getPostIds() {
        return postIds;
    }

    public void setPostIds(Long[] postIds) {
        this.postIds = postIds;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
