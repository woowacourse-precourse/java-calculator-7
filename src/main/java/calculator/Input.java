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
}
