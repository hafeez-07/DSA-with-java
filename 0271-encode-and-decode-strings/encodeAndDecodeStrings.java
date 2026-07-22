
import java.util.*;

class encodeAndDecodeStrings {

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String word : strs) {
            sb.append(word.length())
                    .append("#")
                    .append(word);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int j = 0;
        while (j < str.length()) {
            int n = 0;
            while (str.charAt(j) != '#') {
                n = n * 10 + (str.charAt(j) - '0');
                j++;
            }
            int start = j + 1;
            int end = start + n;
            result.add(str.substring(start, end));
            j = end;

        }
        return result;
    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("Hello");
        strs.add("world");
        System.out.println("Original string");
        for (String str : strs) {
            System.out.print(str + " ");
        }
        System.err.println();
        String encoded = encode(strs);
        System.out.println("Encoded string : " + encoded);
        List<String> decoded = decode(encoded);
        System.err.println("decoded string:");
        for (String x : decoded) {
            System.err.print(x + " ");
        }
    }
}
