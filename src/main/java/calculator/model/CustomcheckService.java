package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class CustomcheckService {

    public List<Integer> nonCustom(String input) {


        if(!(input.charAt(0) ==',') && !(input.charAt(0) ==':') && !Character.isDigit(input.charAt(0))) {
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