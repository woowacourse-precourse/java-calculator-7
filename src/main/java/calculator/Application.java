package calculator;
import camp.nextstep.edu.missionutils.Console;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //사용자로부터 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
        int answer = 0;
        String[] atoms;
        try {
            if (isNull(inputStr)) {//빈 문자열이 입력될 경우
                displayResult(answer);
            } else {
                if (inputStr.startsWith("//")) { // 사용자 입력 문자열 분리하기 with 커스텀 구분자
                    atoms = splitCustom(inputStr);
                    answer = sumNum(atoms);
                } else { // 사용자 입력 문자열 분리하기 with 기본 구분자
                    atoms = splitBasic(inputStr);
                    answer = sumNum(atoms);
                }
                displayResult(answer);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
        }
        Console.close();
    }
    private static int sumNum(String[] numbers) {//분리 된 숫자 합산하기
        return Arrays.stream(numbers).mapToInt(num -> {
            try {
                return Integer.parseInt(num); //예외: 숫자가 아닌 값이면 예외 발생(IllegalArgumentException)
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자나 지정된 구분자가 아닌 값이 포함되어 있습니다: " + num);
            }
        }).sum();
    }
    private static String[] splitCustom(String inputStr) {
        int endDelimeter = inputStr.indexOf("\\n");//이스케이프문 \ 포함
        String delimiter = inputStr.substring(2, endDelimeter);//\n전까지 커스텀 구분자 지정
        inputStr = inputStr.substring(endDelimeter + 2);//구분자 적용 대상 문자열로 분리
        return Arrays.stream(inputStr.split(delimiter))
                .map(s -> isNull(s) ? "0" : s) //예외: null 또는 빈 문자열이면 "0"으로 변환
                .toArray(String[]::new);
    }
    private static String[] splitBasic(String inputStr) {
        return Arrays.stream(inputStr.split(",|:"))
                .map(s -> isNull(s) ? "0" : s) // null 또는 빈 문자열이면 "0"으로 변환
                .toArray(String[]::new);
    }
    private static void displayResult(int result) {
        System.out.println("결과: " + result);
    }
    private static boolean isNull(String s) {
        return s == null || s.isEmpty();
    }
}
