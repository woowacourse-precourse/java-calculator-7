package calculator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String a = readLine();
        System.out.println("결과 : "+ Calculator(a));

    }


    public static int Calculator(String str){
        int sum = 0;
        String[] s = {"",""};
        String separator = "[,:]";
        if(str.isEmpty()){
            return 0;
        }
        if(isPattern(str)){
            s = CustomSeparator(str);
            separator = s[0];
            str = s[1];
        }

        String[] x = str.split(separator);
        for (String string : x) {
            int z = Integer.parseInt(string);
            sum += z;
        }
        return sum;
    }
    public static String[] CustomSeparator(String str){
        String[] s = {"",""};
        Pattern pattern = Pattern.compile("//(.*?)(\\\\n)");
        Matcher matcher = pattern.matcher(str);

        if(matcher.find()){
            s[0] = matcher.group(1);
            s[1] = str.replace(matcher.group(0), "");
            return s;
        }else{
            return new String[0];
        }
    }
    public static boolean isPattern(String str){
        boolean isPattern = false;
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            isPattern = true;
        }
        return isPattern;
    }

}
