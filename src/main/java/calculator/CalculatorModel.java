package calculator;

public class CalculatorModel {
    private final Util util = new Util();

    public Long[] changeStringtoLongOperandArray(String userInput) {

        if (!util.checkforInvalidPrefix(userInput)) {
            throw new IllegalArgumentException("잘못된 입력값입니다: " + userInput);
        }

        //case1: 커스텀 구분자가 있는 경우

        //case2: 커스텀 구분자가 없는 경우
        String[] operandArrayinString = userInput.split(",|:");
        Long[] operandArrayinLong = changeStringArrtoLongArr(operandArrayinString);

        return operandArrayinLong;
    }

    public Long[] changeStringArrtoLongArr(String[] stringArr) {
        Long[] longArr = new Long[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            longArr[i] = Long.parseLong(stringArr[i]);
        }
        return longArr;
    }


}
