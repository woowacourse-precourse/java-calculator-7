package calculator.domain.data;

public class DataManager {
    private final RawDataType dataType;
    private final String rawData;

    public DataManager(final String rawData) {
        validateRawData(rawData);
        this.rawData = rawData;
        this.dataType = assignDataType(rawData);
    }

    private void validateRawData(final String rawData) {
//        throw new IllegalArgumentException("유효하지 않은 입력입니다 "+rawData);
    }

    private RawDataType assignDataType(final String rawData) {
        return null;
    }

    public String getRawData() {
        return this.rawData;
    }
    public RawDataType getDataType() {
        return this.dataType;
    }
}
