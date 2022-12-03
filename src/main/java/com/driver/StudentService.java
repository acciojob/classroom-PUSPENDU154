package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void servAddStudent(Student student){
        studentRepository.repoAddStudent(student);
    }



    public void servDeleteTeacherByName(String teacherName){
        studentRepository.repoDeleteTeacherByName(teacherName);

    }
    public void servAddStudentTeacherPair(String studentName,String teacherName){
        studentRepository.repoAddStudentTeacherPair(studentName, teacherName);
    }


    public Teacher servGetTeacherByName(String teacherName){
        return studentRepository.repoGetTeacherByName(teacherName);
    }

    public List<String> servGetStudentsByTeacherName(String teacherName){
        return studentRepository.repoGetStudentsByTeacherName(teacherName);
    }

    public List<String> servGetAllStudents(){
        return studentRepository.repoGetAllStudents();
    }


    public void servAddTeacher(Teacher teacher){
        studentRepository.repoAddTeacher(teacher);
    }

    public void servDeleteAllTeachers(){
         studentRepository.repoDeleteAllTeachers();
    }

    public Student servGetStudentsByName(String studentName){
        return studentRepository.repoGetStudentsByName(studentName);
    }
}
