package calculator;

public class ConvertParseInt {
    // 분리한 String을 숫자로 바꾸며 빈칸은 0으로 바꾸는 메서드
    public int convertParseInt(String number) {
        if (number == null || number.isBlank()) {
            return 0;
        }
        return Integer.parseInt(number);
    }
}
