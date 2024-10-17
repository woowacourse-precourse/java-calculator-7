package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    static Separator separator = new Separator(',',':');

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String input = userInput();

        validateInput(input);

    }

    public static String userInput(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public static void validateInput(String str){
        if(str.startsWith("//")){
            int idx = str.indexOf("\\n");
            if(idx == -1){
                throw new IllegalStateException("커스텀 구분자가 올바른 형식으로 입력되지 않았습니다.");
            }
            String customSeparator = str.substring(2,idx);

            for(int i=0;i<customSeparator.length();i++){
                separator.addSeparator(customSeparator.charAt(i));
                System.out.println(customSeparator.charAt(i));
            }
            str = str.substring(idx+2);
        }

        for(int i=0;i<str.length();i++){
            if(isDigit(str.charAt(i)) || separator.isSeparator(str.charAt(i))) continue;
            throw new IllegalStateException("잘못된 입력입니다.");
        }
    }

    public static boolean isDigit(Character c){
        return ('0'<=c && c<='9');
    }

}
