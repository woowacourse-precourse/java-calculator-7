package calculator;

public class CalculatorModel {
    private final Util util = new Util();

    public long[] changeStringtoLongOperandArray(String userInput) {
        if (!util.checkforInvalidPrefix(userInput)) {
            throw new IllegalArgumentException("잘못된 입력값입니다: " + userInput);
        }
        if (userInput.isEmpty()) {
            // case1: 문자열이 비어있는 경우
            long[] operandArrayinLong = {0};
            return operandArrayinLong;
        } else if (userInput.startsWith("//")) {
            //case2: 커스텀 구분자가 있는 경우
            int lastDeliiterIndex = getLastCustomDelimiterIndex(userInput);

            String delimiter = getCustomDelimiter(userInput, lastDeliiterIndex);
            String operandSubString = userInput.substring(lastDeliiterIndex + 2, userInput.length());

            long[] operandArrayinLong = getLongArrayFromStringArray(operandSubString, delimiter);
            return operandArrayinLong;

        } else {
            //case3: 커스텀 구분자가 없는 경우
            long[] operandArrayinLong = getLongArrayFromStringArray(userInput, ",|:");
            return operandArrayinLong;
        }
    }

    public long[] getLongArrayFromStringArray(String userInput, String delimiter) {
        String[] operandArrayinString = userInput.split(delimiter);
        long[] operandArrayinLong = changeStringArrtoLongArr(operandArrayinString);

        return operandArrayinLong;
    }


    public long[] changeStringArrtoLongArr(String[] stringArr) {
        long[] longArr = new long[stringArr.length];

        for (int i = 0; i < stringArr.length; i++) {
            try {
                longArr[i] = Long.parseLong(stringArr[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자는 숫자만 입력해주세요: " + stringArr[i]);
            }
        }
        return longArr;
    }

    public int getLastCustomDelimiterIndex(String userInput) {

        // 예외처리: //만 입력후 끝난 경우
        if (userInput.length() < 3) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }
        int delimiterIndex = userInput.indexOf("\\n");
        while (delimiterIndex != -1 && delimiterIndex + 2 < userInput.length() && !Character.isDigit(
                userInput.charAt(delimiterIndex + 2))) {
            delimiterIndex = userInput.indexOf("\\n", delimiterIndex + 2);
        }

        // 예외처리: \n이 끝까지 안나오는 경우
        if (delimiterIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }

        // 예외처리: // 과 마지막 \n에 사이에 아무것도 없는 경우:
        if (delimiterIndex == 2) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }

        return delimiterIndex;
    }

    public String getCustomDelimiter(String userInput, int delimiterIndex) {
        // \n 다음에 아무런 문자열이 오지 않는 경우:
        if (delimiterIndex + 2 >= userInput.length()) {
            throw new IllegalArgumentException("피연산자를 입력하지 않으셨습니다.");
        }
        return userInput.substring(2, delimiterIndex);
    }

    public long calculateSum(String userInput) {
        long sum = 0;
        long[] operandArray = changeStringtoLongOperandArray(userInput);

        // test용
//        for (int i = 0; i < operandArray.length; i++) {
//            System.out.println(operandArray[i]);
//        }

        for (int i = 0; i < operandArray.length; i++) {
            sum += operandArray[i];
        }

        return sum;
    }
}
