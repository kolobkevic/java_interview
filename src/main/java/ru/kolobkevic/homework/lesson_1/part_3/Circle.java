package ru.kolobkevic.homework.lesson_1.part_3;

public class Circle extends Figure {
    int radius = 3;
    String name = "Circle";

    @Override
    protected void Perimeter() {
        System.out.println("Периметр " + name + " равен " + Math.PI * 2 * radius);
    }
}
