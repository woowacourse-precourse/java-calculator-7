package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            input= validating(input);
            int sum = adding(input);
            System.out.println("결과: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다");
        }
    }

    // 정상적인 입력 검사
    public static String validating(String input) {

        // 빈 입력 검사
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        // 구분자 추가 검사
        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int ender = input.indexOf("\n");
            if (ender == -1) {
                throw new IllegalArgumentException();
            }
            String newSpliter = input.substring(2, ender);
            if (newSpliter.isEmpty()) {
                throw new IllegalArgumentException();
            } else if (!newSpliter.matches("^[^a-zA-Z0-9]+$")){
                throw new IllegalArgumentException();
            }
        } else if (!input.matches("^[0-9,:]+$")) {
                throw new IllegalArgumentException();
            }
        return input;
    }

    // 덧셈 메소드
    public static int adding(String input) {
        String spliter = "[:|,]";
        int sum = 0;
        if (input.startsWith("//")) {
            int ender = input.indexOf("\n");
            String newSpliter = input.substring(2, ender);
            spliter = "[" + ":|," + "|" + newSpliter + "]";  // 커스텀 구분자 추가
            input = input.substring(ender + 1);  // 숫자 부분 추출
        }

        String[] nums = input.split(spliter);
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }

        return sum;
    }

    public static void addSpliter(String newSpliter) {

    }
}