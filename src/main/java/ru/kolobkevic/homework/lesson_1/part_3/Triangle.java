package ru.kolobkevic.homework.lesson_1.part_3;

public class Triangle extends Figure {
    String name = "Triangle";
    int a = 5, b = 4, c = 3;

    @Override
    protected void perimeter() {
        System.out.println("Периметр " + name + " равен " + (a + b + c));
    }
}
