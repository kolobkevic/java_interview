package ru.kolobkevic.homework.lesson_1.part_1;

public class RussianPersonBuilder extends PersonBuilder{
    @Override
    void withFirstName() {
        person.setFirstName("Ivan");
    }

    @Override
    void withLastName() {
        person.setLastName("Ivanov");
    }

    @Override
    void withMiddleName() {
        person.setMiddleName("Ivanovich");
    }

    @Override
    void withCountry() {
        person.setCountry("Russia");
    }

    @Override
    void withAddress() {
        person.setAddress("Some address in Russia");
    }

    @Override
    void withPhone() {
        person.setPhone("+79289180000");
    }

    @Override
    void withAge() {
        person.setAge(20);
    }

    @Override
    void withGender() {
        person.setGender("Male");
    }
}
