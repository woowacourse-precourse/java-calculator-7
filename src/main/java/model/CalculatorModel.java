package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorModel {
    private static ArrayList<Character> delimiterList;
    private static final String customDelimiterRegex = "^//(.)\\\\n";
    private static ArrayList<Integer> numberList;

    public CalculatorModel() {
        delimiterList = new ArrayList<>();
        delimiterList.add(',');
        delimiterList.add(';');
        numberList = new ArrayList<>();
    }

    //커스텀 구분자 확인 및 설정하기
    public String checkCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile(customDelimiterRegex + "(.*)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            char delimiter = matcher.group(1).toCharArray()[0];
            setDelimiter(delimiter);
            return matcher.group(2);
        } else {
            return input;
        }
    }

    //구분자 추가하기
    public void setDelimiter(char delimiter) {
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
            if (delimiterList.contains(ch)) {
                if (!numberString.isEmpty()) {
                    numberList.add(Integer.parseInt(numberString.toString()));
                    numberString.setLength(0);
                }
            } else if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException("Invalid input");
            } else {
                numberString.append(ch);
            }
        }

        if (!numberString.isEmpty()) {
            numberList.add(Integer.parseInt(numberString.toString()));
            numberString.setLength(0);
        }
    }

    // 숫자들의 합 계산하기
    public int addNumber() {
        int sum = 0;
        for (int number : numberList) {
            sum += number;
        }
        return sum;
    }
}
