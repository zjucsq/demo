package com.example.demo1.controller;

import com.example.demo1.dto.Book;
import com.example.demo1.dto.Message;
import com.example.demo1.dto.User;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.service.EncryptService;
import com.example.demo1.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegisterController {
    @Resource
    private UserMapper userMapper;

    /*
        @Autowired
        private MailService mailService;

        @Autowired
        private EncryptService encryptService;
    */
    @GetMapping(value = "/register")
    public String indexForm(Model model) {
        /*Map<String, String> mmap = new HashMap<String, String>();
        mmap.put("name", "");
        mmap.put("password", "");
        mmap.put("phone", "");
        mmap.put("email", "");
        model.addAttribute("info", mmap);*/
        return "register";
    }

    @PostMapping(value = "/registerresult")
    public ModelAndView register(@RequestParam Map<String, String> mmap) throws IOException {
        ModelAndView mv = new ModelAndView();
        User user = new User();
        if (mmap.get("email") != null) {
            user.setEmail(mmap.get("email"));
            user.setName(mmap.get("name"));
            user.setPassword(mmap.get("password"));
            user.setPhone(mmap.get("phone"));
            userMapper.createUser(user);
        }
        List<User> userList = userMapper.getAllUsers();
        mv.addObject("users", userList);
        //mv.addObject("newBook", newBook);
        mv.setViewName("registerresult");
        return mv;
    }
}
