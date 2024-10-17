package calculator.checkMethod;

public class CheckIsPositiveNum {

    public static int isPositiveNum(String operand){
        int operandInt;

        if (operand.equals("")){
            return 0;
        }

        try{
            operandInt = Integer.parseInt(operand);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        if (operandInt > 0){
            return operandInt;
        } else{
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
    }

}
