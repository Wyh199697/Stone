import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexser {
    public static void main(String[] args){
        String regex="\\s*((//.*)|([0-9]+)|(\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\")"
                + "|[A-Z_a-z][A-Z_a-z0-9]*|==|<=|>=|&&|\\|\\||\\p{Punct})?";
        String text = " ";
        Pattern p = Pattern.compile(regex);
        Matcher matcher = p.matcher(text);
        matcher.useTransparentBounds(true).useAnchoringBounds(false); // About this code you can view the API
        int pos = 0;
        int endPos = text.length();
        while (pos < endPos) {
            matcher.region(pos, endPos); // Sets the limits of this matcher's region
            if (matcher.lookingAt()) { // Attempts to match the input sequence, starting at the beginning of the region, against the pattern
                pos = matcher.end(); // Returns the offset after the last matching character
                System.out.print(pos);
                System.out.print(matcher.group(1));
                System.out.print(matcher.group(2));
                System.out.print(matcher.group(3));
                System.out.println(matcher.group(4));
            }
        }
        String[] str = "a a a a".split(" ");
        System.out.println(Arrays.toString(str));
        System.out.println(System.currentTimeMillis());
    }
}
/**
 * 输出结果
 * Exception in thread "main" java.lang.IllegalStateException: No match available
 * at java.util.regex.Matcher.start(Matcher.java:343)
 * at entry.Lexer.main(Lexer.java:18)
 * */
