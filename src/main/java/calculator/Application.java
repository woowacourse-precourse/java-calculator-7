package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        String delimiter = ",:";
        //계산해야할 문자역
        String str_to_add = "";
        //구분자가 있을때
        if(check_delimiter(input)) {
            String[] tokens = add_delimiter(input,delimiter);
            delimiter = tokens[0];
            str_to_add = tokens[1];
            System.out.println(delimiter + " " + str_to_add );
        }else{
            str_to_add = input;
        }
        str_to_add = str_to_add.strip();
        validation(str_to_add, delimiter);
    }
    //커스텀 구분자 여부 확인
    private static boolean check_delimiter(String input) {
        if(input.charAt(0)=='/' && input.charAt(1)=='/') {
            return true;
        }
        return false;
    }
    //구분자 추가 함수
    private static String[] add_delimiter(String input, String delimiter) {
        String[] components = input.split("\\\\" + "n");
        String delimiters = components[0].split("//")[1];
        String str_to_add = components[1];
        for(int i=0;i<delimiters.length();i++) {
            delimiter += delimiters.charAt(i);
        }
        return new String[]{delimiter, str_to_add};
    }
    //예외처리 함수
    private static void validation(String str_to_add, String delimiter) {
        for(int i=0;i<str_to_add.length();i++) {
            char c = str_to_add.charAt(i);
            if(c-48<0 || c-48>9) {
                throw new IllegalArgumentException("입력이 잘못된 형식입니다.");
            }
        }
    }
}

