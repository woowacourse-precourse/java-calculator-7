package calculator;

public class ConvertParseInt {

    /**
     * 입력된 문자열을 정수로 변환하는 메서드
     *
     * @param number 변환할 문자열
     * @return 문자열이 변환된 정수 값, 빈 문자열일 경우 0 반환
     */
    public int convertParseInt(String number) {
        if (number == null || number.isBlank()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
