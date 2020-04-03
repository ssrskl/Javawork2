import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String string = "Java 4";
        Pattern pattern = Pattern.compile("Java \\d");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
