package calculator.isDigit;

public class IsDigit {

    // 구분자로 나눈 뭉치가 숫자로만 되어있는지 확인하는 함수
    public static boolean isValid(String input) {
        for (char c : input.toCharArray()) {
            if ((int) c < 48 || (int) c > 57) { // 아스키 코드 48은 0, 57은 9이므로 그 외는 문자
                throw new IllegalArgumentException("Invalid Input"); // 예외 발생
            }
        }
        return true;
    }
}
