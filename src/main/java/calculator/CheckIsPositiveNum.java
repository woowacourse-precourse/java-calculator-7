package calculator;

public class CheckIsPositiveNum {


    static int isPositiveNum(String operand){
        int num;

        if (operand.equals("")){
            return 0;
        }

        try{
            num = Integer.parseInt(operand);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        if (num > 0){
            return num;
        } else{
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
    }

}
