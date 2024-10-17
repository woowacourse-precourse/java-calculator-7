package calculator.service;

import calculator.constant.ErrorStatus;
import calculator.constant.message.Command;
import java.util.List;

public class CalculatorService {

    private CalculatorService() {
    }

    // private 클래스이므로 외부에서 접근할 수 없다.
    private static class CalculatorServiceHolder {
        private static final CalculatorService INSTANCE = new CalculatorService();
    }

    public static CalculatorService getInstance() {
        return CalculatorServiceHolder.INSTANCE;
    }
    
    public Long calculateNumbers(List<Long> numbers) {
        Long result = 0L;
        for (Long number : numbers) {
            // Overflow or 양수가 아닌 경우
            if (result + number < result || number <= 0) {
                throw new IllegalArgumentException(ErrorStatus.INVALID_RANGE.getMessage());
            }
            result += number;
        }
        return result;
    }

    public Command checkCommand(Integer command) {
        for (Command c : Command.values()) {
            if (c.getCommand().equals(command)) {
                return c;
            }
        }
        throw new IllegalArgumentException(ErrorStatus.INVALID_COMMAND.getMessage());
    }
}
