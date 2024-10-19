package inspector;

public class CustomInspector extends ContentInspector {
    protected String originalContent;
    private String convertedContent;
    private String separator = ",|:";
    private String separatorPrefix;
    private String separatorSuffix;

    public CustomInspector(String originalContent) {
        this.originalContent = originalContent;
        findCustomSeparator();
    }

    private void findCustomSeparator() {
        String separatorPrefix = originalContent.substring(0, 2);
        String separatorSuffix = originalContent.substring(3, 5);
        detectCustomSeparatorFormat(separatorPrefix, separatorSuffix);
        separatorRegistration();
        convertedContent = convertContentFromOriginal(originalContent);
        inspecting(separator, convertedContent);
    }

    private void detectCustomSeparatorFormat(String prefix, String suffix) {
        if (!prefix.equals("//") || !suffix.equals("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자의 생성 형식에 맞지 않음");
        }
    }

    private void separatorRegistration() {
        separator = separator.concat("|" + originalContent.charAt(2));
    }

    private String convertContentFromOriginal(String originalContent) {
        return originalContent.substring(5);
    }

    @Override
    public String getSeparator() {
        return separator;
    }

    @Override
    public String getConvertedContent() {
        return convertedContent;
    }
}
