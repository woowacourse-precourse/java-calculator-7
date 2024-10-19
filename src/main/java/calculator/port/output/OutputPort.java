package calculator.port.output;

import calculator.application.dto.response.Response;

public interface OutputPort {

    void writeMessage(String message);

    void writeResponse(Response response);
}