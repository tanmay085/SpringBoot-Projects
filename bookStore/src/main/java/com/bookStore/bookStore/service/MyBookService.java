package com.bookStore.bookStore.service;

import com.bookStore.bookStore.entity.MyBookList;
import com.bookStore.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    private MyBookRepository myRepo;
    public void saveMYBooks(MyBookList myBook){
        myRepo.save(myBook);
    }
    public List<MyBookList> getAllMyBooks(){
        return myRepo.findAll();
    }

    public void deleteById(Long id){
        myRepo.deleteById(id);
    }
}
