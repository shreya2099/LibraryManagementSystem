package com.example.library.studentlibrary.Services;

import com.example.library.studentlibrary.Model.Card;
import com.example.library.studentlibrary.Model.Student;
import com.example.library.studentlibrary.Repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private static Logger logger = LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private
    StudentRepository studentRepository;

    @Autowired
    private
    CardService cardService;

    public void createStudent(Student student){
        Card newCard= cardService.createAndReturn(student);
        logger.info("The card for the student {} is created with the details - {}", student, newCard);
    }

    public void updateStudent(Student student){
        studentRepository.updateStudentDetails(student);
    }

    public void deleteStudent(int id){

        cardService.deactivateCard(id);
        studentRepository.deleteCustom(id);
    }



}
