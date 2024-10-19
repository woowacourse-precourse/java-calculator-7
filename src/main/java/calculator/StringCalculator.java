package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculate(String str) {
        //정규식 이용
        Pattern p1 = Pattern.compile("^\\d*([,:]\\d+)*$");
        Pattern p2 = Pattern.compile("^[/]{2}([^,:])\\\\n\\d*(\\1\\d+)*$");

        Matcher m1 = p1.matcher(str);
        Matcher m2 = p2.matcher(str);
        int ans = 0;

        if (m1.matches()) {// 1번 케이스
            String[] arr = str.split("[,:]");
            for (String s : arr) {
                if(s.matches("\\d+")) {
                    ans += Integer.parseInt(s);
                }
            }

        }
        else if (m2.matches()) {
            String separator = str.substring(2, 3);
            String[] arr = str.substring(5).split(separator);

            for (String s : arr) {
                if(s.matches("\\d+")) {
                    ans += Integer.parseInt(s);
                }
            }
        }
        else {
            throw new IllegalArgumentException();
        }

        return ans;
    }
}
