package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class Application {

    private static StringBuilder delimiters = new StringBuilder("[,;"); // 커스텀 구분자가 존재할 경우 추가하고 str.split에 사용할 수 있게 StringBuilder 타입으로


    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요");
        String str = readLine(); //문자열 입력받음
        str = str.replace("\\n", "\n"); // \\n을 실제 줄바꿈으로 변환

        if(str.startsWith("//")){
            str = custumDelimiters(str);

        } else if ((!str.contains(";") && !str.contains(",")) ||
                str.matches(".*[^0-9,;].*") ||
                str.matches(".*-\\d.*")) {
            throw new IllegalArgumentException("잘못된 입력입니다. 음수거나 구분자가 없거나 올바르지 않은 구분자가 포함되어 있습니다.");
        }

        delimiters.append("]"); //  delimiters의 대괄호 닫기
        String[] num = str.split(delimiters.toString());  // 문자열을 구분자로 split
        cal(num);
    }

    //커스텀 구분자 추가
    public static String custumDelimiters(String str) {
        if (str.matches("//\\D\\n.*")) {  // "//숫자가 아닌 문자\n" 형식 체크
            // "//"와 "\n" 이후의 부분만 가져옴
            String cusDelimiter = str.substring(2, 3); // 2번째 인덱스에서 단일 문자 구분자 추출
            delimiters.append(Pattern.quote(cusDelimiter)); // 커스텀 구분자 추가
            str = str.substring(str.indexOf('\n') + 1); // 숫자만 계산하기 위해 '\n' 이후의 부분만 사용
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자는 단일 문자로 작성해야 하며 하나 이상 사용되어야 합니다.");
        }

        return str; // 갱신된 str 반환
    }

    //계산
    public static void cal(String[] num){
        int sum = 0;
        for (String cal : num) {
            sum += Integer.parseInt(cal);
        }
        System.out.println("결과: " + sum);
    }

}
