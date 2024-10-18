package calculator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String input = Input();
        int result = Add_Process(input);
        System.out.println("결과 : " + result);
    }

    // 사용자의 입력을 받는 메서드
    private static String Input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().replace("\\n", "\n"); // 문자열에서 "\n"을 실제 줄바꿈 문자로 변환
    }

    // 입력된 문자열을 처리하는 메서드
    private static int Add_Process(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0; // 입력이 비어있거나 null이면 0을 반환
        }
        
        String[] nums = Refine_Input(input); // 입력을 정제하여 숫자 배열로 반환

        System.out.println(Arrays.toString(nums));

        return Sum(nums);
    }

    // 입력 문자열에서 구문자를 처리하고 숫자 배열로 반환하는 메서드
    private static String[] Refine_Input(String input) {
        // 정규표현식 패턴
        String regex = "//(.+)\\n";  // 중간에 여러 문자가 있을 수도 있으므로 (.+) 사용

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String guboonja = matcher.group(1);  // 커스텀 구분자 추출
            String metaGuboonja = Pattern.quote(guboonja);  // 메타문자 이스케이프 처리
            System.out.println(metaGuboonja);
            return input.replaceAll("[^0-9-\\d]", guboonja).split(metaGuboonja);
        }
        return input.split("[,:]");

    }

    // 숫자 배열을 합산하는 메서드
    private static int Sum(String[] nums) {
        int result = 0;

        for (String word : nums) {
            if (!word.trim().isEmpty()) {
                int num;
                try {
                    num = Integer.parseInt(word.trim());
                } catch (NumberFormatException e) {
                    num = 0;
                }
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                result += num;
            }
        }
        return result;
    }
}