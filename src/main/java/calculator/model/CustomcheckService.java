package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CustomcheckService {

    // 입력된 문자열을 체크하는 메소드
    public List<Integer> checked(String input) {
        if (input.charAt(0) == '/') {
            return Custom((input));
        }

        return nonCustom(input);
    }


    public List<Integer> Custom(String input) {
        if (input.length() >= 5 && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            String customword = String.valueOf(input.charAt(2));
            return customsum(input);
        }
        throw new IllegalArgumentException("문자 오류");

    }

    private static List<Integer> customsum(String input) {

        String word = "";
        char delimiter = input.charAt(2);
        List<Integer> list = new ArrayList<>();

        for (int i = 5; i < input.length(); i++) {

            char currentChar = input.charAt(i);

            if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != delimiter && input.charAt(i) != '-') {
                throw new IllegalArgumentException("문자 오류");
            }

            if (Character.isDigit(currentChar)) {
                word += currentChar;
            }

            if (input.charAt(i) == delimiter) {

                if (!word.isEmpty()) {
                    list.add(Integer.parseInt(word));
                    word = "";
                }
            }
        }

        if (!word.isEmpty()) {
            list.add(Integer.parseInt(word));
        }

        return list;
    }

    public List<Integer> nonCustom(String input) {

        if (!(input.charAt(0) == ',') && !(input.charAt(0) == ':') && !Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다");
        }

        String word = "";
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) && (input.charAt(i) != ',') && (input.charAt(i) != ':')) {
                throw new IllegalArgumentException("문자 오류");
            }

            if (Character.isDigit(input.charAt(i))) {
                word += input.charAt(i);
            }

            if (input.charAt(i) == ',' || input.charAt(i) == ':') {
                list.add(Integer.parseInt(word));
                word = "";
            }
        }

        if (!word.isEmpty()) {
            list.add(Integer.parseInt(word));
        }

        return list;
    }


}