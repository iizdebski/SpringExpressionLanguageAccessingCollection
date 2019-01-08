package com.izdebski.client;

import com.izdebski.model.Student;
import com.izdebski.model.StudentListAccessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");

        StudentListAccessor studentListAccessor = ctx.getBean("studentListAccessor", StudentListAccessor.class);

        Student student = studentListAccessor.getThirdStudentInList();
        System.out.println("Third student in the List:::");
        System.out.println(student.getName()+"\t"+student.getMarks());

        System.out.println("-----------------------------------------");

        List<String> studentNames = studentListAccessor.getStudentNames();
        System.out.println("Names of Student int the list:");
        for (String name : studentNames){
            System.out.println(name);
        }
        List<Student> failedStudents = studentListAccessor.getFailedStudents();
        System.out.println("List of failed students");
        for (Student student2 : failedStudents){

            System.out.println(student2.getName()+"\t" + student2.getMarks());

        }
    }
}