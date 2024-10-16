package calculator.port.input;

import calculator.application.dto.request.Request;

public interface InputPort <T extends Request> {

    T readRequest();
}
