package calculator.global.error.handler;

import calculator.global.error.ErrorMessage;

public class ErrorHandler {


    public static void handlerError(ErrorMessage errorMessage){
        logError(errorMessage);
        throw new IllegalArgumentException("경고 : " + errorMessage.getMessage());
    }

    private static void logError(ErrorMessage errorMessage) {
        System.out.println("에러 메세지 : " + errorMessage.getMessage());
    }
}
