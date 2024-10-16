package calculator.port.output;

import calculator.application.dto.response.Response;

public interface OutputPort<T extends Response> {

    void writeMessage(String message);

    void writeResponse(T response);
}