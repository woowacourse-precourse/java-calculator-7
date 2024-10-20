package calculator.common.io;

import static calculator.common.message.IOMessage.RESULT;
import static java.util.Objects.isNull;

import calculator.infra.view.ResultView;

public class OutputManager implements IOManager {

    private static OutputManager manager;

    // Constructor
    private OutputManager() {
    }

    public static OutputManager getInstance() {
        if (isNull(manager)) {
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
