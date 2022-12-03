package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class StudentRepository {

    private Map<String,Student> studentMap;
    private Map<String,List<String>> studentTeacherPairMap;
    private Map<String,Teacher> teacherMap;

    public StudentRepository(){
        this.studentMap=new HashMap<String, Student>();
        this.studentTeacherPairMap=new HashMap<String, List<String>>();
        this.teacherMap=new HashMap<String, Teacher>();
    }

    public void repoAddStudent(Student student){
        studentMap.put(student.getName(),student);
    }

    public void repoAddTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }

    public void repoAddStudentTeacherPair(String studentName,String teacherName){
        List<String> studentsName=new ArrayList<>();
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)){
            teacherMap.put(teacherName,teacherMap.get(teacherName));
            studentMap.put(studentName,studentMap.get(studentName));
            if(studentTeacherPairMap.containsKey(teacherName)){
                studentsName=studentTeacherPairMap.get(teacherName);
            }
            studentsName.add(studentName);
        }
        studentTeacherPairMap.put(teacherName,studentsName);
    }

    public void repoDeleteAllTeachers(){

        for(String teacher:studentTeacherPairMap.keySet()){
            for(String student: studentTeacherPairMap.get(teacher)){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            if(teacherMap.containsKey(teacher)){
                teacherMap.remove(teacher);
            }
            studentTeacherPairMap.remove(teacher);
        }
    }

    public Student repoGetStudentsByName(String studentName){
        return studentMap.get(studentName);
    }



    public List<String> repoGetAllStudents(){
        Set<String> getStudents=new HashSet<>();
        getStudents=studentMap.keySet();
        List<String> sList=new ArrayList<>();
        for(String s:getStudents){
            sList.add(s);
        }
        return sList;
    }

    public void repoDeleteTeacherByName(String teacherName){
        List<String> students=new ArrayList<>();
        if(studentTeacherPairMap.containsKey(teacherName)){
            for(String student:studentTeacherPairMap.get(teacherName)){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            studentTeacherPairMap.remove(teacherName);
        }
        if(teacherMap.containsKey(teacherName)){
            teacherMap.remove(teacherName);
        }
    }

    public Teacher repoGetTeacherByName(String teacherName){
        return teacherMap.get(teacherName);
    }

    public List<String> repoGetStudentsByTeacherName(String teacherName){
        List<String> students = new ArrayList<>();
        if(teacherMap.containsKey(teacherName)){
            students=studentTeacherPairMap.get(teacherName);
        }
        return students;
    }





}
