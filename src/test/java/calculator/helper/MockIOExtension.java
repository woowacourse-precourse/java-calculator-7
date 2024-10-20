package calculator.helper;

import static java.util.Objects.nonNull;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class MockIOExtension implements BeforeEachCallback, AfterEachCallback {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private final PrintStream printStream = System.out;

    @Override
    public void beforeEach(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        MockInput annotation = testMethod.getAnnotation(MockInput.class);
        if (nonNull(annotation)) {
            String userInput = annotation.value();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(byteArrayInputStream);
            ReflectionUtil.forceSetField(Console.class, "scanner", new Scanner(System.in));
        }
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.setOut(printStream);
        System.out.println(byteArrayOutputStream.toString());
    }

    public static String getOutput() {
        return byteArrayOutputStream.toString().split(":")[1].strip();
    }
}
