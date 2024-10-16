package calculator.service;

import java.util.List;

public class CalculateSeparator {

    public static boolean checkContainSeparator(String userInput, String separator) {
        return !userInput.contains(separator);
    }

    public static List<String> splitWithSeparator(String userInput, String separator) {
        return List.of(userInput.split(separator));
    }

    public static Integer getIndexNumberOfSeparator(String userInput, String separator) {
        return userInput.indexOf(separator);
    }

    public static String substringUserInputWithSeparator(String userInput, Integer startIndex, Integer endIndex) {
        return userInput.substring(startIndex, endIndex);
    } //함수의 매개변수가 3개 -> 2개로 리팩토링 필요

    public static Integer getUserInputLength(String userInput) {
        return userInput.length();
    }
}
