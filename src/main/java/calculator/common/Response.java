package calculator.common;

public record Response(Object body, String errorMessage) {

    public Response(Object body) {
        this(body, null);
    }

    public static Response NoSuchElementException() {
        return new Response(null, "NoSuchElementException");
    }

    public boolean isSuccess() {
        return errorMessage == null;
    }
}
