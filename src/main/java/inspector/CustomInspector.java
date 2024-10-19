package inspector;

public class CustomInspector extends ContentInspector {
    protected String originalContent;
    private String convertedContent;
    private String parsingSeparator = ",|:";


    public CustomInspector(String originalContent) {
        this.originalContent = originalContent;
        findCustomSeparator();
    }

    private void findCustomSeparator() {
        String separatorPrefix = originalContent.substring(0, 2);
        String separatorSuffix = originalContent.substring(3, 5);
        if (!separatorPrefix.equals("//") || !separatorSuffix.equals("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자의 생성 형식에 맞지 않음");
        }
        separatorRegistration();
        convertedContent = convertContentFromOriginal(originalContent);
        inspecting(convertedContent, parsingSeparator);
    }

    private void separatorRegistration() {
        parsingSeparator = parsingSeparator.concat("|" + originalContent.charAt(2));
    }

    private String convertContentFromOriginal(String originalContent) {
        return originalContent.substring(5);
    }

    @Override
    public String getParsingSeparator() {
        return parsingSeparator;
    }

    @Override
    public String getConvertedContent() {
        return convertedContent;
    }
}
