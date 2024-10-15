package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static ArrayList<Character> delimiter = new ArrayList<>();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();


        int result = customProcess(input);

        System.out.println("결과 : " + result);
    }

    private static int customProcess(String input) {
        int result = 0;
        initDelimiter();

        if(input.charAt(0)=='/'){

        }
        for(int i = 0; i < input.length(); i++){
            if(delimiter.contains(input.charAt(i))) {
                result = result + input.charAt(i - 1);
            }
        }
        return 1;
    }

    private static void initDelimiter(){
        delimiter.add(',');
        delimiter.add(':');
    }

    private static void addDelimiter(String delimiterChar){

    }

    private static boolean validCharacter(){

        return false;
    }



}
