package calculator.service.convertor;

public interface NumConverter {
    void convertNumber();

    void validateNumberRange(String numStr);

    Number convertNumberElement(String numStrElement);
}
