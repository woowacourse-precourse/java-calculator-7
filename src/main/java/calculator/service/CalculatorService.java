package calculator.service;

import calculator.model.Calculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.regex.Pattern;

/**
 * 해당 클래스는 계산기 서비스를 제공하는 클래스입니다.
 *
 * @author Kalsteve98
 * @since 1.0
 */
public class CalculatorService {
    /**
     * 입력을 받은 데이터를 표시하기 위한 뷰
     */
    private final InputView inputView;
    /**
     * 출력을 표시하기 위한 뷰
     */
    private final OutputView outputView;
    /**
     * 계산을 수행하는 계산기
     */
    private final Calculator calculator;
    /**
     * 기본 구분자는 ,와 :입니다.
     */
    private final static String default_separator = "[,:]";
    /**
     * 숫자들의 형식을 나타내는 정규표현식입니다. 양수이거나 0이고, 콜론 또는 콤마로 구분되어 있습니다.
     */
    private final static String pattern = "^([0-9]\\d*)([,:]([0-9]\\d*))*$";

    /**
     * 계산기 서비스를 생성하는 생성자입니다.
     *
     * @param inputView  입력 뷰
     * @param outputView 출력 뷰
     * @param calculator 계산기
     */
    public CalculatorService(InputView inputView, OutputView outputView, Calculator calculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculator = calculator;
    }

    /**
     * 계산기 서비스를 실행하는 메서드입니다.
     */
    public void run() {
        String input = inputView.inputExpression();

        if (isCustomFormat(input)) {
            input = removeCustomSeparator(input);
        }

        if (!validFormat(input)) {
            throw new IllegalArgumentException("형식에 맞지 않습니다.");
        }

        for (String str : input.split(default_separator)) {
            calculator.add(toInt(str));
        }

        outputView.printResult(calculator.getResult());
    }

    /**
     * 문자열이 커스텀 형식인지 확인하는 내부 메서드입니다.
     *
     * @param str 문자열
     * @return 커스텀 형식이면 true, 그렇지 않으면 false
     */
    private boolean isCustomFormat(String str) {
        return str.startsWith("//");
    }

    /**
     * 문자열이 유효한 형식인지 확인하는 내부 메서드입니다.
     *
     * @param str 문자열
     * @return 유효한 형식이면 true, 그렇지 않으면 false
     */
    private boolean validFormat(String str) {
        return Pattern.matches(pattern, str);
    }

    /**
     * 기본 문자열에서 커스텀 문자열을 제거한 문자열을 제공하는 내부 메서드입니다.
     *
     * @param str 커스텀 구분자가 있는 문자열
     * @return 커스텀 구분자를 제거하고 기본 구분자로 변경된 문자열
     */
    private String removeCustomSeparator(String str) {
        String custom_separator = str.substring(str.indexOf("//") + 2, str.indexOf("\\n"));
        str = str.substring(str.indexOf("\\n") + 2);
        return str.replace(custom_separator, ",");
    }

    public String getSeparator() {
        return default_separator;
    }

    /**
     * 숫자형태인 문자열을 Long형으로 변환하는 내부 메서드입니다.
     *
     * @param str 오직 숫자형태인 문자열
     * @return Long형으로 변환된 숫자
     */
    private Long toInt(String str) {
        return Long.parseLong(str);
    }


}
