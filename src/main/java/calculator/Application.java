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
            //System.out.println(delimiter + " " + str_to_add );
        }else{
            str_to_add = input;
        }
        str_to_add = str_to_add.strip();
        validation(str_to_add, delimiter);
        System.out.println("결과 : "+cal(str_to_add));
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
        String[] components = input.split("\\\\n");
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
                if(!is_delimiter(c,delimiter)) throw new IllegalArgumentException("입력이 잘못된 형식입니다.");
            }
        }
    }
    //계산함수
    private static int cal(String str_to_add) {
        int sum = 0;
        String num = "";
        for(int i=0;i<str_to_add.length();i++) {
            char c = str_to_add.charAt(i);
            if((c-48<0 || c-48>9)) {
                int n = Integer.parseInt(num);
                if(n>=0) sum += Integer.parseInt(num);
                else throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                num = "";
            }
            else {
                num += c;
            }
        }
        sum += Integer.parseInt(num);
        return sum;
    }
    //구분자인지 확인 함수
    private static boolean is_delimiter(char c, String delimiter) {
        for(int i=0;i<delimiter.length();i++) {
            if(delimiter.charAt(i)==c) {
                return true;
            }
        }
        return false;
    }
}

