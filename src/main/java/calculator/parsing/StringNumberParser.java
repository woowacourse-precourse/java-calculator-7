package calculator.parsing;

public class StringNumberParser {

    public long parseNumber(String number) {
        if (number == null || number.isEmpty()) {  // 항상 null 체크 먼저
            return 0L;
        }
        try {
            long num = Long.parseLong(number);  // 문자열로부터 long 생성, 앞에서 공백 제거 안 하고 파싱하기 때문에 NumberFormatException 발생
            if (num < 0) {  // 음수 확인
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }
            return num;
        } catch (NumberFormatException e) { // 숫자 형식만
            throw new IllegalArgumentException("잘못된 숫자 형식: " + number);
        }
    }

}
