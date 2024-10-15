package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Application app = new Application();
        // 사용자의 입력을 받는다.
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();
        System.out.print("결과 : " + app.solution(str));
    }

    // Solution
    public int solution(String str) {
        return sum(splitByDelimiter(str));
    }

    // 구분자에 따라 문자열을 분리하는 메서드
    public String[] splitByDelimiter(String str) {
        if (str.startsWith("//")) {
            return customSplit(str);
        } else {
            return defaultSplit(str);
        }
    }

    // Default
    public String[] defaultSplit(String str) {
        return str.split(",|:");
    }

    // Custom
    public String[] customSplit(String str) {
        // '//'과 \n  사이의 구분자로 입력받은 문자열을 구분해서 배열에 담아서 반환
        int index = str.indexOf("\\n");
        String delimiter = str.substring(2, index);
        return str.substring(index +2).split(delimiter);
    }

    // sum
    public int sum(String[] arr) {
        int answer = 0;
        for (String x : arr) {
            int N = Integer.parseInt(x);
            validation(N);
            answer += N;
        }
        return answer;
    }

    // Exception
    public void validation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
    }

}
