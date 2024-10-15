package calculator.status;

public enum ApplicationStatus {

    INIT,
    EXTRACT_CUSTOM_DELIMITER,
    ADD_ON_DELIMITER_SET,
    SPLIT_STRING,
    ADD_ALL_NUMBER,
    PRINT_RESULT,
    EXIT;

    public boolean playable() {
        return this != EXIT;
    }

}
