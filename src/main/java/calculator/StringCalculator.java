package calculator;

import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;

/**
 *  1. 문자열을 입력받는다.
 *  2. 문자열에서 커스텀 구분자를 구한다.
 *  3. 구분자들을 기준으로 숫자들을 추출한다.
 *  4. 추출한 숫자들의 합을 구한다.
 *  5. 결과값을 출력한다.
 * */
public class StringCalculator {
    // 입력받은 문자열
    private String input;
    // 결과값
    private int sum;
    // 숫자 구분자
    private String delimiter;
    // 추출한 숫자 리스트

    public StringCalculator(){
        this.sum = 0;
        this.delimiter = "[,:";
    }

    // 입력받기
    public void setInput(   ) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        this.input = Console.readLine();
    }

    // 커스텀 구분자를 구하는 기능
    public void addDelimiter(){
        // 커스텀 구분자가 추가될려면 문자열 길이 5 이상
        if(input.length() >= 5) {
            for (int i = 0; i < input.length() - 5; i += 5) {
                if (input.startsWith("//", i) && input.startsWith("\\n", i + 3)) {
                    delimiter += input.charAt(i + 2);
                    // 원본 문자열에서 커스텀문자열 추가 부분 제거
                    this.input = input.substring(0, i) + input.substring(i + 5);
                    System.out.println(input.charAt(i + 2));
                }
            }
        }
        delimiter+="]";
        System.out.println("delimiter : " + delimiter);
    }

    // 문자열에서 구분자를 기준으로 숫자들을 추출하고 합을 구하는 기능
    public void sumDelimitedNumbers(){
        String[] numList = input.split(delimiter);
        System.out.println("numList : "+Arrays.toString(numList));
        for(String c : numList){
            // 구분자를 제외한 문자가 있을경우 예외처리
            if(!c.matches("^[0-9]*$")){
                throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
            }
            this.sum += Integer.parseInt(c);
        }
        System.out.println("sum : "+sum);
    }
}
