package calculator.service;


interface NumberSeparator {

    public boolean available(final String numberMessage);

    public String extract(final String numberMessage);
}
