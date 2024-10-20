package calculator.util;

import calculator.domain.Form;

public class StringSplitter {

    public static String[] stringToArray(Form form) {
        String ex = form.getExpression().replace(form.getSeparator().get(0), form.getSeparator().get(1));
        return ex.split(form.getSeparator().get(1));
    }
}
