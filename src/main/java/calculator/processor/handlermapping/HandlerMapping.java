package calculator.processor.handlermapping;

import calculator.common.Request;
import calculator.processor.handler.calculating.CalculatingHandler;

public interface HandlerMapping {

    CalculatingHandler getHandler(Request request);
}
