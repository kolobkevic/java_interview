package ru.kolobkevic.homework.lesson_1.part_1;

public class AmericanPersonBuilder extends PersonBuilder{
    @Override
    void withFirstName() {
        person.setFirstName("Joe");
    }

    @Override
    void withLastName() {
        person.setLastName("Biden");
    }

    @Override
    void withMiddleName() {
        person.setMiddleName("");
    }

    @Override
    void withCountry() {
        person.setCountry("USA");
    }

    @Override
    void withAddress() {
        person.setAddress("Some address in USA");
    }

    @Override
    void withPhone() {
        person.setPhone("+12059180000");
    }

    @Override
    void withAge() {
        person.setAge(25);
    }

    @Override
    void withGender() {
        person.setGender("Male");
    }
}
