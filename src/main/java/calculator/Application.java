package calculator;

import camp.nextstep.edu.missionutils.Console;

/*
 * 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
 */
public class Application {

    public static final char BASIC_SEP_ONE = ':';
    public static final char BASIC_SEP_TWO = ',';
    public static char customSep  = '1';

    // BASIC_SEP 혹은 숫자인지 검사
    public static boolean checkBasic(char c){
        return (c == BASIC_SEP_ONE || c == BASIC_SEP_TWO || Character.isDigit(c));
    }

    // 입력값 검증
    public static void validateName(String input){
        if(input.charAt(0) == '/' && input.length() < 5) {
            throw new IllegalArgumentException("Input is not valid.");
        }
        if(input.charAt(0) == '/' && input.charAt(1) == '/'
            && input.charAt(3) == '\\' && input.charAt(4) == 'n' && !Character.isDigit(input.charAt(2))){
                customSep = input.charAt(2);
        }
        for (int i = 0; i < input.length(); i++){
            if(customSep != '1' && i < 5) continue;
            if(!checkBasic(input.charAt(i)) && input.charAt(i) != customSep){
                throw new IllegalArgumentException(input.charAt(i) + " is inserted." );
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력받기 및 입력값 검증
        try{
            // 문자열 입력받기 기능 구현.
            System.out.println("Please type string.");
            String input = Console.readLine();
            validateName(input);
        }catch (IllegalArgumentException e){
            System.out.println("Wrong Input : " + e.getMessage());
            System.exit(0);
        }


    }
}