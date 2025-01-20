import java.security.SecureRandom;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random secureRandom = new SecureRandom();

        int sizePass = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer(sizePass);

        int[] options = new int[4];

        for(int i = 0; i < options.length; i++) options[i] = scanner.nextInt();

        char[][] charset = {
                "abcdefghijklmnopqrstuvwxyz".toCharArray(),
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(),
                "1234567890".toCharArray(),
                "!@#$%¨&*()-_=+,.;/><?[]{}".toCharArray()
        };

        List<char[]> chosenCharset = new ArrayList<>();

        for(int i = 0; i < options.length; i++) if(options[i] == 1) chosenCharset.add(charset[i]);

        int randomCharsetIndex;
        int randomCharIndex;

        for(int i = 0; i < sizePass; i++){
            if(i < chosenCharset.size()){
                randomCharsetIndex = i;
            } else {
                randomCharsetIndex = secureRandom.nextInt(chosenCharset.size());
            }
            randomCharIndex = secureRandom.nextInt(chosenCharset.get(randomCharsetIndex).length);
            stringBuffer.append(chosenCharset.get(randomCharsetIndex)[randomCharIndex]);
        }

        String password = stringBuffer.toString();
        System.out.println(password);

    }
}