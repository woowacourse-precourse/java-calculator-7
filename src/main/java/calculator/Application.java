package calculator;

import camp.nextstep.edu.missionutils.Console;

/*
 * 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
 */
public class Application {

    public static final char BASIC_SEP_ONE = ':';
    public static final char BASIC_SEP_TWO = ',';
    public static char customSep  = '1';

    // BASIC_SEP, CustomSep, 숫자인지 유효성 검사
    public static boolean isValidChar(char c){
        return (c == BASIC_SEP_ONE || c == BASIC_SEP_TWO || Character.isDigit(c) || c == customSep);
    }

    // 입력값 검증
    public static void isValid(String input){
        if(input.isEmpty()){
            System.out.println(0);
            System.exit(0);
        }
        if((input.charAt(0) == '/' && input.length() < 5) ) {
            throw new IllegalArgumentException("Input is not valid.");
        }
        if(input.startsWith("//") && input.charAt(3) == '\\'
                && input.charAt(4) == 'n' && !Character.isDigit(input.charAt(2))){
                customSep = input.charAt(2);
        }
        for (int i = 0; i < input.length(); i++){
            if(customSep != '1' && i < 5) continue;
            if(!isValidChar(input.charAt(i))){
                throw new IllegalArgumentException(input.charAt(i) + " is inserted." );
            }
        }
    }

    // 문자열에서 숫자 덧셈 계산
    public static int calculate(String input){
        int sum = 0;
        int i = (customSep == '1' ? 0 : 5);

        while(i < input.length()){
            if(!Character.isDigit(input.charAt(i))){
                i++;
                continue;
            }
            int num = 0;
            while(i < input.length() && Character.isDigit(input.charAt(i))){
                num = num * 10 + input.charAt(i) - '0';
                i++;
            }
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        String input = "";
        // 입력받기 및 입력값 검증
            try{
                System.out.println("덧셈할 문자열을 입력해 주세요.");
                input = Console.readLine();
                isValid(input);
            }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }

        System.out.println("결과 : " + calculate(input));

    }
}