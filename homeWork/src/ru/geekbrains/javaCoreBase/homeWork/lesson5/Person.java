package ru.geekbrains.javaCoreBase.homeWork.lesson5;

import java.util.Scanner;

public class Person {
    private static int id;
    private int idPers;
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String name, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        id++;
        idPers = id;
    }

    @Override
    public String toString() {
        return "Сотрудник {" +
                "ID:'" + idPers + '\'' +
                ", Имя:'" + name + '\'' +
                ", Должность:'" + position + '\'' +
                ", email:'" + email + '\'' +
                ", тел.'" + phone + '\'' +
                ", оклад:" + salary +
                ", возраст:" + age +
                '}';
    }

    public void info(){
        System.out.println("Экземпляр класса Person: " + this);
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Person[] persArray = new Person[5];
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "i vivan@mailbox.com" , "892312312", 30000, 30);
        persArray[1] = new Person("Petrov Petr", "manager", "p petr@mailbox.com" , "892312312", 20000, 28);
        persArray[2] = new Person("Sidorov Sidor", "director", "s sidor@mailbox.com" , "892312312", 40000, 45);
        persArray[3] = new Person("Pupkin Vasia", "technician", "p vazia@mailbox.com" , "892312312", 20000, 25);
        persArray[4] = new Person("Premudraia Vasilisa", "secretary", "premudraia@mailbox.com" , "892312312", 100000, 50);

        for (int i = 0; i < persArray.length; i++) {
            persArray[i].info();
        }
        System.out.println("Информацию о сотрудниках, старше скольких лет требуется узнать? Введите возраст: ");
        int olderAge = sc.nextInt();
        for (int i = 0; i < persArray.length; i++) {
            if(persArray[i].getAge() > olderAge)
                persArray[i].info();
        }
    }
}
