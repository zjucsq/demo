package com.example.demo1.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class User {
    @Email(message = "邮箱格式错误")
    private String email;

    @NotBlank(message = "用户名称不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "手机不能为空")
    private String phone;

    // @NotBlank(message = "验证码不能为空")
    // private String token;


    public User() {
    }

    public User(@Email(message = "邮箱格式错误") String email, @NotBlank(message = "用户名称不能为空") String name, @NotBlank(message = "密码不能为空") String password, @NotBlank(message = "手机不能为空") String phone) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    // 头像先不做
    // private String avatarUrl;
}
