package ru.kolobkevic.homework.lesson_2.part_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MyLinkedListTest {

    @Test
    void add() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        int a = 1;
        String s = "asdasd";

        Assertions.assertTrue(myLinkedList.add(a));
        Assertions.assertTrue(myLinkedList.add(s));
    }

    @Test
    void addFirst() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.addFirst(s);
        Assertions.assertEquals(s, myLinkedList.getFirst());
    }

    @Test
    void addLast() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.addLast(s);
        Assertions.assertEquals(s, myLinkedList.getLast());
    }

    @Test
    void removeFirst() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.addFirst(s);
        Assertions.assertEquals(s, myLinkedList.removeFirst(s));
    }

    @Test
    void removeLast() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.addLast(s);
        Assertions.assertEquals(s, myLinkedList.removeLast(s));
    }

    @Test
    void remove() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.add(s);
        Assertions.assertTrue(myLinkedList.remove(s));
    }

    @Test
    void testRemove() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        String s1 = "example1";
        myLinkedList.add(s);
        myLinkedList.add(s1);
        Assertions.assertEquals(s1, myLinkedList.remove(1));
    }


    @Test
    void get() {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        myLinkedList.add(s);
        Assertions.assertEquals(s, myLinkedList.get(0));
    }

    @Test
    void getLast(){
        MyLinkedList myLinkedList = new MyLinkedList<>();
        String s = "example";
        String s1 = "example1";
        myLinkedList.add(s);
        myLinkedList.add(s1);
        Assertions.assertEquals(s1, myLinkedList.getLast());
    }
}