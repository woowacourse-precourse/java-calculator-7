package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.*?)\\\\n";

    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            String[] sepArr = splitInput(input); // 커스텀 구분자 지정 및 구분자 기준으로 나누는 메서드 호출, 배열에 저장
            int sum = calculator(sepArr); // 합계 구하는 메서드 호출
            printResult(sum); // 출력 메서드
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생 따로 처리
        }
    }

    private static String[] splitInput(String input) {
        String separator1 = ","; // 구분자 설정
        String separator2 = ":"; // 구분자 설정2
        String separator3 = ""; // 커스텀 구분자 추가 설정, 공백으로 초기화

        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX); // "//", "\n" 사이의 문자 추출
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            separator3 = matcher.group(1); // 추출된 문자가 존재한다면 구분자로 지정
            input = input.substring(matcher.end()).trim(); // 구분자 지정하는 구간 삭제
        }

        if (separator3.isEmpty()) { // 커스텀 구분자가 있는 경우, 없는 경우 나눠서 return
            return input.split(separator1 + "|" + separator2); // 구분자가 없을 때
        } else {
            return input.split(separator1 + "|" + separator2 + "|" + Pattern.quote(separator3)); // 모든 구분자로 나누기
        }

    }

    private static int calculator(String[] sepArr) {
        int sum = 0;
        for (String numStr : sepArr) {
            sum += splitNumber(numStr);
        }
        return sum;
    }

    private static int splitNumber(String numStr) {
        int sum = 0;
        numStr = numStr.trim(); // 문자열의 앞뒤 공백 제거
        if (numStr.isEmpty()) {
            throw new IllegalArgumentException("공백입니다.");
        }
        try {
            int number = Integer.parseInt(numStr); // 형변환
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number); // 음수 입력 시 예외처리
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "유효하지 않은 문자열이 포함되어 있습니다: " + numStr.trim()); // 유효하지 않은 문자열 포함 시 예외처리
        }
    }

    public static void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }
}