package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Application {
    public static void main(String[] args) {
        float result = 0;

        String input = Console.readLine();
        ArrayList <String> delimiters = new ArrayList<>(Arrays.asList(",",":"));
        // 재사용성을 위해 delimiters 안에 값을 몇개고 추가할 수 있게 해놓음

        if (input.charAt(0) =='/' & input.charAt(1) == '/'){
            System.out.println("와우");

            int index = input.indexOf("\\n");
            String new_delimiter = input.substring(2,index);
            System.out.println(new_delimiter);
            input = input.substring(index+2,input.length());
            delimiters.add(new_delimiter);
        }


        try{
            if(delimiters.size()>3){
                throw new IllegalArgumentException("커스텀 구분자가 2개 이상 추가되었습니다. 커스텀 구분자는 1개까지만 허용됩니다.");
            }

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(1); //애플리케이션 종료
        }

        System.out.println("최종구분자"+delimiters);


        System.out.println("input은:"+input);
        String regex = String.join("|",delimiters);


        String arr[] = input.split(regex);
        System.out.println("에러냐");
        System.out.println(arr);
        for (String a : arr){
            result+= Float.parseFloat(a);
        }
        System.out.println(result);
    }
}