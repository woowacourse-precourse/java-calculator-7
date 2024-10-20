package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    // 문자열에서 숫자를 추출하는 메서드 extractNumToString
    public List<Integer> extractNumToString(String input) {

        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNum = new StringBuilder();
        boolean isNegative = false; // 음수를 감지하는 플래그

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i); // 입력한 문자열에서 해당 인덱스 문자를 가져옴

            if (c == '-') { // '-' 기호가 있으면 음수임
                isNegative = true;
            }

            else if (Character.isDigit(c)) {
                currentNum.append(c); // 숫자면 currentNum에 추가
            }
            else if (currentNum.length() > 0) {
                int num = Integer.parseInt(currentNum.toString());
                if (isNegative) {
                    num = -num;
                }

                if (num <= 0) {
                    throw new IllegalArgumentException();
                }
                numbers.add(Integer.parseInt(currentNum.toString())); // 현재 숫자 리스트에 추가
                currentNum.setLength(0); // currentNum 초기화
                isNegative = false; // 플래그 초기화
            }
        }

        if (currentNum.length() > 0) { // 문자열 끝에 숫자가 남아있으면 추가
            int num = Integer.parseInt(currentNum.toString());
            if (isNegative) {
                num = -num;
            }
            if (num <= 0) {
                throw new IllegalArgumentException();
            }

            numbers.add(num);

        }

        return numbers; // 추출한 숫자 리스트를 반환함.
    }

    // 추출한 숫자들의 합을 구하는 메서드 add
    public int add(String input) {

        List<Integer> numbers = extractNumToString(input);
        return numbers.stream().mapToInt(Integer::intValue).sum(); // 리스트의 모든 숫자를 더하여 반환함.

    }

}
