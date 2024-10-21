package calculator.ui;

class OutputConsole implements OutputUi {

    @Override
    public void printMessage(final String message) {
        System.out.println(message);
    }

    @Override
    public void printResult(final String message) {
        System.out.print(message);
    }
}
