package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    private static String insert(){
        String question = Console.readLine();
        Console.close();
        return question;
    }
    private static void checkMinus(int i1){
        if(i1 < 0)  {
            throw new IllegalArgumentException("양수만 입력할 수 있습니다.");
        }
    }
    private static void checkOtherStringCustom(String number, String delimiter){
        if (!number.matches("([0-9]*(" + Pattern.quote(delimiter) + "[0-9]*)*)")) {
            throw new IllegalArgumentException("잘못된 형식의 입력입니다.");
        }
    }
    private static void checkOtherString(String str){
        if (!str.matches("[0-9,|:]+")) {
            throw new IllegalArgumentException("기본 구분자가 아닌 문자가 포함되었습니다.");
        }
    }
    private static String[] defaultSeparator(String[] word, String str){
        if (word == null) {
            word = str.split(",|:");
            checkOtherString(str);
        }
        return word;
    }
    private static int calculate(String str){
        Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(str);
        String[] word = null;

        if (matcher.find()){
            String delimeter = matcher.group(1);
            String number = matcher.group(2);
            checkOtherStringCustom(number, delimeter);
            word = number.split(Pattern.quote(delimeter));
        }

        word = defaultSeparator(word, str);

        int sum = 0;
        for (int i = 0; i < word.length; i++) {
            int i1 = Integer.parseInt(word[i]);
            checkMinus(i1);
            sum += i1;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String question = insert();
        if(question.isEmpty() || question == null){
            System.out.println("결과 : " + 0);
            return;
        }
        int answer = calculate(question);
        System.out.println("결과 : " + answer);
    }
}