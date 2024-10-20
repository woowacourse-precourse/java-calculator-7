package calculator;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        String inputString = getInputString();
        String newDelimiter = getNewDelimiter(inputString);
        //입력 값 숫자로 처리
        //연산
        //결과 출력
        //System.out.println(output);
    }

    private static String getNewDelimiter(String inputString) {
        String newDelimiter = null;
        if(inputString.startsWith("//")){
            if(!inputString.contains("\\n"))
                throw new IllegalArgumentException("신규 구분자 지정 문법에 맞지 않습니다.");
            else{
                 newDelimiter = inputString.substring(2, inputString.indexOf("\\n"));
            }
        }
        return newDelimiter;
    }

    private static String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = br.readLine();
            return input;
        } catch (IOException e) {
            throw new IllegalArgumentException("잘못된 입력값이 입력되었습니다.");
        }
    }
}
