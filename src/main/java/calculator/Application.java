package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        String newSplit = "";
        String splits = ":,";
        String patterString = "(?<=//).*"; //사이만 추출가능
        String patterString1 = "//.*?\\n"; //새 구분자 부분 지우기위한 키워드 추출
        String input = Console.readLine();
        if (input.startsWith("//")){
            Pattern pattern = Pattern.compile(patterString);
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String newSplit = matcher.group();
                splits+= newSplit;
            }
            else{
                System.out.println("there is no matched String");
            }
            input = Console.readLine(); //새 input받기
        }
        String splitFormmat = String.format("[%s]",splits); //정규식으로 전환
        String[] strArr = input.split(splitFormmat);

        int[] intArr = new int[strArr.length];
        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int j : intArr) {
            sum += j;
        }
        System.out.println(sum);
    }
}
