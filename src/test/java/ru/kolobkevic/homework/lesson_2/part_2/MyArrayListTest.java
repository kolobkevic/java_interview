package ru.kolobkevic.homework.lesson_2.part_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MyArrayListTest {

    @Test
    void add() {
        MyArrayList myArrayList = new MyArrayList<>();
        String s = "example";
        String s1 = "example1";
        Assertions.assertTrue(myArrayList.add(s));
        Assertions.assertTrue(myArrayList.add(s1));
    }

    @Test
    void remove() {
        MyArrayList myArrayList = new MyArrayList<>();
        String s = "example";
        String s1 = "example1";
        myArrayList.add(s);
        myArrayList.add(s1);
        Assertions.assertEquals(s1, myArrayList.remove(1));
    }

    @Test
    void get() {
        MyArrayList myArrayList = new MyArrayList<>();
        String s = "example";
        String s1 = "example1";
        myArrayList.add(s);
        myArrayList.add(s1);
        Assertions.assertEquals(s, myArrayList.get(0));
    }
}