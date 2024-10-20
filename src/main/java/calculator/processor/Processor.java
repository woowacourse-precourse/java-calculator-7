package calculator.processor;

import calculator.common.Request;
import calculator.common.Response;
import calculator.processor.handler.calculating.CalculatingHandler;
import calculator.processor.handler.calculating.HandlerFactory;
import calculator.processor.handler.exception.ExceptionHandler;
import calculator.processor.handleradapter.HandlerAdapter;
import calculator.processor.handleradapter.HandlerAdapters;

public class Processor {

    private final HandlerFactory handlerFactory;
    private final HandlerAdapters handlerAdapters;
    private final ExceptionHandler exceptionHandler;

    public Processor() {
        handlerFactory = new HandlerFactory();
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
        return handlerFactory.getHandler(request);
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
