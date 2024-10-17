package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public int add(String input) {

        //공백인 경우 0을 반환함
        if (input.isEmpty()) {
            return 0;
        }

        String delimeter = "";

        //입력값 앞부분이 '//'인 경우 customDelimeter 실행함
        if (input.startsWith("//")) {
            String[] customResult = customDelimeter(input);
            delimeter = customResult[0];
            input = customResult[1];
        }


    }

    //커스텀 구분자 추출 후 커스텀 구분자와 커스텀 구분자를 제거한 입력값을 반환
    public String[] customDelimeter(String input) {
        int index = input.indexOf('\n');
        String delimiter = input.substring(2, index);
        String newInput = input.substring(index + 1);
        return new String[]{delimiter, newInput};
    }

    public List<Integer> extractNumbers(String input, String delimiter) {
        //입력값에서 구분자를 기준으로 숫자 추출
        String[] extracted = input.split("[,:" + delimiter + "]");
        List<Integer> numbers = new ArrayList<>();
        //정수형 리스트로 변환
        for (String a : extracted) {
            //예외 처리 - 음수, 숫자가 아닌경우
            try {
                int number = Integer.parseInt(a);
                if (number < 0) {
                    throw new IllegalArgumentException();
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return numbers;
    }

}
