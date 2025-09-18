package com.tanmay.movieTicket.service;

import com.tanmay.movieTicket.Dto.TheaterDto;
import com.tanmay.movieTicket.model.City;
import com.tanmay.movieTicket.model.Theater;
import com.tanmay.movieTicket.repository.CityRepository;
import com.tanmay.movieTicket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private CityRepository cityRepository;

    public TheaterDto createTheater(Long id,TheaterDto theaterDto){
        Theater theater=new Theater();
        theater.setName(theaterDto.getName());
        theater.setArea(theaterDto.getArea());
        City city= cityRepository.findById(id).get();
        theater.setCity(city);
        theaterRepository.save(theater);
        return theaterDto;
    }

    public TheaterDto getTheater(Long id, TheaterDto theaterDto){
        Theater theater=theaterRepository.findById(id).get();
        theaterDto.setName(theater.getName());
        theaterDto.setArea(theater.getArea());
        return theaterDto;
    }

    public List<Theater> getTheaterlist(){
        return theaterRepository.findAll();
    }

    public TheaterDto updateTheater(Long id , TheaterDto theaterDto){
        Theater theater=theaterRepository.findById(id).get();
        theater.setName(theaterDto.getName());
        theater.setArea(theaterDto.getArea());
        theaterRepository.save(theater);
        return theaterDto;
    }

    public Theater deleteTheater(Long id){
        Theater theater=theaterRepository.findById(id).get();
        theaterRepository.delete(theater);
        return theater;
    }

}
