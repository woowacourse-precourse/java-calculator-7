package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);

        // 전체 입력을 받기 위해 nextLine() 사용
        String susik = sc.nextLine();

        if (susik == null || susik.trim().isEmpty()) {
            System.out.println("결과 : " + 0);
        }

        // 입력받은 문자열에서 "\n"을 실제 줄바꿈 문자로 변환
        assert susik != null;
        String re_susik = susik.replace("\\n", "\n");

        int result = 0;

        String guboonja = "[,:]";
        String[] nums = re_susik.split(guboonja);

        for (String word : nums) {
            if (!word.trim().isEmpty()) {
                int num = Integer.parseInt(word.trim());
                result += num;
            }
        }
        System.out.println("결과 : " + result);
    }
}