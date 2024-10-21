package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {
    private static String input;
    public static void readLine(){
            try{
                input = Console.readLine(); // 입력 읽기
            }catch(NoSuchElementException e){
                input = "0";
            }

            if(input.isEmpty() || input == null){
                System.out.println("try");
                input = "0";
            }
    }

    public static String getInput(){
        return input;
    }
}
