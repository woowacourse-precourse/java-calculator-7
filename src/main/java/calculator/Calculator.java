package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Calculator {
    static final String SEPARATOR_1 = "//";
    static final String SEPARATOR_2 = "\\n";
    static String separators = ",|:";

    /**
     * 커스텀 구분자 존재 체크
     * @param str 입력받은 문자열
     */
    public void checkCustomSeparator(String str){
        if (str.contains(SEPARATOR_1) && str.contains(SEPARATOR_2)){
            if(str.indexOf(SEPARATOR_1) != 0){
                throw new IllegalArgumentException();
            }

            String pos = str.substring(SEPARATOR_1.length(),str.indexOf(SEPARATOR_2));
            separators = separators + "|" + pos + "|" + SEPARATOR_1 + "|" + SEPARATOR_2;
        }

    }

    /**
     * 커스텀 구분자 존재 체크
     * @param array 구분자 기준으로 분리한 배열
     * @return 정수 배열의 각 원소들 합
     */
    public int calculate(String[] array){
        // 각 문자열을 정수로 변환하여 정수 배열 생성
        int[] numArray = Arrays.stream(array).mapToInt(str ->
            {
                try {
                    if(str.isEmpty()){
                        return 0;
                    }
                    if(Integer.parseInt(str)<0){
                        throw new IllegalArgumentException();
                    }
                    return Integer.parseInt(str);
                }catch (NumberFormatException e){
                    throw new IllegalArgumentException();
                }
            }).toArray();

        return Arrays.stream(numArray).sum();
    }

    // 시작 함수
    public void start(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        checkCustomSeparator(str);

        String[] array = str.split(separators);

        int result = calculate(array);
        System.out.println("결과 : "+result);
    }
}
