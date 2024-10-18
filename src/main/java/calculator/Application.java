package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        String question = "";
        int answer = 0;
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        question = Console.readLine();
        Console.close();
        if(question.equals("")){
            System.out.println("결과 : " + 0);
            return;
        }
        System.out.println("결과 : " + answer);
    }

}