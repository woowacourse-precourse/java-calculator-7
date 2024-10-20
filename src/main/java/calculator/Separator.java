package calculator;

import java.util.ArrayList;
import java.util.List;

public class Separator {
    private static final List<Character> defaultDividers = List.of(':', ',');
    private final List<Character> dividers;

    public Separator(Character divider) {
        if (divider == null || defaultDividers.contains(divider)) {
            dividers = defaultDividers;
        } else {
            List<Character> tempDividers = new ArrayList<>(defaultDividers);
            tempDividers.add(divider);
            dividers = List.copyOf(tempDividers);
        }
    }

    public List<Character> getDividers() {
        return dividers;
    }

    public List<String> separate(String input) {
        List<String> separatedString = new ArrayList<>();
        int offset = 0;

        for (int i = 0; i < input.length(); i++) {
            if(dividers.contains(input.charAt(i))) {
                if(offset < i){
                    separatedString.add(input.substring(offset, i));
                }
                offset = i + 1;
            } else if (Character.isDigit(input.charAt(i))) {
            } else {
                throw new IllegalArgumentException("잘못된 입력값입니다.");
            }
        }

        if(offset < input.length()) {
            separatedString.add(input.substring(offset));
        }

        return separatedString;
    }
}
