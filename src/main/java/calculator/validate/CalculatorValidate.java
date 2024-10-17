package calculator.validate;

public class CalculatorValidate {
    /**
     * 커스텀 구분자 사용 유무 체크
     */
    public boolean isUsingCustomSeparator(String userInput)
    {
        return userInput.length() > 4 && userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }

    /**
     * 숫자로 변환 가능 체크
     * 숫자로 변환 불가능 할 시 빈 Array 반환
     */
    public int[] isIntegerParsable(String[] userInput)
    {
        int[] validateIntArray = new int[userInput.length];
        try
        {
            int index = 0;
            for (String element : userInput)
            {
                validateIntArray[index] = Integer.parseInt(element);
                index++;
            }
            return validateIntArray;
        }catch(IllegalArgumentException e){
            return validateIntArray;
        }
    }
}
