package calculator.service;

import calculator.exception.UserErrorMessage;
import calculator.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 구분자와 숫자를 나누어서 리스트에 저장
public class CalculatorService {

    private static String s = ""; // 사용자 입력 문자열

    // 입력값 받아오기
    public static void getNumbersFromUser() {
        s = InputView.userInput();
    }

    // 입력받은 문자열에서 구분자를 리스트에 저장
    public static List<String> getSeparator() {
        getNumbersFromUser();
        List<String> separator = new ArrayList<String>(); // 구분자 저장

        separator.add(",");
        separator.add(":");

        // 커스텀 구분자 저장
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                int index = s.indexOf("\\n");
                String a = s.substring(i + 2, index); // 커스텀 구분자
                separator.add(a);
            }
        }
        return separator;
    }

    // 계산할 숫자를 리스트에 저장
    public static List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<Integer>(); // 수 저장
        List<String> separator = getSeparator(); // 구분자 저장 리스트

        String result = s.replace("//", "");
        result = result.replace("\\n", "");

        String separatorSet = String.join("", separator);
        StringTokenizer st = new StringTokenizer(result, separatorSet);

        try {
            while (st.hasMoreTokens()) {
                String temp = st.nextToken();
                if(Integer.parseInt(temp) <= 0) {
                    throw new IllegalArgumentException(UserErrorMessage.MINUS_INVALID_MESSAGE);
                } else {
                    numbers.add(Integer.parseInt(temp));
                }
            }
        } catch(NumberFormatException e) {
            System.out.println(UserErrorMessage.INCLUDE_CHARACTER_MESSAGE);
        }
        return numbers;
    }
}
