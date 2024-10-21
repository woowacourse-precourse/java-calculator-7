package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = "1,2:3"; // 예시 입력, 나중에 사용자의 입력으로 변경할 수 있습니다.

        int result = add(input);
        System.out.println("결과 : " + result);


    }
    public static int add(String input) {
        // 빈 문자열 입력 시 0을 반환
        if (input.isEmpty()) {
            return 0;
        }
    }
}
