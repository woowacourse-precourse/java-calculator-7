package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//";

    /**
     * 입력 문자열에 있는 숫자의 합을 계산합니다.
     * 입력에는 문자열 시작 부분에 지정된 사용자 지정 구분 기호가 포함될 수 있습니다.
     *
     * @param input 구분 기호로 구분된 숫자가 포함된 입력 문자열을 문자열로 입력합니다
     * @숫자의 합을 반환합니다
     * 입력 형식이 잘못되었거나 숫자가 아닌 값이 포함된 경우 @throws IlalArgumentException 처리를 합니다.
     */
    public static int calculateSum(String inputString){
        if(inputString == null || inputString.isEmpty()){
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;
        if (inputString.startsWith(CUSTOM_DELIMITER)) {
            int delimiterIndex = inputString.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 구분자가 없습니다.");
            }
            String customDelimiter = inputString.substring(2, delimiterIndex);
            delimiter= Pattern.quote(customDelimiter);  //Pattern.quote(customDelimiter)를 사용하여 구분자가 정규 표현식의 특수 문자인 경우에도 올바르게 동작하도록 했습니다.
            inputString = inputString.substring(delimiterIndex + 2);
        }

        String[] splitNumbers = inputString.split(delimiter);

        int totalNumber = 0;
        for(String num : splitNumbers){
            int number = Integer.parseInt(num);
            if(number < 0){
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 값이 음수입니다.");
            }
            totalNumber += Integer.parseInt(num);
        }

        return  totalNumber;
    }
}
