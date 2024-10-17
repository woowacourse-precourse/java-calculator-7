package calculator;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String delimiters = ",:";  // 커스텀 문자열까지 받기 위해 열어둔다.

        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        sc.close();

        // 커스텀 문자열이 존재하는 경우, 그것을 찾아서 포함시켜준다.
        if (inputStr.substring(0, 2).equals("//")) {
            String[] strings = findCustomDelimiter(inputStr);
            delimiters = delimiters.concat(strings[0]);
            inputStr = strings[1];
        }

        // 정규표현식 활용해서 연속으로 구분자가 들어오는 경우도 처리해준다.
        String[] numStrArr = getNumStrArr(inputStr, delimiters);

        int result = Arrays.stream(numStrArr).mapToInt(Integer::parseInt).sum();
        System.out.println("결과 : "+result);
    }

    /**
     * 커스텀 구분자를 찾는 메소드.
     * @param inputStr : 사용자가 입력한 문자열
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

    /**
     * 구분자 사이의 숫자들을 추출해서 문자열 배열로 반환하는 메소드.
     * @param inputStr : 사용자가 입력한 문자열
     * @param delimiters : 커스텀 문자열까지 포함된 구분자 문자열
     * @return : 숫자만 파싱된 문자열
     */
    public static String[] getNumStrArr(String inputStr, String delimiters) {

        String[] pureStr = null;

        pureStr = inputStr.split("["+delimiters+"]+");

        for(String s : pureStr) {
            char[] charArr = s.toCharArray();

            // 사용자가 잘못된 값을 입력하는 경우 `IllegalArgumentException`을 발생시킴
            for (char c : charArr) {
                if ( !Character.isDigit(c) || c == '0' )
                    throw new IllegalArgumentException("구분자와 양수로 구성된 문자열을 입력해야 합니다.");
            }
        }
        
        return pureStr;
    }

}
