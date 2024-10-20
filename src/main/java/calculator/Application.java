package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        String input = getInput();

        // 구분자 추출
        String delimiter = ExtractDelimiter.extract_delimiter(input);

        // 문자열 전처리
        String refine_string = SplitInput.refine(input);

        // 문자열 분리
        String[] nums = SplitInput.split(refine_string, delimiter);

        System.out.println("결과 : " + AddingNum.sum(nums));
    }

    // 사용자의 입력을 받는 메서드
    private static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().replace("\\n", "\n"); // 문자열에서 "\n"을 실제 줄바꿈 문자로 변환
    }
}