package calculator;

import java.util.ArrayList;
import java.util.List;

public class SeparatorManager {
    private static final List<Character> defaultSeparatorList = List.of(';', ',');
    private final List<Character> separatorList;

    public SeparatorManager(Character separator) {
        if (separator == null || defaultSeparatorList.contains(separator)) {
            separatorList = defaultSeparatorList;
        } else {
            List<Character> tempSeparatorList = new ArrayList<>(defaultSeparatorList);
            tempSeparatorList.add(separator);
            separatorList = List.copyOf(tempSeparatorList);
        }
    }

    public List<Character> getSeparatorList() {
        return separatorList;
    }

    public List<String> getSeparatedStringNumber(String input) {
        List<String> separatedStringList = new ArrayList<>();
        int offset = 0;

        for (int i = 0; i < input.length(); i++) {
            if(separatorList.contains(input.charAt(i))) {
                if(offset < i){
                    separatedStringList.add(input.substring(offset, i));
                }
                offset = i + 1;
            } else if (Character.isDigit(input.charAt(i))) {
            } else {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
        }

        if(offset < input.length()) {
            separatedStringList.add(input.substring(offset));
        }

        return separatedStringList;
    }
}
