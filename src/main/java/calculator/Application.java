package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    //입력 형식 검증 - 커밋
    private static void inputCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("잘못된 입력 형식");
        }
    }

    //커스텀 구분자 구분 -커밋
    private static String[] split(String input) {
        String delimiter = ",|:"; // 기본 구분자 쉼표(,)와 콜론(:)
        String numbers = input;

        // 커스텀 구분자가 있는지 확인
        if (input.startsWith("//")) {
            int delimiterIdx = input.indexOf("\\n"); // \n 문자 확인
            if (delimiterIdx == -1) { // //로 시작하는데 \n이 없으면 잘못된 입력 형식
                throw new IllegalArgumentException("잘못된 입력 형식");
            }
            delimiter = input.substring(2, delimiterIdx); // "//"와 "\n" 사이의 문자를 구분자로 사용
            numbers = input.substring(delimiterIdx + 2);
        }

        return numbers.split(delimiter); //구분자를 기준으로 문자열 분리
    }

    //숫자 합계 계산 -커밋
    private static int sum(String[] numbers) {
        int sum = 0;
        for (String n : numbers) {
            if (!n.isEmpty()) {
                int number = Integer.parseInt(n.trim());
                if (number < 0) {
                    throw new IllegalArgumentException("음수 입력");
                }
                sum += number;
            }
        }
        return sum;
    }

    // 계산 함수
    public static int calc(String input) {
        inputCheck(input); //입력 체크
        String[] numbers = split(input); //구분자로 문자열 분리
        return sum(numbers); //덧셈 계산
    }

    // 메인 함수
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  //사용자 입력

        int result = calc(input);
        System.out.println("결과 : " + result);
    }
}
