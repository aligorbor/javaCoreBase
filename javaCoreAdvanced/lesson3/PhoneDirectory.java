package ru.geekbrains.javaCoreAdvanced.homeWork.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {
    private final HashMap<String, String> phoneAndName; //используется для быстрого поиска по номеру телефона
    private final HashMap<String, ArrayList<String>> nameAndPhone; //используется для быстрого поиска по фамилии

    public PhoneDirectory() {
        phoneAndName = new HashMap<>();
        nameAndPhone = new HashMap<>();
    }
    // Фамилия и телефон добавляются в два HashMap: phoneAndName - ключ телефон и nameAndPhone - ключ фамилия.
    // При добавлении новой записи осуществляется проверка наличия телефона в справочнике.
    // Если телефон есть и соответствует другой фамилии, телефон у старой фамилии удаляется и
    // добавляется к новой фамилии.
    public void add(String name, String phone) {
        if (phoneAndName.containsKey(phone)) {
            String oldName = phoneAndName.get(phone);
            if (!name.equals(oldName)) {
                ArrayList<String> listPhone = nameAndPhone.get(oldName);
                listPhone.remove(phone);
            }
        }
        if (nameAndPhone.containsKey(name)) {
            ArrayList<String> listPhone = nameAndPhone.get(name);
            if (!listPhone.contains(phone))
                listPhone.add(phone);
        } else {
            ArrayList<String> listPhone = new ArrayList<>();
            listPhone.add(phone);
            nameAndPhone.put(name, listPhone);
        }

        phoneAndName.put(phone, name);
    }

    public ArrayList<String> getPhone(String name) {
        return nameAndPhone.getOrDefault(name, null);
    }

    public String getName(String phone) {
        return phoneAndName.getOrDefault(phone, "В справочнике такого номера нет");
    }

}
