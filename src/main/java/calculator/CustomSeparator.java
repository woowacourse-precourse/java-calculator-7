package calculator;

public class CustomSeparator {

    public String[] setCustomSeparator(String req) {

        req = req.replace("\\n", "\n");

        if (req.contains("\n")) {
            String[] part = req.split("\n");

            if (part[0].startsWith("//")) {
                String customSeparator = part[0].replaceFirst("//", "");

                if (customSeparator.length() == 1) {
                    return new String[]{part[1], customSeparator};
                }
                throw new IllegalArgumentException("커스텀 구분자는 한 문자여야 합니다.");
            }
        }
        return null;
    }
}
