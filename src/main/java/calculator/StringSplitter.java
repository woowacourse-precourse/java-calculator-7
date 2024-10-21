package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringSplitter {
    private String inputString;
    private Delimiters delimiters;

    public StringSplitter(String inputString, Delimiters delimiters) {
        this.inputString = inputString;
        this.delimiters = delimiters;
    }

    public void setSplitter(String inputString, Delimiters delimiters) {
        this.inputString = inputString;
        this.delimiters = delimiters;
    }

    public List<Integer> splitString() {
        String regex = "[" + delimiters.getDelimiters().stream()
                .map(String::valueOf)
                .collect(Collectors.joining()) + "]";

        String[] splitString = inputString.split(regex);
        List<Integer> numbers = new ArrayList<>();

        for (String part : splitString) {
            if (!part.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("구분자를 잘못 입력하였습니다.");
            }
            numbers.add(Integer.parseInt(part));
        }

        return numbers;
    }
}
