package calculator.processor.handlermapping;

import calculator.common.Request;
import calculator.processor.handler.calculating.CalculatingHandler;
import java.util.List;
import java.util.NoSuchElementException;

public class HandlerMappings {
    List<HandlerMapping> mappings;

    public HandlerMappings() {
        this.mappings = List.of(new SumHandlerMapping());
    }

    public CalculatingHandler getHandler(Request request) {
        CalculatingHandler handler= null;
        for (HandlerMapping mapping : mappings) {
            handler = mapping.getHandler(request);
            if (handler != null) {
                break;
            }
        }
        if (handler == null) {
            throw new NoSuchElementException("요청을 처리하기 위한 handler가 존재하지 않습니다");
        }
        return handler;
    }
}
