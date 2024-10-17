package calculator.validate;

public class CalculatorValidate {
    /**
     * 커스텀 구분자 사용 유무 체크
     */
    public boolean isUsingCustomSeparator(String userInput)
    {
        return userInput.length() > 4 && userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }
}
