package calculator.config;

import calculator.executor.Executor;
import calculator.extractor.CustomSeparatorExtractor;
import calculator.extractor.RegexCustomSeparatorExtractor;
import calculator.extractor.RegexTargetNumbersExtractor;
import calculator.extractor.TargetNumbersExtractor;
import calculator.generator.RegexSeparatorsGenerator;
import calculator.generator.SeparatorsGenerator;
import calculator.generator.TargetNumbersGenerator;
import calculator.printer.ConsolePrinter;
import calculator.printer.Printer;
import calculator.reader.ConsoleReader;
import calculator.reader.Reader;
import calculator.remover.CustomSeparatorRemover;
import calculator.remover.RegexCustomSeparatorRemover;

public class ExecutorConfig {

    public Executor executor() {
        return new Executor(
                consolePrinter(),
                consoleReader(),
                separatorsGenerator(),
                targetNumbersGenerator()
        );
    }

    public Reader consoleReader() {
        return new ConsoleReader();
    }

    public Printer consolePrinter() {
        return new ConsolePrinter();
    }

    public SeparatorsGenerator separatorsGenerator() {
        return new RegexSeparatorsGenerator(customSeparatorExtractor());
    }

    public CustomSeparatorExtractor customSeparatorExtractor() {
        return new RegexCustomSeparatorExtractor();
    }

    public TargetNumbersGenerator targetNumbersGenerator() {
        return new TargetNumbersGenerator(customSeparatorRemover(), targetNumbersExtractor());
    }

    public TargetNumbersExtractor targetNumbersExtractor() {
        return new RegexTargetNumbersExtractor();
    }

    public CustomSeparatorRemover customSeparatorRemover() {
        return new RegexCustomSeparatorRemover();
    }

}
