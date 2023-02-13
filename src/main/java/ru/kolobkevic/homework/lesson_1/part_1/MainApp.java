package ru.kolobkevic.homework.lesson_1.part_1;

public class MainApp {
    public static void main(String[] args) {
        Manager manager = new Manager();

        manager.setBuilder(new RussianPersonBuilder());
//        manager.setBuilder(new AmericanPersonBuilder());
        Person person = manager.buildPerson();

        System.out.println(person);
    }
}
