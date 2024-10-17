package calculator.domain;

public class Numbers {

    private String[] parts;

    private int[] numbers;

    public Numbers(String[] parts) {
        this.parts = parts;
        this.numbers = new int[parts.length];
    }

    //구분한 결과의 배열안에 구분자 숫자 외에 문자가 있는지 검증한다.
    public void validateOnlyNumber() {
        parseNumbers();
    }

    // 구분한 문자열들을 int 타입으로 변환, 빈 문자열이면 0으로 변환한다.
    private void parseNumbers() {
        for (int i = 0; i < parts.length; i++) {
            String number = parts[i];

            if (number.isEmpty()) {
                numbers[i] = 0;
            } else {
                try {
                    numbers[i] = Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("계산식의 형태가 올바르지 않습니다.");
                }
            }
        }
    }

}
