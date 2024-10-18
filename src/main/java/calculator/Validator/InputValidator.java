package calculator.Validator;

import calculator.Interface.Validator;

public class InputValidator implements Validator {

    @Override
    public void validateTokens(String[] tokens){

        if(tokens.length < 1){
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
        for(String token : tokens){

            if(token.contains(" ")){
                throw new IllegalArgumentException("공백은 허용되지 않습니다.");
            }

            if(token.isEmpty()){
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }

            if(!isNumeric(token)){
                throw new IllegalArgumentException("숫자가 아닙니다");
            }

        }
    }

    private boolean isNumeric(String token){
        return token.matches("\\d+");
    }



}
