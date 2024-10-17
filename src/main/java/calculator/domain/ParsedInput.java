package calculator.domain;

public class ParsedInput {
    // 파싱된 숫자들을 저장할 배열
    private final String[] numbers;

    // 생성자: 파싱된 숫자 배열을 받아서 초기화
    public ParsedInput(String[] numbers) {
        this.numbers = numbers;
    }

    // 파싱된 숫자 배열을 반환하는 메서드
    public String[] getNumbers() {
        return this.numbers;
    }
}
