package calculator.executor;

import calculator.domain.Separators;
import calculator.domain.TargetNumbers;
import calculator.generator.SeparatorsGenerator;
import calculator.generator.TargetNumbersGenerator;
import calculator.printer.Printer;
import calculator.reader.Reader;

public class Executor {

    private static final String GUIDE_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE_FORMAT = "결과 : %d";

    private final Printer printer;
    private final Reader reader;
    private final SeparatorsGenerator separatorsGenerator;
    private final TargetNumbersGenerator targetNumbersGenerator;


    public Executor(Printer printer,
                    Reader reader,
                    SeparatorsGenerator separatorsGenerator,
                    TargetNumbersGenerator targetNumbersGenerator
    ) {
        this.printer = printer;
        this.reader = reader;
        this.separatorsGenerator = separatorsGenerator;
        this.targetNumbersGenerator = targetNumbersGenerator;
    }

    public void run() {
        printer.print(GUIDE_MESSAGE);
        String input = reader.read();

        Separators separators = separatorsGenerator.create(input);
        TargetNumbers targetNumbers = targetNumbersGenerator.create(separators, input);
        int result = targetNumbers.calculateSum();
        printer.printWithFormat(RESULT_MESSAGE_FORMAT, result);
    }

}
