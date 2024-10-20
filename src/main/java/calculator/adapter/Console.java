package calculator.adapter;

import calculator.domain.Number;

public class Console {
    private final MessageInputAdapter messageInputAdapter;
    private final MessageOutputAdapter messageOutputAdapter;

    public Console(MessageInputAdapter messageInputAdapter, MessageOutputAdapter messageOutputAdapter) {
        this.messageInputAdapter = messageInputAdapter;
        this.messageOutputAdapter = messageOutputAdapter;
    }

    public String readString() {
        messageOutputAdapter.printInputMessage();
        return messageInputAdapter.readString();
    }

    public void printResult(final Number result) {
        messageOutputAdapter.printResult(result);
    }
}
