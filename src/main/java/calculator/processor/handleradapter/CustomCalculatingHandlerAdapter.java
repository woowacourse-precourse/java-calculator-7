package calculator.processor.handleradapter;

import calculator.common.Request;
import calculator.common.Response;

public class CustomCalculatingHandlerAdapter extends AbstractCalculatingHandlerAdapter {

    @Override
    public boolean supports(Request request) {
        String body = (String) request.body();
        if (body.length() < 4) {
            return false;
        }
        if (!body.startsWith("//") || body.indexOf("\\n") <= 2) {
            return false;
        }
        addDelimiter(body.charAt(2));
        return true;
    }

    @Override
    public Response handle(Request request, Object handler) {
        String body = request.body().toString();
        return super.handle(new Request(request.type(), body.substring(5)), handler);
    }
}
