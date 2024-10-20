package calculator;

import camp.nextstep.edu.missionutils.Console;



public class Application {

    // 유효한 커스텀 구분자 갖고있는지 확인하는 메서드
    public static boolean validCustomDelimiter(String input) {
        if (input.length() < 5) {
            return false;
        }
        if (!input.startsWith("//")) {
            return false;
        }
        if (!(input.charAt(3) == '\\' && input.charAt(4) == 'n')) {
            return false;
        }
        // 구분자가 숫자면 에러
        if(input.charAt(2)>='0'&&input.charAt(2)<='9')
            return false;
        return true;
    }


    public static String[] splitString(String input, String delimiter){
        return input.split(delimiter);
    }


    public static void main(String[] args) {
        String input = Console.readLine();

    }
}
