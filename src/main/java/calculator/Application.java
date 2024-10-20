package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int total = 0;
        String separator = null;
        String[] str = null;

        System.out.println("덧셈할 문자열을 입력해주세요. ");
        String line = Console.readLine();
        String sep1 = line.substring(0,2);
        String sep2 = line.substring(3,5);

        if(sep1.equals("//") && sep2.equals("\\n")){
            separator = line.substring(2,3);
            line = line.substring(5);
            str = line.split(",|:|"+separator);
        }else{
            str = line.split(",|:");
        }

        for (int i = 0; i < str.length; i++) {
            try {
                total += Integer.parseInt(str[i]);
            } catch (NumberFormatException e){
                total += 0;
            }
        }

        System.out.println("결과 : " + total);


    }
}
