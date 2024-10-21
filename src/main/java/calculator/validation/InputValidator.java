package calculator.validation;

public class InputValidator {

    public InputValidator(){
    }

    public static boolean hasCustomSplit(String input){
        return input.charAt(0) == '/';
    }

    public static void checkSplit(char splitter){
        if(splitter>='0'&&splitter<='9'){
            throw new IllegalArgumentException("숫자는 구분자가 될 수 없습니다.");
        }
    }

    public static void checkPositiveNumber(long num){
        if(num<0) throw new IllegalArgumentException("잘못된 입력입니다.");
    }

}
