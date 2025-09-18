package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.Book;
import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public void save(Book b){
        repo.save(b);
    }

    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    public Book getBookById(Long id){
        return repo.findById(id).get();
    }




}
