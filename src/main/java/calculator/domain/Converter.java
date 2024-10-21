package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private final static Converter CONVERTER = new Converter();
    private final List<String> delimiterList = new ArrayList<>();

    private Converter() {
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public static Converter getInstance() {
        return CONVERTER;
    }

    public List<Number> convertWordsToNumberList(String words) {
        List<String> dirtyStringList = separateWords(words);
        List<String> cleanStringLIst = cleanWordList(dirtyStringList);

        return castStringListToNumberList(cleanStringLIst);
    }

    public List<String> separateWords(String words) {
        String cleanStrings = findCustomerDelimiter(words);
        String delimiterRegex = getDelimiterRegex();

        return List.of(cleanStrings.split(delimiterRegex));
    }


    public String findCustomerDelimiter(String words) {
        for (int i = 0; i < words.length() - 5; i++) {
            isCustomDelimiterIfExist(words.substring(i, i + 5));
        }
        words = words.replaceAll("//.\\\\n", "");
        return words;
    }

    public List<String> getDelimiterList() {
        return List.copyOf(delimiterList);
    }

    private void isCustomDelimiterIfExist(String word) {
        if (word.matches("//.\\\\n"))
            delimiterList.add(word.substring(2, 3));
    }

    private List<String> cleanWordList(List<String> dirtyWords) {
        return dirtyWords.stream()
                .map(String::trim)
                .toList();
    }

    private List<Number> castStringListToNumberList(List<String> wordList) {
        return wordList.stream()
                .map(this::castStringToNumber)
                .collect(Collectors.toList());
    }

    private Number castStringToNumber(String word) {
        try {
            if (word.isEmpty())
                return new Number(0);
            Integer integer = Integer.valueOf(word);
            validatePositiveNumber(integer);
            return new Number(integer);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("옳지 못한 입력");
        }
    }

    private void validatePositiveNumber(Integer integer) throws NumberFormatException {
        if (integer < 0)
            throw new NumberFormatException();
    }

    private String getDelimiterRegex() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < delimiterList.size(); i++) {
            sb.append(delimiterList.get(i));
            if (i != delimiterList.size() - 1)
                sb.append("|");
        }
        return sb.toString();
    }


}
