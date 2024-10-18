package calculator;

public class CustomSeparator {

    public String separator(String st) {
        String separator = "[,:";
        String[] stSplit = st.split("");
        for (int i = 0; i < stSplit.length - 1; i++) {
            if (stSplit[i].equals("/") && stSplit[i + 1].equals("/")) {
                for (int j = i + 2; j < stSplit.length; j++) {
                    if (stSplit[j].equals("\\") && stSplit[j + 1].equals("n")) {
                        break;
                    }
                    separator += stSplit[j];
                }
            }
        }
        separator += "]";
        return separator;
    }

}
