import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

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
            randomCharsetIndex = random.nextInt(chosenCharset.size());
            randomCharIndex = random.nextInt(chosenCharset.get(randomCharsetIndex).length);
            stringBuffer.append(chosenCharset.get(randomCharsetIndex)[randomCharIndex]);
        }

        String password = stringBuffer.toString();
        System.out.println(password);

    }
}