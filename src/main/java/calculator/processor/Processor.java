package calculator.processor;

import calculator.common.Request;
import calculator.common.Response;
import calculator.processor.handler.calculating.CalculatingHandler;
import calculator.processor.handler.exception.ExceptionHandler;
import calculator.processor.handleradapter.HandlerAdapter;
import calculator.processor.handleradapter.HandlerAdapters;
import calculator.processor.handlermapping.HandlerMappings;

public class Processor {

    private final HandlerMappings handlerMappings;
    private final HandlerAdapters handlerAdapters;
    private final ExceptionHandler exceptionHandler;

    public Processor() {
        handlerMappings = new HandlerMappings();
        handlerAdapters = new HandlerAdapters();
        exceptionHandler = new ExceptionHandler();
    }

    public Response process(Request request) {
        Response response;
        try {
            CalculatingHandler handler = getHandler(request);
            HandlerAdapter ha = getHandlerAdapter(request);

            response = getResponse(request, ha, handler);
        } catch (IllegalArgumentException e) {
            response = Response.IllegalArgumentException();
        }

        handleException(response);
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

    private void handleException(Response response) {
        exceptionHandler.handle(response);
    }
}
