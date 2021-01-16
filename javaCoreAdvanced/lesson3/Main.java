package ru.geekbrains.javaCoreAdvanced.homeWork.lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //1. Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        // Посчитать, сколько раз встречается каждое слово.
        String[] arrWords = new String[]{"Вася", "Петя", "Влад", "Надя", "Оля", "Антон", "Оля", "Антон", "Вася",
                "Петя", "Николай", "Вася", "Соня", "Оля", "Вася", "Надя", "Петя", "Вася", "Славик", "Антон", "Борис"};
        List<String> list = Arrays.asList(arrWords);
        System.out.println(list);
        Collections.sort(list);
        LinkedHashSet<String> set = new LinkedHashSet<>(list);
        System.out.println(set);
        for (String e : set) System.out.println(e + " " + (list.lastIndexOf(e) - list.indexOf(e) + 1));

        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.
        System.out.println();
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Иванов", "123456789");
        phoneDirectory.add("Петров", "344343443");
        phoneDirectory.add("Сидоров", "676554444");
        phoneDirectory.add("Иванов", "64464464644");
        phoneDirectory.add("Пупкин", "4444444444");
        phoneDirectory.add("Пупкин", "2222222222");
        phoneDirectory.add("Пупкин", "46646444");
        phoneDirectory.add("Иванов", "3333333333");
        phoneDirectory.add("Пупкин", "1111111111");
        phoneDirectory.add("Попандопуло", "7777777777");
        phoneDirectory.add("Попандопуло", "7777777777");

        System.out.println("Попандопуло " + phoneDirectory.getPhone("Попандопуло"));
        System.out.println("Иванов " + phoneDirectory.getPhone("Иванов"));

        phoneDirectory.add("Петров", "3333333333");
        phoneDirectory.add("Петров", "123456789");

        System.out.println("Иванов " + phoneDirectory.getPhone("Иванов"));
        System.out.println("Петров " + phoneDirectory.getPhone("Петров"));

        System.out.println("Пупкин " + phoneDirectory.getPhone("Пупкин"));

        phoneDirectory.add("ЗабралУПупкина", "1111111111");
        phoneDirectory.add("ЗабралУПупкина", "2222222222");
        phoneDirectory.add("ЗабралУПупкина", "4444444444");

        System.out.println("ЗабралУПупкина " + phoneDirectory.getPhone("ЗабралУПупкина"));

        System.out.println("Пупкин " + phoneDirectory.getPhone("Пупкин"));

        System.out.println("Кто владелец телефона 7777777777 ? " + phoneDirectory.getName("7777777777"));
        System.out.println("Кто владелец телефона 8888888888 ? " + phoneDirectory.getName("8888888888"));
    }

}
