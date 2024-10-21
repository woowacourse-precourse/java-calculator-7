package calculator;

import java.util.ArrayList;

public class Calculator {
    String numberString; // 구분자와 숫자만 들어있는 문자열
    ArrayList<Character> separatorList; // 구분자 종류

    // Calulator 인스턴스를 생성하며 Custom구분자를 추가
    public Calculator(String input) {
        separatorList = new ArrayList<>();
        separatorList.add(',');
        separatorList.add(':');
        getCustomSeparator(input);
    }

    // input을 통해 구분자를 list에 저장하고, numberString을 추출해낸다.
    public void getCustomSeparator(String input) throws IllegalArgumentException {
        if(input.length()<6)
            numberString = input;
        else if (input.substring(0, 2).equals("//") && input.substring(3,5).equals("\\n")) {
            char customSeparator = input.charAt(2);
            if (customSeparator > '0' && customSeparator < '9')
                throw new IllegalArgumentException();
            separatorList.add(customSeparator);
            numberString = input.substring(5, input.length());
        }
        else
            numberString=input;
    }


}
