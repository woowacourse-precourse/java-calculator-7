package calculator.controller.io;

public class OutputHandler {

    public void showEntryMessage() {
        System.out.println(IoMessage.ENTRY.getDescription());
    }

    public void showCalculatedValue(int cost) {
        System.out.println(IoMessage.RESULT.getDescription() + cost);
    }
}