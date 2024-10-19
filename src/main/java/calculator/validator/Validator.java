package calculator.validator;

public class Validator {

    //문자열이 비어있는지 검사 하는 메소드
    public boolean checkIsEmpty(String input) {
        //문장이 비어있으면 false, 존재하면 true
        return !input.isEmpty();
    }
}
