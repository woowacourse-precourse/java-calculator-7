package calculator;
import camp.nextstep.edu.missionutils.Console;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        //사용자로부터 문자열 입력 받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();
        int answer = 0;
        String[] atoms;
        if(isNull(inputStr)){
            displayResult(answer);
        }else{
            if (inputStr.startsWith("//")) {//사용자 입력 문자열 분리하기 with 커스텀 구분자
                atoms = splitCustom(inputStr);
                answer = sumNum(atoms);
            }else{//사용자 입력 문자열 분리하기 with 기본 구분자
                atoms = splitBasic(inputStr);
                answer = sumNum(atoms);
            }
            displayResult(answer);
        }
        Console.close();
    }
    private static int sumNum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }
    private static String[] splitCustom(String inputStr) {
        int endDelimeter = inputStr.indexOf("\\n");//이스케이프문 \ 포함
        String delimiter = inputStr.substring(2, endDelimeter);//\n전까지 커스텀 구분자 지정
        inputStr = inputStr.substring(endDelimeter + 2);//구분자 적용 대상 문자열로 분리
        return inputStr.split(delimiter);
    }
    private static String[] splitBasic(String inputStr) {
        return inputStr.split(",|:");
    }
    private static void displayResult(int result) {
        System.out.println("결과: " + result);
    }
    private static boolean isNull(String s) {
        return s == null || s.isEmpty();
    }
}
