package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculate(String str) {
        // 공백일 경우 0을 반환
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        // 정규식 이용
        Pattern p1 = Pattern.compile("^\\d*([,:]\\d+)*$");
        Pattern p2 = Pattern.compile("^[/]{2}([^,:])\\\\n\\d*(\\1\\d+)*$");

        Matcher m1 = p1.matcher(str);
        Matcher m2 = p2.matcher(str);
        int ans = 0;

        if (m1.matches()) { // 1번 케이스
            String[] arr = str.split("[,:]");
            for (String s : arr) {
                if (s.matches("\\d+")) {
                    int num = Integer.parseInt(s);
                    if (num < 0) { // 음수일 경우 예외 처리
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                    }
                    ans += num;
                }
            }
        }

        else if (m2.matches()) { // 커스텀 구분자 케이스
            String separator = str.substring(2, 3);
            String[] arr = str.substring(5).split(separator);

            for (String s : arr) {
                if (s.matches("\\d+")) {
                    int num = Integer.parseInt(s);
                    if (num < 0) { // 음수일 경우 예외 처리
                        throw new IllegalArgumentException("음수는 허용되지 않습니다: " + num);
                    }
                    ans += num;
                }
            }
        } else {
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }

        return ans;
    }
}