package calculator.io.page;

public interface Page<T> {

    void setContent(T content);

    T getContent();

    void render();

}
