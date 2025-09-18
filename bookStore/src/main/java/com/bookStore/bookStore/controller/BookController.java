package com.bookStore.bookStore.controller;


import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookService myBookService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllbooks(){
        List<Book> list = service.getAllBooks();
        return new ModelAndView("bookList","books",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String GetBooks(Model model){
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("books",list);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Long id){
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getName(), b.getAuthor(), b.getPrice()); // don't pass ID
        myBookService.saveMYBooks(mb);
        return "redirect:/my_books";
    }






}
