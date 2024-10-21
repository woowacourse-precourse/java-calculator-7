package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력받기
        String input = Console.readLine();
    }
    // 커스텀 구분자를 추가하는지 확인하는 함수
    private static boolean exist_custon_delimiter(String input) {
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

    }
    // 덧셈 연산을 하는 함수
    private static void add(String input) {
        // 초기 구분자 세팅
        String delimiter = "";
        String str_for_add ="";
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
    }
}
