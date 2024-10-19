package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        String input = Console.readLine();
        System.out.print(input.charAt(4));
        validUserInput(input);
        return input;
    }

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
                && validGeneralSequenceSeparator(input)
                && validLastSeparator(input);
    }

    /** 커스텀 구분자 입력 검증 **/
    //사용자가 커스텀 구분자를 사용하였을 경우
    public static boolean validCustomUserInput(String input){
        return validCustomFrontAndCharacter(input)
                && validSeparator(input, input.charAt(2))
                && validCustomSequenceSeparator(input)
                && validLastSeparator(input);
    }

    /** 기본 구분자 검증 모듈 **/
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

    //사용자가 기본 구분자를 연달아 쓰지 않았는지 검증
    public static boolean validGeneralSequenceSeparator(String input){
        for(char c : input.toCharArray()){
            if(!Character.isDigit(c) && input.indexOf(c) != input.length()-1){
                if(!Character.isDigit(input.charAt(input.indexOf(c)+1))){
                    return false;
                }
            }
        }
        return true;
    }

    /** 커스텀 구분자 검증 모듈 **/
    //사용자가 커스텀 구분자를 사용하였을 경우, 앞 열 위치인지, 구분자가 문자인지 검증
    public static boolean validCustomFrontAndCharacter(String input){
        if(input.length() > 1){
            return input.indexOf("//") == 0
                    && !Character.isDigit(input.charAt(2))
                    && input.indexOf("\\n") == 3;
        }else{
            return false;
        }
    }

    //사용자가 커스텀 구분자를 연달아 쓰지 않았는지 검증
    public static boolean validCustomSequenceSeparator(String input){
        for(int i=5; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i)) && i != input.length()-1){
                if(!Character.isDigit(input.charAt(i+1))){
                    return false;
                }
            }
        }
        return true;
    }

    //사용자가 입력한 커스텀 구분자와 기본 구분자만 들어갔는지 검증
    public static boolean validSeparator(String input, char customSeparator){
        for(int i=5; i<input.length(); i++){
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

    /** 공통 검증 모듈 **/
    //사용자가 문자열 마지막에 구분자를 사용했는지 검증
    public static boolean validLastSeparator(String input){
        return Character.isDigit(input.charAt(input.length() - 1));
    }

}
