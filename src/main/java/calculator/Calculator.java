package calculator;

public class Calculator {

    String inputString;

    public Calculator(String inputString){
        this.inputString = inputString;
    }

    /**
     * 빈 문자열을 처리하는 메서드
     * @param inputString
     * @return 빈 문자열일 경우 true
     */
    private boolean isEmptyString(String inputString) {
        return inputString == null || inputString.isEmpty();
    }


}
