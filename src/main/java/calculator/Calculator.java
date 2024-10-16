package calculator;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Calculator {
    static String separator = ",|:";

    /**
     * 커스텀 구분자 존재 체크
     * @param str 입력받은 문자열
     */
    public void checkCustomSeparator(String str){
        if (str.contains("//") && str.contains("\n")){
            if(str.indexOf("//") != 0){
                throw new IllegalArgumentException();
            }

            String pos = str.substring(1,str.indexOf("\n"));

            separator = separator + "|" + pos;
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

        String[] array = str.split(separator);

        int result = calculate(array);

    }
}
