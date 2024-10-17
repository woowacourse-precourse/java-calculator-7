package calculator.validate;

public class CalculatorValidate {
    /**
     * 공백 입력 체크
     */
    public boolean isUsingBlank(String userInput)
    {
        return userInput.isEmpty();
    }
    /**
     * 커스텀 구분자 사용 유무 체크
     */
    public boolean isUsingCustomSeparator(String userInput)
    {
        return userInput.length() > 4 && userInput.startsWith("//") && userInput.startsWith("\\n", 3);
    }

    /**
     * 숫자로 변환 가능 체크
     * 숫자로 변환 불가능 하거나 양수가 아닐 경우 null 반환
     */
    public int[] isIntegerParsable(String[] userInput)
    {
        int[] validateIntArray = new int[userInput.length];
        try
        {
            int index = 0;
            for (String element : userInput)
            {
                int number = Integer.parseInt(element);
                if (number < 1)
                {
                    throw new IllegalArgumentException("음수가 입력되었습니다.");
                }
                validateIntArray[index] = Integer.parseInt(element);
                index++;
            }
            return validateIntArray;
        }catch(IllegalArgumentException e){
            System.err.println("숫자로 변환할 수 없습니다.");
            return null;
        }
    }
}
