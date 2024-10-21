package calculator.exception;

// 사용자 정의 예외 클래스
public class InvalidInputException extends RuntimeException {

    // 생성자: 예외 메시지를 매개변수로 받음
    public InvalidInputException(String message) {
        super(message); // 부모 클래스인 RuntimeException의 생성자 호출
    }
}