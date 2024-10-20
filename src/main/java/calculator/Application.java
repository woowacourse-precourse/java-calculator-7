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

    // 커스텀 구분자 찾는 메서드, 유효하지 않을 시 기본 구분자 반환
    public static String findCustomDelimiter(String input) {
        String delimiter = ",|:";
        if(validCustomDelimiter(input)){
            delimiter = String.valueOf(input.charAt(2));
        }
        return delimiter;
    }


    // 구분자를 기준으로 문자열 자르는 메서드
    public static String[] splitString(String input, String delimiter){
        return input.split(delimiter);
    }

    // 문자열 더하는 메서드(number가 숫자가 아닌 경우 예외처리 필요)
    public static int addString(String[] numbers){
        int sum = 0;
        for(String number: numbers){
            int num = stringToInt(number);
            if(num<0)
                return -1;
            sum+=num;
        }
        return sum;
    }

    public static int stringToInt(String number){
        for(int i=0;i<number.length();i++){
            if(!(number.charAt(i)>='0'&&number.charAt(i)<='9'))
                return -1;
        }
        return Integer.parseInt(number);
    }

    



    public static void main(String[] args) {
        String input = Console.readLine();

    }
}
