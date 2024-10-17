package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
    private ArrayList<String> delimiterList;
    private final String customDelimiterRegex = "//(.)\n";
    private ArrayList<Integer> numberList;

    public CalculatorModel() {
        delimiterList = new ArrayList<>();
        delimiterList.add(",");
        delimiterList.add(":");
        numberList = new ArrayList<>();
    }

    //커스텀 구분자 확인 및 설정하기
    public String checkCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(customDelimiterRegex + "(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            setDelimiter(delimiter);
            return matcher.group(2);
        } else {
            return input;
        }
    }

    //구분자 추가하기
    public void setDelimiter(String delimiter) {
        delimiterList.add(delimiter);
    }

    // 숫자 목록 초기화 시키기
    public void resetNumberList() {
        numberList.clear();
    }

    //숫자와 구분자 필터링하기
    public void filterInput(String input) {
        StringBuilder numberString = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (delimiterList.contains(String.valueOf(ch)) && (!numberString.isEmpty())) {
                numberList.add(Integer.parseInt(numberString.toString()));
                numberString.setLength(0);
            } else if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("Invalid input");
            } else {
                numberString.append(ch);
            }
        }

        if (!numberList.isEmpty()) {
            numberList.add(Integer.parseInt(numberString.toString()));
            numberString.setLength(0);
        }
    }


}
