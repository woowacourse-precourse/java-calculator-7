package calculator.common;

public record Response(Object body, String errorMessage) {

    public Response(Object body) {
        this(body, null);
    }
}
