package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Console;
import java.util.Queue;

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
    private ArrayList<Integer> numList;

    public StringCalculator(){
        this.sum = 0;
        this.delimiter = ",:";
        this.numList = new ArrayList<>();
    }

    // 입력받기
    public void setInput(   ) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        this.input = Console.readLine();
    }
}
