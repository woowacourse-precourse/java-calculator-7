package calculator.processor;

import calculator.common.Request;
import calculator.common.Response;
import calculator.processor.handler.calculating.CalculatingHandler;
import calculator.processor.handleradapter.HandlerAdapter;
import calculator.processor.handleradapter.HandlerAdapters;
import calculator.processor.handlermapping.HandlerMappings;
import java.util.NoSuchElementException;

public class Processor {

    private final HandlerMappings handlerMappings;
    private final HandlerAdapters handlerAdapters;

    public Processor() {
        handlerMappings = new HandlerMappings();
        handlerAdapters = new HandlerAdapters();
    }

    /**
     * TODO : 에러 처리 로직 추가
     */
    public Response process(Request request) {
        Response response;
        try {
            CalculatingHandler handler = getHandler(request);
            HandlerAdapter ha = getHandlerAdapter(request);

            response = getResponse(request, ha, handler);
        } catch (NoSuchElementException e) {
            response = Response.NoSuchElementException();
        }

        // 에러 처리 로직 추가
        return response;
    }

    private CalculatingHandler getHandler(Request request) {
        return handlerMappings.getHandler(request);
    }

    private HandlerAdapter getHandlerAdapter(Request request) {
        return handlerAdapters.getHandlerAdapter(request);
    }

    private Response getResponse(Request request, HandlerAdapter ha, CalculatingHandler handler) {
        return ha.handle(request, handler);
    }
}
