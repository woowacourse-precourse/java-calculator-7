package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
//그다음에 ""로 했을때도 어떻게 되는지 보기
        /*String a = "  abc  abc  ";
        String[] split = a.split("");
        //["", "", "abc", "", "abc"]*/
        String s = " ".substring(0, 0);
        System.out.println("abcd".indexOf("cd"));


        String a = "  abc  abc  ";
        String[] split = a.split(" ");

        System.out.println("split.toString() = " + split.toString());
        

        /*String str =  "//;\\n";
        //System.out.println(str);
        //Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]*)\\n");
        Pattern pattern = Pattern.compile("//([^.$|()\\[\\]\\\\{^?*+]*)\\\\n");

        System.out.println("pattern = " + pattern.toString());
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            //System.out.println(matcher.group(0)); // 매칭된 전체 문자열 출력
            System.out.println("매칭된 문자열 " + matcher.group(1)); // 캡처된 그룹(abc) 출력
            //System.out.println(matcher.group(2)); // 캡처된 그룹(abc) 출력
        } else {
            System.out.println("No match found.");
        }*/

    }

}
