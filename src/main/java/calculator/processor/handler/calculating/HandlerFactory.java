package calculator.processor.handler.calculating;

import calculator.common.Request;

public class HandlerFactory {

    public CalculatingHandler getHandler(Request request) {
        String handlerName = request.type().name().toLowerCase();
        String className = capitalize(handlerName) + "Handler";

        try {
            Class<?> handlerClass = Class.forName("calculator.processor.handler.calculating." + className);
            return (CalculatingHandler) handlerClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("요청을 처리하기 위한 handler가 존재하지 않습니다");
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
