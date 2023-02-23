package ru.kolobkevic.homework.lesson_1.part_3;

import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Figure circleFigure = new Circle();
        Figure triangleFigure = new Triangle();
        Figure rectangleFigure = new Rectangle();

        List<Figure> figures = Arrays.asList(circleFigure, triangleFigure, rectangleFigure);
        for(Figure f: figures){
            f.perimeter();
        }
    }
}
