package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    // 기본 구분자
    List<String> separators = List.of(",", ":");

    public int run(String input) {
        List<String> numberStringAndCustomSeparator = findCustomSeparator(input);
        List<String> separators = List.of(",", ":", numberStringAndCustomSeparator.get(1));
        String numberString = numberStringAndCustomSeparator.get(0);

        List<Integer> numbers = getNumber(numberString, separators);
        int result = sumNumbers(numbers);

        return result;
    }

    // 커스텀 구분자 저장
    // return[0] : 커스텀 구분자 부분을 없앤 문자열
    // return[1] : //와 \n을 없앤 커스텀 구분자
    public List<String> findCustomSeparator(String input) {
        // //구분자\n
        int customSeparatorStart = input.indexOf("//");
        int customSeparatorEnd = input.indexOf("\\n");

        if (customSeparatorStart == -1) {
            return List.of(input, "");
        } else if (customSeparatorStart != 0 || customSeparatorEnd == -1) {
            throw (new IllegalArgumentException());
        }

        String customSeparator = input.substring(2, customSeparatorEnd);
        String numberString = input.substring(customSeparatorEnd + 2);

        return List.of(numberString, customSeparator);
    }

    // 구분자로 문자열에서 숫자 추출
    public List<Integer> getNumber(String numberString, List<String> separators) {
        // numberString이 공백이면 0으로 간주
        if (numberString.isBlank()) {
            return List.of(0);
        }

        List<Integer> result = new ArrayList<>();

        // split으로 구분자 기준으로 숫자만 추출
        String[] numbers = numberString.split(separators.toString());

        // parseInt를 사용해서 String 숫자를 int로 변환
        // 숫자가 아닐경우 NumberFormatException이 발생함 -> IllegalArgumentException를 throw
        for (String number : numbers) {
            int numberInt;
            try {
                numberInt = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if (numberInt < 0) {
                throw new IllegalArgumentException();
            }

            result.add(numberInt);
        }

        return result;
    }

    // 숫자 합 계산
    public int sumNumbers(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result = result + number;
        }
        return result;
    }

}
