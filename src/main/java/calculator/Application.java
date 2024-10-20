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
            throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다.");
        }
        // 구분자가 숫자면 에러
        if(input.charAt(2)>='0'&&input.charAt(2)<='9')
            throw new IllegalArgumentException("숫자는 구분자로 설정할 수 없습니다.");

        return true;
    }

    // 구분자가 특수문자인지 확인하는 메서드
    public static boolean isSpecialRegexChar(char delimiter) {
        String specialChars = ".^$*+?()[]{}\\|/";
        return specialChars.indexOf(delimiter) != -1;
    }

    // 커스텀 구분자 찾는 메서드, 커스텀 구분자 형식이 아닐 시 기본 구분자 반환
    public static String findCustomDelimiter(String input) {
        String delimiter = ",|:";

        if(validCustomDelimiter(input)){
            delimiter += "|";
            if(isSpecialRegexChar(input.charAt(2))) {
                delimiter += "\\";
            }
            delimiter+= input.charAt(2);
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
        try {
            for (String number : numbers) {
                int num = stringToInt(number);
                sum += num;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return sum;
    }

    public static int stringToInt(String number){
        for(int i=0;i<number.length();i++){
            if(!(number.charAt(i)>='0'&&number.charAt(i)<='9'))
                throw new IllegalArgumentException(number +"에 유효하지 않은 문자가 포함되어 있습니다. 양수와 구분자로만 입력하세요.");
        }
        return Integer.parseInt(number);
    }

    public static int StringCalculator(String input){
        if(input.isEmpty())
            return 0;
        int sum=-1;
        String delimiter = ",|:";

        try {
            delimiter = findCustomDelimiter(input); // 커스텀 구분자 찾기
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage()); // 예외 발생 시 에러 메시지 출력
        }

        if(delimiter!=",|:"){
            input = input.substring(5);
        }
        String[] numbers = splitString(input,delimiter);

        sum = addString(numbers);

        return sum;
    }




    public static void main(String[] args) {
        String input = Console.readLine();
        int sum = StringCalculator(input);

        System.out.println("결과 : "+sum);
    }
}
