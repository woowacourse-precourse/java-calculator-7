package calculator.processor.handleradapter;


import calculator.common.Request;
import calculator.common.Response;

public interface HandlerAdapter {
    boolean supports(Request request);

    Response handle(Request request, Object handler);
}
