package calculator.controller;

public class ErrorResponseHandler {

    public String handleError(IllegalArgumentException e) {
        return "에러: " + e.getMessage(); // 에러 메시지를 사용자에게 반환
    }
}
