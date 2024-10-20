package calculator.io.page;

public class SimpleTextPage extends AbstractSimpleTextPage {

    private String content;

    public SimpleTextPage() {
        this.setContent("");
    }

    public SimpleTextPage(String content) {
        this.setContent(content);
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

}
