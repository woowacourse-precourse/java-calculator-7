package calculator.model.io;

import calculator.infra.view.ResultView;

import java.util.Objects;

import static calculator.common.message.IOMessage.RESULT;

public class OutputManager implements IOManager{

    private static OutputManager manager;

    // Constructor
    private OutputManager() {
    }

    public static OutputManager getInstance() {
        if (Objects.isNull(manager)) {
            manager = new OutputManager();
        }
        return manager;
    }

    // Method
    public void offerCalculateResult(ResultView resultView) {
        String formattedMessage = String.format(RESULT, resultView.toString());
        printMessage(formattedMessage);
    }
}
