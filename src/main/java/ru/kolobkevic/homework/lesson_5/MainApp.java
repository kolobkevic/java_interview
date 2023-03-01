package ru.kolobkevic.homework.lesson_5;

import ru.kolobkevic.homework.lesson_5.crud.SessionFactoryUtils;
import ru.kolobkevic.homework.lesson_5.dao.StudentDao;
import ru.kolobkevic.homework.lesson_5.entity.Student;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactoryUtils factory = new SessionFactoryUtils();
        StudentDao studentDao = new StudentDao(factory);



        try {
            for (int i = 1; i <= 1000; i++) {
                studentDao.save(new Student("Ivan_" + i, Math.random() * 4 + 1));
            }
            System.out.println("Added 1000 students");

            studentDao.deleteById(1000L);
            System.out.println("Student with id=1000 is deleted");

            Student student = studentDao.findById(1L);
            student.setName("Anton");
            student.setMark(5.0);
            studentDao.update(student);
            System.out.println("Student with id=1 was changed");
            System.out.println(studentDao.findById(1L));

            List<Student> students = studentDao.findAll();
            System.out.printf("There are %d records \n", students.size());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.shutdown();
        }
    }
}
