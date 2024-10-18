package calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String guboonja;
        String[] nums;

        // 정규표현식 패턴
        String regex = "//(.+)\\n";  // 중간에 여러 문자가 있을 수도 있으므로 (.+) 사용

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(re_susik);

        if (matcher.find()) {
            guboonja = matcher.group(1);  // 커스텀 구분자 추출
            String metaGuboonja = Pattern.quote(guboonja);  // 메타문자 이스케이프 처리
            nums = re_susik.replaceAll("[^0-9-\\d]", guboonja).split(metaGuboonja);

        } else {
            guboonja = "[,:]";
            nums = re_susik.split(guboonja);
        }

        for (String word : nums) {
            if (!word.trim().isEmpty()) {
                int num;
                try {
                    num = Integer.parseInt(word.trim());
                    result += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println("결과 : " + result);
    }
}