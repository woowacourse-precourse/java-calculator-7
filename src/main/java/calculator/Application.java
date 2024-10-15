package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> separator = List.of(",", ":");
        String input;

        input = inputString();
        List<String> numberStringAndCustomSeparator = findCustomSeparator(input);
        System.out.println(numberStringAndCustomSeparator);
    }

    // 문자열 입력
    public static String inputString() {
        return Console.readLine();
    }

    // 커스텀 구분자 저장
    // return[0] : 커스텀 구분자 부분을 없앤 문자열
    // return[1] : //와 \n을 없앤 커스텀 구분자
    public static List<String> findCustomSeparator(String input) {
        // //구분자\n
        int customSeparatorStart = input.indexOf("//");
        int customSeparatorEnd = input.indexOf("\\n");

        if(customSeparatorStart == -1) {
            return List.of(input, "");
        } else if(customSeparatorStart != 0 || customSeparatorEnd == -1) {
            throw(new IllegalArgumentException());
        }

        String customSeparator = input.substring(2, customSeparatorEnd);
        String numberString = input.substring(customSeparatorEnd+2);

        return List.of(numberString, customSeparator);
    }

    // 구분자로 문자열에서 숫자 추출
    // 숫자 합 계산
    // 결과 반환
}
