package core2Lesson03;

import java.util.ArrayList;
import java.util.HashMap;

public class WordSet {
    private ArrayList<String> words;

    WordSet() {
        this.words = new ArrayList<>();
        this.words.add("Слон");
        this.words.add("Гранат");
        this.words.add("Донбас");
        this.words.add("Ветер");
        this.words.add("Память");
        this.words.add("Гранат");
        this.words.add("Инициализация");
        this.words.add("Старовер");
        this.words.add("Признание");
        this.words.add("Гранат");
        this.words.add("Ветер");
        this.words.add("Мелодия");
        this.words.add("Абстракция");
    }

    public HashMap<String, Integer> getMapCounter() {
        var mapCounter = new HashMap<String, Integer>();

        for (String word : words ) {
            mapCounter.merge(word, 1, (currentValue, increment) -> currentValue + increment);
        }

        return  mapCounter;
    }
}
