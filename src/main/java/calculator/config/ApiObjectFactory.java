package calculator.config;

import calculator.api.StrInput;

public class ApiObjectFactory {

    public static final StrInput newStrInput() {
        return new StrInput();
    }
}
