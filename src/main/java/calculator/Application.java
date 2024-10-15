package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        calStart();
    }

    private static void calStart() {
        String[] digits = getDigits();
        getResult(digits);
    }

    private static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine(); //한 줄 입력 받음
    }

    private static String[] getDigits() {
        String input = input();
        String seperator = ",:";
        return input.split("[" + seperator + "]");
    }

    private static void getResult(String[] digits) {
        int result = 0;
        for (String val : digits) {
            int intVal;
            if (val.isEmpty()) {
                intVal = 0;
            } else {
                intVal = Integer.parseInt(val);
            }
            result += intVal;
        }
        System.out.println("결과 : " + result);
    }
}
