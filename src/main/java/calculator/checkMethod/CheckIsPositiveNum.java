package calculator.checkMethod;

public class CheckIsPositiveNum {

    public static double isPositiveNum(String operand){
        double operandNum;

        if (operand.isEmpty()){
            return 0;
        }

        try{
            operandNum = Double.parseDouble(operand);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 숫자 형식으로 바꿀 수 없습니다.");
        }

        if (operandNum > 0){
            return operandNum;
        } else{
            throw new IllegalArgumentException("피연산자로 양수가 아닌 값을 입력하셨습니다.");
        }
    }

}
