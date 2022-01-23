package core2Lesson03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ArraySandbox {

    public static void main(String[] args) {
        var wordSet = new WordSet();
        var mapCounter = wordSet.getMapCounter();

        System.out.printf("Задача 1.1 Уникальные слова в нашем массиве: %s\n", mapCounter.keySet());

        System.out.println("Задача 1.2 Ниже список уникальных слов и частота их появления:");
        for (Map.Entry<String, Integer> entry: mapCounter.entrySet()) {
            System.out.printf(" Слово: %s, вхождений: %s\n", entry.getKey(), entry.getValue());
        }

        System.out.println();
        System.out.println();

        var phoneBase = new YellowPages();

        phoneBase.add("Петров", "+71382007472");
        phoneBase.add("Иванов", "+71382001183");
        phoneBase.add("Петров", "+71382007472");
        phoneBase.add("Петров", "+71382000929");
        phoneBase.get("Петров");
        phoneBase.get("Иванов");
        phoneBase.get("Тришкин");
    }
}

