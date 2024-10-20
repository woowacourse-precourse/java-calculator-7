package calculator;

public class CalculatorModel {
    private final Util util = new Util();

    public long[] changeStringtoLongOperandArray(String userInput) {
        int lastIndex = getLastIndexofCustomDelimiter(userInput);
        System.out.println(lastIndex);
        
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

    public int getLastIndexofCustomDelimiter(String userInput) {

        // 예외처리: //만 입력후 끝난 경우
        if (userInput.length() < 3) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }

        int delimiter = userInput.lastIndexOf("\\n");
        //System.out.println(delimiter);

        // 예외처리: \n이 끝까지 안나오는 경우
        if (delimiter == -1) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }

        // 예외처리: // 과 마지막 \n에 사이에 아무것도 없는 경우:
        if (delimiter == 2) {
            throw new IllegalArgumentException("커스텀 구분자를 입력하지 않으셨습니다.");
        }

        // System.out.println(delimiter);

        return delimiter;
    }


}
