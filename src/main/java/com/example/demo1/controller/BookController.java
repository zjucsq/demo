package com.example.demo1.controller;

import com.example.demo1.dto.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1, "三国演义", "罗贯中"));
        books.add(new Book(2, "红楼梦", "曹雪芹"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("books", books);
        mv.setViewName("books");
        return mv;
    }
}
