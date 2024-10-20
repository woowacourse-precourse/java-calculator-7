package calculator.io.page;

import calculator.io.read.Reader;

public interface ReaderPage<PAGE, OUT> extends Reader<OUT>, Page<PAGE> {

    void setReader(Reader<OUT> reader);

    Reader<OUT> getReader();

    void setOutput(OUT output);

    OUT getOutput();

}
