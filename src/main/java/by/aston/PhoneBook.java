package by.aston;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            phoneBook.get(lastName).add(phoneNumber);
        } else {
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(lastName, phoneNumbers);
        }
    }

    public Set<String> get(String lastName) {
        return phoneBook.get(lastName);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }
}
