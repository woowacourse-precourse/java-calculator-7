package calculator.service;


interface NumberSeparator {

    public boolean available(final String numberMessage);

    public int getLength();

    public String extract(final String numberMessage);
}
