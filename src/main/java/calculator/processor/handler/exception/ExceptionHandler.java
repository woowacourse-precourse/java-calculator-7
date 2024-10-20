package calculator.processor.handler.exception;

import calculator.common.Response;

public class ExceptionHandler {

    public void handle(Response response) {
        if (response.isSuccess()) {
            return;
        }
        if (response.errorMessage().equals("IllegalArgumentException")) {
            throw new IllegalArgumentException();
        }
    }
}
