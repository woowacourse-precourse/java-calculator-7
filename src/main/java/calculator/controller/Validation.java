package calculator.controller;

import java.util.List;

public class Validation {

    public static void VerifyInput(List<String> numberStringList) {
        for (String numberString : numberStringList) {
            try {
                Integer.valueOf(numberString);
                if (numberString.contains("-")) {
                    throw new IllegalArgumentException("잘못된 입력값 입니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
        }
    }
}
