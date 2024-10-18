package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public static void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine(); // 문자열 입력

        if(checkEmpty(str)){ // 입력 문자열 비어있는지 확인
            System.out.println("결과 : 0");
            return;
        }

        List<String> numbers = splitByDelimiters(str);  // 구분자로 숫자 분리
        for(String i : numbers){ // 숫자 분리 확인
            System.out.println(i);
        }
    }

    // 입력한 문자열이 비었는지 확인 -> 비었으면 0 출력
    public static boolean checkEmpty(String str) {
        return str == null || str.isEmpty();
    }

    // 입력된 문자열에서 구분자로 숫자 분리
    public static List<String> splitByDelimiters(String str) {
        if (str.startsWith("//")) {
            return splitByCustomDelimiter(str);  // 커스텀 구분자 처리
        } else {
            return splitByDefaultDelimiters(str); // 기본 구분자 처리
        }
    }

    // 기본 구분자로 문자열을 분리
    private static List<String> splitByDefaultDelimiters(String str) {
        return Arrays.asList(str.split("[,:]"));
    }

    // 커스텀 구분자로 문자열을 분리
    private static List<String> splitByCustomDelimiter(String str) {
        int startIndex = 2; // 커스텀 구분자의 시작 인덱스
        int endIndex = str.indexOf("\\n"); // 구분자와 숫자 부분을 분리
        String customDelimiters = str.substring(startIndex, endIndex); // 커스텀 구분자 추출

        String numberPart = str.substring(endIndex + 2); // 숫자 부분 추출
        String delimiters = "[" + customDelimiters + ",:]"; // 커스텀 구분자와 기본 구분자를 모두 포함
        return Arrays.asList(numberPart.split(delimiters)); // 최종 구분자로 문자열을 분리
    }
}
