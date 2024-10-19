package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static String insert(){
        String question = Console.readLine();
        Console.close();
        return question;
    }
    public static void checkMinus(int i1){
        if(i1 < 0)  {
            throw new IllegalArgumentException("잘못 입력하셨습니다.");
        }
    }
    public static int calculate(String str){
        System.out.println("입력된 문자열: " + str); // 입력 문자열 출력

        Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(str);
        String[] word = null;

        if (matcher.find()){
            System.out.println("여기 들어옴");
            String delimeter = matcher.group(1);
            word = matcher.group(2).split(Pattern.quote(delimeter));
        }

        if (word == null) {
            System.out.println("word==null에 들어옴");
            word = str.split(",|:");
        }
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