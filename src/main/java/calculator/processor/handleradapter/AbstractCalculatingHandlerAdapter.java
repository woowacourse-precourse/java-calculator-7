package calculator.processor.handleradapter;

import calculator.common.Request;
import calculator.common.Response;
import calculator.processor.domain.Number;
import calculator.processor.domain.Numbers;
import calculator.processor.handler.calculating.CalculatingHandler;

public abstract class AbstractCalculatingHandlerAdapter implements HandlerAdapter {

    protected static String delimiter = ";|,";

    @Override
    public abstract boolean supports(Request request);

    public Response handle(Request request, Object handler) {
        Numbers numbers = toNumbers(request);
        Number result = ((CalculatingHandler) handler).handle(numbers);

        return new Response(result);
    }

    private static Numbers toNumbers(Request request) {
        String body = request.body().toString();
        return new Numbers(body.split(delimiter));
    }

    protected void addDelimiter(char newDelimiter) {
        delimiter += ("|" + newDelimiter);
    }
}
