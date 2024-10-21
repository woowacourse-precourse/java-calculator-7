package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        add(input);
    }
    // 커스텀 구분자를 추가하는지 확인하는 함수
    private static boolean exist_custon_delimiter(String input) {
        // "//"로 시작하는지 확인하고 커스텀 구분자 추가여부 확인
        if(input.startsWith("//")) {
            return true;
        }
        return false;
    }
    // "//"과  "\n" 사이의 커스텀 구분자를 추출하고 "\n" 뒤의 문자열을 분리하는 함수
    private static String[] get_custom_delimiter(String input) {
        String delimeter = ",:";
        String str_for_add = "";
        delimeter += input.strip().split("\\\\n")[0].split("//")[1];
        str_for_add = input.strip().split("\\\\n")[1];
        return new String[] {delimeter, str_for_add};
    }
    // 문자열 검증하는 함수
    private static void validate_str(String delimiter, String str) {
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if((c-'0'<0 || c-'0'>9) && !is_delimiter(c, delimiter)) {
                throw new IllegalArgumentException("입력값을 다시 입력해주세요.");
            }
        }
    }
    // 특정 문자가 지정된 구분자들 중 하나인지 확인하는 함수
    private static boolean is_delimiter(char c, String delimiter) {
        for(int i = 0; i < delimiter.length(); i++) {
            if(c==delimiter.charAt(i)) return true;
        }
        return false;
    }
    // 덧셈 연산을 하는 함수
    private static void add(String input) {
        // 초기 구분자 세팅
        String delimiter = "";
        // 초기 덧셈할 문자열
        String str_for_add ="";
        // 커스텀 구분자 여부 확인, 추출 및 분리
        if(exist_custon_delimiter(input)) {
            String[] tokens;
            tokens = get_custom_delimiter(input);
            delimiter = tokens[0];
            str_for_add = tokens[1];
        }
        else {
            delimiter = ",:";
            str_for_add = input;
        }
        //문자열 검증하기
        validate_str(delimiter, str_for_add);
        //덧셈하기
        int sum = 0;
        String number = "";
        for(int i = 0; i < str_for_add.length(); i++) {
            char c = str_for_add.charAt(i);
            //숫자가 아닌경우
            if(c-'0'<0 || c-'0'>9) {
                sum += Integer.parseInt(number);
                number = "";
            }
            else {
                number += c;
            }
        }
        sum += Integer.parseInt(number);
        System.out.println("결과 : "+sum);
    }
}
