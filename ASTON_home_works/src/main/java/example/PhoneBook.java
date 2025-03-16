package example;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<Integer, String> contacts = new HashMap<>();

    public void addContact(int number, String name) {
        contacts.put(number, name);
    }

    public Map<Integer, String> getNumber(String name) {
        Map<Integer, String> map = new HashMap<>();

        for (Map.Entry<Integer, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(name))
                map.put(entry.getKey(), entry.getValue());
        }

        if (map.isEmpty()) throw new IllegalArgumentException("Фамилия не найдена.");
        else return map;
    }
}
