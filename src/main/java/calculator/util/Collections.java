package calculator.util;

public class Collections {

    public static <T> String joinToString(Iterable<T> list) {
        return Collections.joinToString(list, "");
    }

    public static <T> String joinToString(Iterable<T> list, String separator) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (T element : list) {
            if (++count > 1) {
                builder.append(separator);
            }
            builder.append(element);
        }
        return builder.toString();
    }

}
