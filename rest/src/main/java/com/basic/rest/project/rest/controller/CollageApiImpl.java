package com.basic.rest.project.rest.controller;


import com.basic.rest.project.rest.model.Student;
import com.basic.rest.project.rest.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@Slf4j
public class CollageApiImpl implements CollageApi{

    @Autowired
    public StudentRepository studentRepo;

    public ResponseEntity<List<com.basic.rest.project.rest.models.Student>> student() {
        log.info("This is a very basic program on rest API.");

        List<com.basic.rest.project.rest.models.Student> studentList = new ArrayList<>();
        List<Student> allStudents = studentRepo.findAll();
        if(allStudents !=null && allStudents.size() != 0){
            for(Student st: allStudents){
                com.basic.rest.project.rest.models.Student stu = new com.basic.rest.project.rest.models.Student();
                stu.setId((int)st.getId());
                stu.setName(st.getName());
                stu.setCity(st.getCity());
                stu.setStd(st.getStd());
                stu.setStream(st.getStream());
                stu.setAge(st.getAge());

                studentList.add(stu);

                System.out.println("Student: " +st.toString());
            }
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
}
