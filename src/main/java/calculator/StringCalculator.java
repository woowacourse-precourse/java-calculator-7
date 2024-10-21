package calculator;

public class StringCalculator {

    private String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자

        return input.split(delimiter);
    }
}