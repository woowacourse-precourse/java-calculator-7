package calculator;


import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";


    public void run(){
        String input = input();
        Integer sum = calc(input);
        output(sum);
    }


    private String input(){
        System.out.println(INPUT_MESSAGE);
        String inputField = readLine();
        return inputField;
    }

    private Integer calc(String input){

        return null;
    }

    private void output(Integer result){
        System.out.print(OUTPUT_MESSAGE + result);
    }


}
