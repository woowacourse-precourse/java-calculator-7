package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //사용자로부터 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
        try {
            int answer = isNull(inputStr) ? 0 : processInput(inputStr);
            displayResult(answer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }
    private static int processInput(String inputStr) {
        String[] atoms = inputStr.startsWith("//") ? splitCustom(inputStr) : splitBasic(inputStr);
        return sumNum(atoms);
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
        int endDelimiter = inputStr.indexOf("\\n");
        if (endDelimiter == -1) {
            throw new IllegalArgumentException("잘못된 형식입니다. \\n이 없습니다.");
        }

        String delimiter = inputStr.substring(2, endDelimiter); // \n 전까지 커스텀 구분자 지정
        inputStr = inputStr.substring(endDelimiter + 2); // 구분자 적용 대상 문자열로 분리

        return splitString(inputStr, delimiter);
    }
    private static String[] splitBasic(String inputStr) {
        return splitString(inputStr, ",|:"); // 기본 구분자 콤마(,) 또는 콜론(:)
    }
    // 문자열을 구분자로 분리하고 빈 문자열을 0으로 처리
    private static String[] splitString(String inputStr, String delimiter) {
        return Arrays.stream(inputStr.split(delimiter))
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
