import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String string = "Java 46 Java 5 JAVA 6";
        Pattern pattern = Pattern.compile("Java \\d*",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
