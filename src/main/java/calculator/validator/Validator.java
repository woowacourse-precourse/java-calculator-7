package calculator.validator;

public class Validator {
    private String input;
    public Validator(String input){
        this.input = input;
    }
    //공백이 아닐경우, 입력의 마지막이 숫자인지 확인한다.
    public boolean checkValid() {
        if(!isBlank()){
            lastIsNumber();
            return true;
        }
        return false;
    }
    //입력이 공백인지 확인한다.
    public boolean isBlank(){
        if(input.isBlank()){
            return true;
        }
        return false;
    }
    //입력의 마지막이 숫자인지 확인한다.
    public void lastIsNumber(){
        if(!Character.isDigit(input.charAt(input.length() - 1))){
            throw new IllegalArgumentException("입력이 잘못되었습니다.(마지막 문자가 숫자가 아닙니다.)");
        }
    }
    //구분자로 분리 후, 양수인지 확인한다.
    public boolean contentIsPosNum(String[] input) {
        //구현중
        return true;
    }
}