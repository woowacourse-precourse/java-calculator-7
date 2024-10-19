package calculator.processor.handleradapter;

import calculator.common.Request;

public class CustomCalculatingHandlerAdapter extends AbstractCalculatingHandlerAdapter {

    @Override
    public boolean supports(Request request) {
        String body = (String) request.body();
        if (body.length() < 4) {
            return false;
        }
        if (!body.startsWith("//") || body.charAt(3) != '\n') {
            return false;
        }
        addDelimiter(body.charAt(2));
        return true;
    }
}
