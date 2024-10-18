package calculator.service;

import calculator.domain.dto.CalculatorRequestDto;
import calculator.utils.Constant;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CalculatorService {

    // 수식 입력
    public String inputFormula(){
        try {
            return Console.readLine();

        } catch (NoSuchElementException e){
            return "";

        } finally {
            Console.close();
        }
    }

    // 구분자 추출
    public String getSeparator(String value){
        if (isCustom(value)) {
            return getCustomSeparator(value);
        }
        return Constant.BASIC_SEPARATOR;
    }

    // 실사용할 수식 추출
    public String extractFormula(String value) {
        if (isCustom(value)) {
            int formulaStartIndex =
                    value.indexOf(Constant.NEWLINE_INDICATOR) + Constant.NEWLINE_INDICATOR.length();

            return value.substring(formulaStartIndex);
        }
        return value.replaceAll(",", Constant.BASIC_SEPARATOR);
    }

    // 유효성 검사
    public void validateInput(CalculatorRequestDto requestDto) {
        String formula = requestDto.formula();
        String separator = requestDto.separator();

        for (String number : formula.split(separator)) {
            convertStringToInt(number);
        }
    }

    // 수식 계산
    public int calculateFormula(CalculatorRequestDto requestDto){
        int sum = 0;
        String formula = requestDto.formula();
        String separator = requestDto.separator();

        for (String number : formula.split(separator)) {
            sum += convertStringToInt(number);
        }
        return sum;
    }

    // 결과 출력
    public void printResult(int result){
        System.out.println("결과 : " + result);
    }

    // 커스텀 구분자 추출
    private String getCustomSeparator(String value){
        int separatorEndIndex = value.indexOf(Constant.NEWLINE_INDICATOR);
        return value.substring(2, separatorEndIndex);
    }

    // String -> int 변환
    private int convertStringToInt(String str){
        try {
            if (str.isEmpty()) { return 0; }

            int number = Integer.parseInt(str.trim());
            if(number < 0){throw new IllegalArgumentException("양수만 입력 가능합니다.");}

            return number;

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다");
        }
    }

    // 구분자가 기본인지 커스텀인지 판단
    private boolean isCustom(String value) {
        return (value.startsWith(Constant.CUSTOM_SEPARATOR_PREFIX) &&
                value.contains(Constant.NEWLINE_INDICATOR));
    }
}
