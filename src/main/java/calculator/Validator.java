package calculator;

public class Validator {

    /*1.빈 문자 확인*/
    public boolean isNull(String input) {
        return input.isEmpty();
    }

    /*2.유효성 검사*/
    public void validation(String[] numbers) {

        for (String num : numbers) {
            if (!isNumeric(num)){
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
            }
            if (Integer.parseInt(num) < 0) {
                throw new IllegalArgumentException("음수가 입력되었습니다. 양수만 입력해주세요.");
            }
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
