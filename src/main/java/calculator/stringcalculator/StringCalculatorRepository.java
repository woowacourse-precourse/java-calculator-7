package calculator.stringcalculator;

import java.util.List;

public interface StringCalculatorRepository {

    /*
    구분자 저장
     */
    void saveDelimiters(String Delimiters);

    /*
    숫자 저장
     */
    void saveNumbers(String[] Numbers);

    /*
    구분자 반환
     */
    List<String> getDelimiters();

    /*
    숫자 반환
     */
    List<String> getNumbers();

}
