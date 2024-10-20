package calculator.extract;

public class ExtractService {
    public static final int IDENTIFIER_LENGTH = 4;
    public static final String ILLEGAL_STRING = "잘못된 문자열 형식입니다.";
    public static final int CUSTOM_SEPARATOR_LENGTH = 1;

    private final ExtractRepository extractRepository;
    private String currentStartSeparator;
    private String currentEndSeparator;

    public ExtractService(ExtractRepository extractRepository) {
        this.extractRepository = extractRepository;
        saveExtractSeparators(extractRepository);
    }


    public Character getCustomSeparator(String inputText, int startIndex) {
        if (isCustomSeparator(inputText, startIndex)) {
            char customSeparator = inputText.charAt(startIndex + currentStartSeparator.length());
            return customSeparator;
        }
        throw new IllegalArgumentException(ILLEGAL_STRING);
    }

    private boolean isCustomSeparator(String inputText, int startIndex) {
        return extractRepository
                .getExtracts()
                .stream()
                .anyMatch(extract -> checkCustomSeparatorAndIndex(inputText, startIndex, extract));
    }

    private boolean checkCustomSeparatorAndIndex(String inputText, int startIndex, Extract extract) {
        if (isTextLengthIsLongerThanSeparators(inputText, startIndex, extract)
                && isEqualStartSeparator(inputText, startIndex, extract)
                && isEqualEndSeparator(inputText, startIndex, extract)) {
            currentStartSeparator = extract.startSeparators();
            currentEndSeparator = extract.endSeparators();
            return true;
        }
        return false;
    }

    private boolean isTextLengthIsLongerThanSeparators(String inputText, int startIndex, Extract extract) {
        return startIndex
                + extract.startSeparators().length()
                + extract.endSeparators().length() < inputText.length();
    }

    private boolean isEqualStartSeparator(String inputText, int startIndex, Extract extract) {
        int index = startIndex;
        for (int count = 0; count < extract.startSeparators().length(); index++, count++) {
            if (inputText.charAt(index) != extract.startSeparators().charAt(count)) {
                return false;
            }
        }
        return true;
    }

    private boolean isEqualEndSeparator(String inputText, int startIndex, Extract extract) {
        int index = startIndex + extract.startSeparators().length() + CUSTOM_SEPARATOR_LENGTH;
        for (int count = 0; count < extract.endSeparators().length(); index++, count++) {
            if (inputText.charAt(index) != extract.endSeparators().charAt(count)) {
                return false;
            }
        }
        return true;
    }

    private void saveExtractSeparators(ExtractRepository extractRepository) {
        ExtractSeparator[] extractSeparators = ExtractSeparator.values();
        for (ExtractSeparator extractSeparator : extractSeparators) {
            Extract extract = new Extract(
                    extractSeparator.getStartSeparators(),
                    extractSeparator.getEndSeparators()
            );
            extractRepository.save(extract);
        }

    }

    public int getSeparatorLength() {
        return currentStartSeparator.length() + currentEndSeparator.length();
    }
}
