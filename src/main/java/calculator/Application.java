package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class StringParser {
    String user_input;
    String result;

    public StringParser() {
    }

    //문자열 입력 받는 메서드(getUserInput)
    public String getUserInput() throws IllegalArgumentException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        try {
            user_input = br.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("입력값이 없습니다. 다시 입력해주세요.");
        }

        return user_input;
    }

    //구분자 설정하는 메서드(findDelimiter)
    public String findDelimiter(String user_input) {
        String delimiter;

        if (user_input.matches("^//([^0-9])\\\\(n)(.+)")) {
            delimiter = String.valueOf(user_input.charAt(2));
        } else {
            delimiter = "default";
        }

        return delimiter;
    }

    //문자열을 구분자를 이용해 토큰화 하는 메서드(tokenize)
    public String[] tokenize(String delimiter, String user_input) {
        String[] num_list;

        if (delimiter.equals("default")) {
            num_list = user_input.split(":|,");
        } else {
            user_input = user_input.substring(5);
            num_list = user_input.split(delimiter);
        }

        return num_list;
    }

    //토큰을 숫자로 형변환한 뒤 최종 결과값을 구하는 메서드(sumNumbers)
    public String sumNumbers(String[] number_list) throws IllegalArgumentException {
        //기본값은 실수
        double resultNum = 0;
        String type = "Integer";

        for (String x : number_list) {
            //정수일 때
            if (x.matches("[0-9]+")) {
                int added = Integer.parseInt(x);
                resultNum += added;
            }
            //실수일 때, type 변수를 Double로 설정
            else if (x.matches("[0-9]+\\.[0-9]+")) {
                double added = Double.parseDouble(x);
                resultNum += added;

                type = "Double";
            } else {
                throw new IllegalArgumentException("문자열의 형식이 올바르지 않습니다.");
            }
        }
        //type 자료형이 처음과 똑같이 Integer일 경우 정수끼리의 덧셈이므로 결과를 정수로 출력
        if (type.equals("Integer")) {
            int changeFormat = (int) Math.round(resultNum);
            result = Integer.toString(changeFormat);
        }
        //그 외는 더하는 수에 실수가 포함된 경우이므로, 결과를 실수로 출력
        else {
            result = Double.toString(resultNum);
        }

        return result;
    }

}