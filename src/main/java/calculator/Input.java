package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        System.out.print("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validUserInput(input);
        return input;
    }

    /*
    테스트 입력
    "1,2,3"
    "1,2,3,"
    "1,2:3@4"
    "1,;2:3"
    "1, 2;3"
    "//;\n1;2;3"
    "//;\n1;2; 3"
    "//;\n1,2;3:4"
    "//;\n1:2@3;4"
    "//7\n172,3"
     */

    /** 사용자 입력 검증 **/
    public static void validUserInput(String input){
        if(input.isEmpty() || validGeneralUserInput(input) || validCustomUserInput(input)){
            return;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /** 기본 구분자 입력 검증 **/
    //사용자가 기본 구분자를 사용하였을 경우
    public static boolean validGeneralUserInput(String input){
        return validSeparator(input)
                && validSequenceSeparator(input)
                && validLastSeparator(input);
    }

    /** 커스텀 구분자 입력 검증 **/
    //사용자가 커스텀 구분자를 사용하였을 경우
    public static boolean validCustomUserInput(String input){
        return validCustomFrontAndCharacter(input)
                && validSeparator(input, input.charAt(2))
                && validSequenceSeparator(input)
                && validLastSeparator(input);
    }

    /** 공통 모듈 **/
    //사용자가 입력한 기본 구분자만 들어갔는지 검증
    public static boolean validSeparator(String input){
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c)){
                if(!(c == ',' || c == ':')){
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 입력한 커스텀 구분자와 기본 구분자만 들어갔는지 검증
    public static boolean validSeparator(String input, char customSeparator){
        for(int i=4; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                if(!(input.charAt(i) == ','
                        || input.charAt(i) == ':'
                        || input.charAt(i) == customSeparator)){
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 구분자를 연달아 쓰지 않았는지 검증
    public static boolean validSequenceSeparator(String input){
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c) && input.indexOf(c) != input.length()-1){
                if(!Character.isDigit(input.charAt(input.indexOf(c)+1))){
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 문자열 마지막에 구분자를 사용했는지 검증
    public static boolean validLastSeparator(String input){
        return Character.isDigit(input.charAt(input.length() - 1));
    }

}
