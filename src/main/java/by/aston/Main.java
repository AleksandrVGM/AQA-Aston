package by.aston;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "two", "three", "four", "ten", "four", "two", "three", "four", "five"};
        System.out.println("All words: " + Arrays.asList(words));
        System.out.println("Unique words: " + getUniqueWords(words));
        System.out.println("Number of each word: " + countNumberOfWords(words));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Gates", "+37529");
        phoneBook.add("Gates", "+37528");
        phoneBook.add("Gates", "+37527");
        phoneBook.add("Brin", "+37524");
        phoneBook.add("Page", "+37522");
        System.out.println(phoneBook);
        System.out.println("List of phone numbers for Gates:" + phoneBook.get("Gates"));
    }

    public static Set<String> getUniqueWords(String[] words) {
        Set<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords;
    }

    public static Map<String, Integer> countNumberOfWords(String[] words) {
        Map<String, Integer> numberOfWords = new LinkedHashMap<>();
        for (String word : words) {
/*            if (numberOfWords.containsKey(word)) {
                int number = numberOfWords.get(word);
                number++;
                numberOfWords.put(word, number);
            } else {
                numberOfWords.put(word, 1);
            }
            */

            numberOfWords.computeIfPresent(word, (k,v) -> v+1);
            numberOfWords.putIfAbsent(word, 1);
//            numberOfWords.merge(word, 1, (v1,v2)-> v1+1);
        }
        return numberOfWords;
    }
}