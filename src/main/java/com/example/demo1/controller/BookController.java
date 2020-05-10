package com.example.demo1.controller;

import com.example.demo1.dto.Book;
import com.example.demo1.mapper.BookMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Resource
    private BookMapper bookMapper;

    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = bookMapper.getAllBooks();
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }
}
