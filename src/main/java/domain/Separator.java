package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private final List<String> separatorCollection;

    public Separator(List<String> separatorCollection) {
        this.separatorCollection = new ArrayList<>(separatorCollection);
        defaultSeparator();
    }

    private void defaultSeparator() {
        if (!separatorCollection.contains(",")) {
            separatorCollection.add(",");
        }
        if (!separatorCollection.contains(":")) {
            separatorCollection.add(":");
        }
    }

    public void findAndAddSeparator(String inputString) {
        Pattern pattern = Pattern.compile("/\\/(.*?)\\n");
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
            String separator = matcher.group(1);
            if (!separatorCollection.contains(separator)) {
                separatorCollection.add(separator);
            }
        }
        defaultSeparator();
    }

    public List<Integer> extractionNumbers(String inputString) {
        List<Integer> numberCollection = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();
        boolean isSeparator;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            isSeparator = false;
            for (String separator : separatorCollection) {
                isSeparator = isSeparator || separator.indexOf(currentChar) != -1;
            }
            if (isSeparator) {
                if (!currentNumber.isEmpty()) {
                    int number = Integer.parseInt(currentNumber.toString());
                    if (number <= 0) {
                        throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
                    }
                    numberCollection.add(number);
                    currentNumber.setLength(0);
                }
            }
            if (!isSeparator) {
                currentNumber.append(currentChar);
            }
        }
        if (!currentNumber.isEmpty()) {
            int number = Integer.parseInt(currentNumber.toString());
            if (number <= 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 입력할 수 없습니다.");
            }
            numberCollection.add(number);
        }
        return numberCollection;
    }

    public List<String> getSeparatorCollection() {
        return separatorCollection;
    }
}
