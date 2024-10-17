package calculator.domain;

public class Numbers {

    private String[] numbers;

    public Numbers(String[] numbers) {
        this.numbers = numbers;
    }

    //구분한 결과의 배열안에 구분자 숫자 외에 문자가 있는지 검증한다.
    public void validateOnlyNumber() {
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("계산식의 형태가 올바르지 않습니다.");
            }
        }
    }

}
