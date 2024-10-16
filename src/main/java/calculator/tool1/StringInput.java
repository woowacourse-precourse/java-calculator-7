package calculator.tool1;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class StringInput {

    public static String InputString(){

        try{
            //입력을 \n 문자열 기준으로 받음
            String input1 = Console.readLine();
            String input2 = Console.readLine();

            //문자열 2개를 \n 문자를 추가하여 합침
            return input1 + "\n" + input2;

        }catch (NoSuchElementException |
                IllegalArgumentException illegalArgumentException){
            throw new IllegalArgumentException();
        }finally {
            Console.close();
        }



    }

}
