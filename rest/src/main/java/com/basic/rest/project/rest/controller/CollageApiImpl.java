package com.basic.rest.project.rest.controller;


import com.basic.rest.project.rest.model.Student;
import com.basic.rest.project.rest.models.AddStudentResponseBody;
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

    public ResponseEntity<com.basic.rest.project.rest.models.Student> getStudentDetails(Integer id){
        log.info("Get the student details for the id: "+ id);

        Student st = studentRepo.getReferenceById(id);
        if(st != null){
            com.basic.rest.project.rest.models.Student student = new com.basic.rest.project.rest.models.Student();
            student.setId((int)st.getId());
            student.setName(st.getName());
            student.setStream(st.getStream());
            student.setAge(st.getAge());
            student.setCity(st.getCity());
            return new ResponseEntity<>(student,HttpStatus.OK);
        }else{
            log.info("No student details found for the id: " +id);
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }

    }

    public ResponseEntity<Void> deleteStudent(Integer id) {
        log.info("Deleting Student with Id:: "+ id);
        Integer deleteId = id;
        Student student = studentRepo.getReferenceById(id);
        if(student != null){
            studentRepo.delete(student);
        }else{
            log.error("No Student with ID: " + id + " is found in record");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<com.basic.rest.project.rest.models.Student>> getAllStudent(String city){
        log.info("Get the student details having city: "+ city);
        List<Student> studentFromDb;
        List<com.basic.rest.project.rest.models.Student> studentList = new ArrayList<>();
        if(city == null){
            studentFromDb = studentRepo.findAll();
        }else {
            studentFromDb = studentRepo.getStudentByCity(city);
        }
        if(studentFromDb !=null && studentFromDb.size() != 0){
            for(Student st: studentFromDb){
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

    public ResponseEntity<AddStudentResponseBody> addStudent(com.basic.rest.project.rest.models.Student st) {

        Student stu = new Student();

        stu.setName(st.getName());
        stu.setCity(st.getCity());
        stu.setStd(st.getStd());
        stu.setStream(st.getStream());
        stu.setAge(st.getAge());

        studentRepo.save(stu);
        AddStudentResponseBody response =  new AddStudentResponseBody();
        response.setId(stu.getId());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateStudent(Integer id, com.basic.rest.project.rest.models.Student student) {

        boolean createdFlag = false;
        Student studentDb = null;
        try {
            studentDb = studentRepo.getReferenceById(id);
        }catch(javax.persistence.EntityNotFoundException e){
            studentDb = new Student();
            createdFlag = true;
        }

        studentDb.setAge(student.getAge());
        studentDb.setStd(student.getStd());
        studentDb.setStream(student.getStream());
        studentDb.setName(student.getName());
        studentDb.setCity(student.getCity());
        studentRepo.save(studentDb);

        if(createdFlag) {
            AddStudentResponseBody response =  new AddStudentResponseBody();
            response.setId(studentDb.getId());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


}
