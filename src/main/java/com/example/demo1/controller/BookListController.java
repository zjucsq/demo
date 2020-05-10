package com.example.demo1.controller;

import com.example.demo1.dto.Book;
import com.example.demo1.mapper.BookMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BookListController {

    @Resource
    private BookMapper bookMapper;

    @GetMapping("/booklist")
    public String indexForm(Model model){
        model.addAttribute("book", new Book());
        return "booklist";
    }

    @PostMapping("/result")
    public ModelAndView indexShow(@ModelAttribute Book newBook,
                                  @RequestParam(name="action") String str){
        ModelAndView mv = new ModelAndView();
        if (str.equals("添加")) {
            if (newBook.getId() != null) {
                bookMapper.addBook(newBook);
            }
        }
        else if (str.equals("删除")) {
            if (newBook.getId() != null) {
                bookMapper.deleteBookById(newBook.getId());
            }
        }
        List<Book> bookList = bookMapper.getAllBooks();
        mv.addObject("books", bookList);
        mv.addObject("newBook", newBook);
        mv.setViewName("result");
        return mv;
    }
}
