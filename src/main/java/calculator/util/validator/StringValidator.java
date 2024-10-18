package calculator.util.validator;

import java.math.BigInteger;

public interface StringValidator {

    void validateFormat(final String str);

    void validateRange(final String str, final BigInteger min, final BigInteger max);
}
