package calculator;

public class StringValidator {

    public void nullValidate(String input) {
        if (input.isBlank()) {
        }
    }



    public void numValidate(String input){
        // 예외처리는 validate()로 구현
        //숫자가 없는지는 배열에서 판별 -> 예외

        int count = 0;
        for (int i = 0; i < input.length(); i++){
            if ( '0' <= input.charAt(i) || input.charAt(i) <='9'){

            }


        }

    }
}
