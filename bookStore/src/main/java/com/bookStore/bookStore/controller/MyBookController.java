package com.bookStore.bookStore.controller;

import com.bookStore.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {

    @Autowired
    private MyBookService myBookService;
    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyBook(@PathVariable ("id")Long id){
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }


}
