package calculator.stringcalculator;

public interface StringCalculatorService {

    /*
    입력값 형식 검증
    //"    "\n 숫자 ~ ; , "   " 숫자
     */
    void validateInputForm(String input);

    /*
    정해진 구분자 이외의 구분자 입력 여부 검증
     */
    void validateInputDelimiters(String input);

    /*
    문자열에서 구분자 추출 and 저장 + 디폴트 지정자까지
     */
    void extractDelimiters(String input);

    /*
    문자열에서 숫자 추출
     */
    void extractNumber(String input);

    /*
    숫자 덧셈
     */
    String calculate(String input);
}
