package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = "";  // 빈 문자열 입력
        System.out.println(sum(input));  // 결과 출력
    }

    public static int sum(String input) {
        if (input.isEmpty()) {
            return 0;  // 빈 문자열이면 0 반환
        }
        return 0;  // 기본 반환 값

    }
}
