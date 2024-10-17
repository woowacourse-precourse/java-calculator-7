package calculator.Validator;

public class InputValidator {

    public void validateTokens(String[] tokens){

        if(tokens.length < 1){
            throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
        }
        for(String token : tokens){

            token = token.trim();

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
