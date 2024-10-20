package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    private List<String> delimiterList = new ArrayList<>();

    public Converter() {
        delimiterList.add(",");
        delimiterList.add(":");
    }

    public List<Number> convertWordsToString(String words){
        List<String> stringList = separateWords(words);
        return stringList.stream()
                .map(this::parsingNumber)
                .collect(Collectors.toList());
    }

    public List<String> separateWords(String words) {
        String cleanWord = findCustomerDelimiter(words);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < delimiterList.size(); i++) {
            sb.append(delimiterList.get(i));
            if (i != delimiterList.size() - 1)
                sb.append("|");
        }
        String delimiterRegex = sb.toString();
        return List.of(cleanWord.split(delimiterRegex));
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

    private Number parsingNumber(String word){
        try{
            if(word.isEmpty())
                return new Number(0);
            Integer integer = Integer.valueOf(word);
            return new Number(integer);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("옳지 못한 입력");
        }
    }


}
