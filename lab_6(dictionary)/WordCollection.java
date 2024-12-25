package dictionary;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class WordCollection {

    private Map<Character, List<String>> wordsMap;

    public WordCollection() {
        wordsMap = new HashMap<>();

        for (char c = 'A'; c <= 'Z'; c++) {
            wordsMap.put(c, new ArrayList<>());
        }
    }


    public void addWord(String word) {
        if (word != null && !word.isEmpty()) {
            char firstChar = Character.toUpperCase(word.charAt(0));
            if (wordsMap.containsKey(firstChar)) {
                wordsMap.get(firstChar).add(word);

                Collections.sort(wordsMap.get(firstChar));
            }
        }
    }


    public void printAllWords() {
        for (Map.Entry<Character, List<String>> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    public void printWordsByLetter(char letter) {
        letter = Character.toUpperCase(letter);
        if (wordsMap.containsKey(letter)) {
            System.out.println(letter + ": " + wordsMap.get(letter));
        } else {
            System.out.println("No words found for the letter: " + letter);
        }
    }}