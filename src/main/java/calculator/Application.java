package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine(); // 사용자 입력 받기
        try {
            int result = add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {

        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0; // 빈 문자열일 경우 0 반환
        }

        String delimiter = ",:"; // 기본 구분자 (쉼표, 콜론)

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            //System.out.println(delimiterIndex);
            if (delimiterIndex != -1) {
                // 커스텀 구분자 추출
                StringBuffer buf = new StringBuffer(delimiter);
                buf.insert(0,input.substring(2, delimiterIndex));
                delimiter = buf.toString();
                //System.out.println(delimiter);
                input = input.substring(delimiterIndex + 1); // 숫자 문자열로 변경
            }
        }

        // 커스텀 구분자 및 기본 구분자로 분리
        String[] tokens = input.split("[" + delimiter + ",:]");
        int sum = 0;

        // 숫자 합산 및 예외 처리
        for (String token : tokens) {
            if (!isNumeric(token)) { // 숫자가 아닌 경우 예외 발생
                throw new IllegalArgumentException("잘못된 입력 값: " + token);
            }
            sum += Integer.parseInt(token); // 문자열을 정수로 변환하고 합산
        }

        return sum;
    }

    // 숫자 여부 확인 메서드
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
