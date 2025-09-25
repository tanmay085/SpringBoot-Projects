package com.app.student_management.service;

import com.app.student_management.dto.ProfileDto;
import com.app.student_management.entity.Profile;
import com.app.student_management.entity.Student;
import com.app.student_management.exception.StudentNotFound;
import com.app.student_management.repository.ProfileRepository;
import com.app.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public ProfileDto createProfile(ProfileDto profileDto, Long id){
        Profile profile= new Profile();
        if(studentRepository.findById(id).isPresent()){
            Student student= studentRepository.findById(id).get();
            profile.setStudent(student);
            profile.setEmail(profileDto.getEmail());
            profile.setPhone(profileDto.getPhone());
            profile.setAddress(profileDto.getAddress());
            profileRepository.save(profile);
            return profileDto;
        }else{
            throw new StudentNotFound("student not found with id :"+id);
        }

    }

    public Profile profileGetByStudent(Long id){
        Student student=studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFound("Student not found with id:"+id));
        return profileRepository.findByStudent(student);
    }
}
