package calculator.processor.handleradapter;

import calculator.common.Request;
import java.util.List;
import java.util.NoSuchElementException;

public class HandlerAdapters {

    List<HandlerAdapter> handlerAdapters = List.of(
        new CustomCalculatingHandlerAdapter(),
        new DefaultCalculatingHandlerAdapter()
    );

    public HandlerAdapter getHandlerAdapter(Request request) {
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.supports(request)) {
                return handlerAdapter;
            }
        }
        throw new NoSuchElementException("요청을 처리하기 위한 handlerAdapter가 존재하지 않습니다");
    }
}
