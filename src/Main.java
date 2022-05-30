import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    static String message = "Hello World!!!";
    static String test = "Это произвольный текст для проверки шифрования.";
    static String testPath = "C:\\Users\\admin\\IdeaProjects\\TestProject\\src\\com\\javarush\\test\\secretTest.txt";
    static String resultPath = "C:\\Users\\admin\\Desktop\\newSecret.txt";

    public static void main(String[] args) {
        Path pathScanner = Path.of(testPath);
        if (Files.isRegularFile(pathScanner)) {
            try {
                String buffer = Files.readString(pathScanner) +"\n"+  test;
                Files.createFile(Path.of(resultPath));
                System.out.println(buffer);
                String result = String.valueOf(Files.writeString(Path.of(resultPath), buffer));
                System.out.println(result);
            } catch (IOException e) {
                System.err.println("Ошибка!");
            }

        } else {
            System.err.println("Фаил не найден!");
        }
        System.out.println("Good!");
    }
}
