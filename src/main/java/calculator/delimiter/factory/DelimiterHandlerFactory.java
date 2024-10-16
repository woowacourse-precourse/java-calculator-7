package calculator.delimiter.factory;

import calculator.delimiter.handler.impl.ColonSemicolonDelimiterHandler;
import calculator.delimiter.handler.impl.CustomDelimiterHandler;
import calculator.delimiter.handler.DelimiterHandler;

import java.util.ArrayList;
import java.util.List;

public class DelimiterHandlerFactory {
    private List<DelimiterHandler> handlers;

    public DelimiterHandlerFactory() {
        handlers = new ArrayList<>();
        handlers.add(new ColonSemicolonDelimiterHandler());
        handlers.add(new CustomDelimiterHandler());
    }

    public DelimiterHandler getHandler(String str) {
        for (DelimiterHandler handler : handlers) {
            if (handler.isSupport(str)) return handler;
        }
        throw new IllegalArgumentException("핸들러를 찾을 수 없습니다.");
    }
}
