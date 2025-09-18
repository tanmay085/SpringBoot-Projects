package com.tanmay.movieTicket.service;

import com.tanmay.movieTicket.Dto.CityDto;
import com.tanmay.movieTicket.model.City;
import com.tanmay.movieTicket.model.Theater;
import com.tanmay.movieTicket.repository.CityRepository;
import com.tanmay.movieTicket.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TheaterRepository theaterRepository;


    public CityDto createCity(CityDto cityDto){
        City city=new City();
        city.setName(cityDto.getName());
        city.setPincode(cityDto.getPincode());
        cityRepository.save(city);
        return cityDto;

    }

    public CityDto getCity(Long id, CityDto cityDto){
        City city=cityRepository.findById(id).get();
        cityDto.setName(city.getName());
        cityDto.setPincode(city.getPincode());
        return cityDto;
    }

    public List<City> getCitylist(){
        return cityRepository.findAll();
    }

    public CityDto updateCity(Long id, CityDto cityDto){
        City city= cityRepository.findById(id).get();

        city.setName(cityDto.getName());
        city.setPincode(cityDto.getPincode());
        cityRepository.save(city);
        return cityDto;
    }

    public City deleteCity(Long id){
        City city=cityRepository.findById(id).get();
        cityRepository.delete(city);
        return city;
    }

    public List<Theater> getTheaterByCity(Long id){
        City city=cityRepository.findById(id).get();
        return theaterRepository.findByCity(city);
    }



}
