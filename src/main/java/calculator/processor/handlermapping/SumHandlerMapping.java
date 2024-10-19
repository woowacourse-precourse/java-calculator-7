package calculator.processor.handlermapping;

import calculator.common.Request;
import calculator.common.RequestType;
import calculator.processor.handler.calculating.CalculatingHandler;
import calculator.processor.handler.calculating.SumHandler;

public class SumHandlerMapping implements HandlerMapping{

    @Override
    public CalculatingHandler getHandler(Request request) {
        if (request.type() == RequestType.SUM) {
            return new SumHandler();
        }
        return null;
    }
}
