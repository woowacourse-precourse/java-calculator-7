package calculator.stringcalculator;

import java.util.List;

public interface StringCalculatorService {

    /*
        입력값 형식 검증
        //"    "\n 숫자 ~ ; , "   " 숫자
     */
    void validateInputForm(String input);

    /*
        문자열 계산
     */
    long calculate(String input);

    /*
        문자열에서 구분자 추출
     */
    String extractDelimiter(String input);

    /*
        문자열에서 숫자 추출
     */
    String[] extractNumber(String input, List<String> delimiters);

    /*
        정해진 구분자 이외의 구분자 입력 여부 검증
    */
    void validateInputDelimiter(String[] stringNumbers);

    /*
        슷자 문자열 더하기
     */
    long addStringNumbers(String[] stringNumbers);

}
