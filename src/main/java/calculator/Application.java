package calculator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String delimiters = ",:";  // 커스텀 문자열까지 받기 위해 열어둔다.

        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        sc.close();

        // 커스텀 문자열을 찾아서 포함시켜준다.
        if (inputStr.substring(0, 2).equals("//")) {
            String[] strings = findCustomDelimiter(inputStr);
            delimiters = delimiters.concat(strings[0]);
            inputStr = strings[1];
        }

        // 정규표현식 활용해서 연속으로 구분자가 들어오는 경우도 처리해준다.
        String[] pureStr = inputStr.split("["+delimiters+"]+");

        int result = Arrays.stream(pureStr).mapToInt(Integer::parseInt).sum();
        System.out.println("결과 : "+result);
    }

    /**
     * 커스텀 구분자를 찾는 메소드.
     * @param inputStr
     * @return
     *     첫 번째 인자: 커스텀 구분자
     *     두 번째 인자: 커스텀 구분자 입력 영역을 제외한 순수 문자열
     */
    public static String[] findCustomDelimiter(String inputStr) {

        int index = inputStr.indexOf("\\n");
        String[] tempStr = new String[2];
        tempStr[0] = inputStr.substring(2, index);
        tempStr[1] = inputStr.substring(index + 2);

        return tempStr;  // 여러 개의 커스텀 문자열이 입력될 수 있다.
    }
}
