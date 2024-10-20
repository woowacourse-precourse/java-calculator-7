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
        }
//        else if (userInput.startsWith("//")) {
//            //case2: 커스텀 구분자가 있는 경우
//
//        }
        else {
            //case3: 커스텀 구분자가 없는 경우
            String[] operandArrayinString = userInput.split(",|:");
            long[] operandArrayinLong = changeStringArrtoLongArr(operandArrayinString);

            return operandArrayinLong;
        }
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
}
