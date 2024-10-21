package calculator;

public class Validator {
    public static void validataInput(String str){
        if(str == null || str.isEmpty()){
            throw new IllegalArgumentException("입력 문자열이 비었습니다.");
        }
    }
}
