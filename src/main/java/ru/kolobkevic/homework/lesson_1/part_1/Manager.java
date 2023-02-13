package ru.kolobkevic.homework.lesson_1.part_1;

public class Manager {
    PersonBuilder builder;

    public void setBuilder(PersonBuilder personBuilder) {
        this.builder = personBuilder;
    }

    Person buildPerson(){
        builder.createPerson();
        builder.withFirstName();
        builder.withLastName();
        builder.withMiddleName();
        builder.withCountry();
        builder.withAddress();
        builder.withPhone();
        builder.withAge();
        builder.withGender();

        return builder.getPerson();
    }
}
