package transfer.util;



public class InputUtil {

    public static String escape(String input) {
        String escaped = "";
        for (char c : input.toCharArray()) {
            if (c == '\'') {
                escaped += "''";
                continue;
            }
            escaped += c;
        }
        return escaped;
    }

}
