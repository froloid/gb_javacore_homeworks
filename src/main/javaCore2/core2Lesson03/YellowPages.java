package core2Lesson03;

import java.util.ArrayList;
import java.util.HashMap;

public class YellowPages {
    private HashMap<String, ArrayList<String>> phonesBase;

    YellowPages() {
        this.phonesBase = new HashMap<String, ArrayList<String>>();
    }

    public void add(String firstName, String phoneNumber) {
        if (phonesBase.containsKey(firstName)) {
            var numberArray = phonesBase.get(firstName);
            int indexNumber = numberArray.indexOf(phoneNumber);
            if (indexNumber == -1) {
                numberArray.add(phoneNumber);
                System.out.printf("Номер добавлен. Для <%s> в базе зарегистрированы номера <%s>\n", firstName, numberArray);
            } else {
                System.out.printf("Для <%s> в базе уже зарегистрирован номер <%s>\n", firstName, numberArray);
            }
        } else {
            var numberArray = new ArrayList<String>();
            numberArray.add(phoneNumber);
            phonesBase.put(firstName, numberArray);
            System.out.printf("Номер добавлен. Для <%s> в базе зарегистрированы номера <%s>\n", firstName, numberArray);
        }
    }

    public ArrayList<String> get(String firstName) {
        var foundNumber = phonesBase.get(firstName);
        if (foundNumber == null) {
            System.out.printf("В базе номеров нет данных для <%s>\n", firstName);
        } else {
            System.out.printf("Для <%s> найдено номеров: %s %s\n", firstName, foundNumber.size(), foundNumber);
        }

        return foundNumber;
    }
}
