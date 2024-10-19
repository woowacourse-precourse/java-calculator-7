package calculator.processor.handlermapping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.common.Request;
import calculator.common.RequestType;
import calculator.processor.handler.calculating.CalculatingHandler;
import calculator.processor.handler.calculating.SumHandler;
import org.junit.jupiter.api.Test;

class SumHandlerMappingTest {

    @Test
    void requestType이SUM이면SumHandler를반환한다() {
        // given
        HandlerMapping sumHandlerMapping = new SumHandlerMapping();
        Request request = new Request(RequestType.SUM, null);

        // when
        CalculatingHandler handler = sumHandlerMapping.getHandler(request);

        // then
        assertEquals(handler.getClass(), SumHandler.class);
    }

}