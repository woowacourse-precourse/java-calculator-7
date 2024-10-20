package calculator.service;

public class HeaderUtils {
    public static boolean hasCustomDelimiter(String input) {
        return input != null && input.startsWith("//");
    }

    public static String extractHeader(String input) {
        String endStr = "\\n";
        int endIndex = input.indexOf(endStr);
        if (endIndex == -1) {
            throw new IllegalArgumentException("invalid header: missing newline after header");
        }
        String header = input.substring(0, endIndex+2);//"//"와 "\n" 포함
        validate(header);
        return header;
    }

    private static void validate(String header) {
        if(header.length()!=5){
            throw new IllegalArgumentException("invalid header: invalid length");
        }
    }
}
