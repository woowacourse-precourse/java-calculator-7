package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculate(String str) {
        //정규식 이용
        Pattern p1 = Pattern.compile("^\\d*([,:]\\d+)*$");
        Matcher m1 = p1.matcher(str);

        int ans = 0;
        if (m1.matches()) {// 1번 케이스
            String[] arr = str.split("[,:]");
            for (String s : arr) {
                if(s.matches("\\d+")) {
                    ans += Integer.parseInt(s);
                }
            }
        }
        else{}

        return ans;
    }
}
