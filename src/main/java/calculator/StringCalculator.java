package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    // 문자열에서 숫자를 추출하는 메서드 extractNumToString
    public List<Integer> extractNumToString(String input) {

        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNum = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i); // 입력한 문자열에서 해당 인덱스 문자를 가져옴
            if (Character.isDigit(c)) {
                currentNum.append(c); // 숫자면 currentNum에 추가
            }
            else if (currentNum.length() > 0) {
                numbers.add(Integer.parseInt(currentNum.toString())); // 현재 숫자 리스트에 추가
                currentNum.setLength(0); // currentNum 초기화
            }
        }

        if (currentNum.length() > 0) { // 문자열 끝에 숫자가 남아있으면 추가
            numbers.add(Integer.parseInt(currentNum.toString()));
        }

        return numbers; // 추출한 숫자 리스트를 반환함.
    }

    // 추출한 숫자들의 합을 구하는 메서드 add
    public int add(String input) {

        List<Integer> numbers = extractNumToString(input);
        return numbers.stream().mapToInt(Integer::intValue).sum(); // 리스트의 모든 숫자를 더하여 반환함.

    }

}
