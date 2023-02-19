package ru.kolobkevic.homework.lesson_1.part_3;

public class Rectangle extends Figure{
    int a = 10;
    String name = "Rectangle";

    @Override
    protected void perimeter() {
        System.out.println("Периметр " + name + " равен " + 4 * a);
    }
}
