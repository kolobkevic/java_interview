package ru.kolobkevic.homework.lesson_1.part_1;

public abstract class PersonBuilder {
    protected Person person;

    void createPerson(){
        person = new Person();
    }

    abstract void withFirstName();
    abstract void withLastName();
    abstract void withMiddleName();
    abstract void withCountry();
    abstract void withAddress();
    abstract void withPhone();
    abstract void withAge();
    abstract void withGender();

    public Person getPerson(){
        return person;
    }
}