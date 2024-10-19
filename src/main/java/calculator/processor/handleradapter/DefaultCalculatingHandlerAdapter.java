package calculator.processor.handleradapter;


import calculator.common.Request;

public class DefaultCalculatingHandlerAdapter extends AbstractCalculatingHandlerAdapter {

    @Override
    public boolean supports(Request request) {
        return false;
    }
}
