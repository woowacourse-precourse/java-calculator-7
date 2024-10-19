package calculator;

import java.util.ArrayList;
import java.util.List;

public class SeparatorManager {
    private static final List<Character> defaultSeparatorList = List.of(';', ',');
    private final List<Character> separatorList;

    public SeparatorManager(Character separator) {
        if (separator != null) {
            List<Character> tempSeparatorList = new ArrayList<>(defaultSeparatorList);
            tempSeparatorList.add(separator);
            separatorList = List.copyOf(tempSeparatorList);
        } else {
            separatorList = defaultSeparatorList;
        }
    }

    public List<Character> getSeparatorList() {
        return separatorList;
    }

    public List<String> getSeparatedStringNumber(String input) {
        List<String> separatedStringList = new ArrayList<>();
        int offset = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!separatorList.contains(input.charAt(i)) && !Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException();
            } else {
                separatedStringList.add(input.substring(offset, i));
                offset = i + 1;
            }
        }
        return separatedStringList;
    }
}
