package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getInput();
        System.out.println("결과 : " + process_to_calculate(input));
    }

    // 사용자의 입력을 받는 메서드
    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().replace("\\n", "\n"); // 문자열에서 "\n"을 실제 줄바꿈 문자로 변환
    }

    private static int process_to_calculate(String input) {
        // 구분자 추출
        String delimiter = ExtractDelimiter.extract_basic_delimiter(input);

        // 문자열 전처리
        String refine_string = SplitInput.refine(input);

        // 문자열 분리
        String[] nums = SplitInput.split(refine_string, delimiter);

        // 숫자를 더하고 결과 반환
        return AddingNum.sum(nums);
    }

}