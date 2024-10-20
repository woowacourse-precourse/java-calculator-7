package calculator.model;

public class Calculator {

    public int run(String expression) {
        char[] expressionArray = expression.toCharArray();

        int firstOperand = Character.getNumericValue(expressionArray[0]);
        int secondOperand = 0;
        Opcode  opcode = null;

        for (int i = 1; i < expressionArray.length; i++) {
            if (i % 2 == 0) {
                secondOperand = Character.getNumericValue(expressionArray[i]);
                firstOperand = calculate(firstOperand,secondOperand,opcode);
            }
            if (expressionArray[i] == '+') {
                opcode = Opcode.PLUS;
            }
        }

        return firstOperand;
    }

    public int calculate(int a, int b, Opcode opcode) {
        if (opcode == null) {
            throw new RuntimeException("Expression 클래스 오류");
            // 언체크 에러
        }
        String op = opcode.getOpcode();
        int result = -1;

        if(op.equals("+")){
            result = a + b;
        }
        // 이제 나열하면서 여기 값 넣을 함수 구현해야함
        return result;
    }

}
