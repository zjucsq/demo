package com.example.demo1.mapper;

import org.apache.ibatis.annotations.*;
import com.example.demo1.dto.Book;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("insert into books (id, name, author) values (#{id}, #{name}, #{author})")
    int addBook(Book book);

    @Delete("delete from books where id = #{id}")
    int deleteBookById(Integer id);

    @Update("update books set id = #{id}, name = #{name}, author = #{author} where email = #{email} ")
    int updateBookById(Book book);

    @Select("select * from books where id = #{id}")
    Book getBookById(Integer id);

    @Select("select * from books")
    List<Book> getAllBooks();
}
