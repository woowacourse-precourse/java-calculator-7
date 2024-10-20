package calculator.io.page;

import calculator.io.read.Reader;
import calculator.io.read.SingleLineReader;

public class SimpleTextReaderPage implements ReaderPage<String, String> {

    private Page<String> page = new SimpleTextPage();

    private Reader<String> reader = new SingleLineReader();

    private String output;

    public SimpleTextReaderPage() {
    }

    public SimpleTextReaderPage(String content) {
        this.setContent(content);
    }

    public SimpleTextReaderPage(String content, Reader<String> reader) {
        this.setContent(content);
        this.setReader(reader);
    }

    public SimpleTextReaderPage(Page<String> page, Reader<String> reader) {
        this.page = page;
        this.setReader(reader);
    }

    @Override
    public void setReader(Reader<String> reader) {
        this.reader = reader;
    }

    @Override
    public Reader<String> getReader() {
        return this.reader;
    }

    @Override
    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String getOutput() {
        return this.output;
    }

    @Override
    public void setContent(String content) {
        this.page.setContent(content);
    }

    @Override
    public String getContent() {
        return this.page.getContent();
    }

    @Override
    public void render() {
        this.page.render();
        this.setOutput(this.read());
    }

    @Override
    public String read() {
        return this.reader.read();
    }

}
