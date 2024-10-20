package calculator;

import calculator.operands.Operands;

public class Operator {

    public static <E extends Number> E summation(Operands<E> operands) {
        Number result = 0;
        Class<E> clazz = operands.getType();

        if (clazz == Long.class) {
            for (E number : operands.getData()) {
                if (result.longValue() > Long.MAX_VALUE - number.longValue()) {
                    throw new NumberFormatException();
                }
                result = result.longValue() + number.longValue();
            }
        }

        return clazz.cast(result);
    }
}
