package calculator.model;

public class Equation {
    public Integer[] nums;

    public Equation(String expression) {
        parse(expression);
    }

    // 입력받은 표현식을 구분자와 수식으로 분리하는 메소드
    public void parse(String expression) {
        Separator separator = new Separator();
        var raw = separator.consumeCustomSeparator(expression); // 입력받은 문자열 중 수식을 저장
        if(!isValid(raw, separator)) {
            throw new IllegalArgumentException();
        }
        String[] strNums = raw.split("[" + separator.raw +"]"); // 수식을 구분자로 분리해 나온 숫자들을 배열로 저장

        nums = new Integer[strNums.length];
        for(int i = 0; i < strNums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]); // 숫자가 문자열 자료형이므로 정수형으로 변환
        }
    }

    // 수식에 유효한 문자열이 있는지 검사하는 메소드
    public boolean isValid(String expression, Separator separator) {
        var a = expression.replaceAll("[\\d" + separator.raw + "]", ""); // 문자열에서 유효한 문자를 모두 제거
        return a.isEmpty(); // 문자열이 비어있는지 결과를 반환
    }

    // 수식에서 분리한 숫자들을 더하는 메소드
    public Integer sum() {
        Integer sum = 0;

        for(Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
