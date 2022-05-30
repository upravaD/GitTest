import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    static String message = "Daktah™";
    static String test = "===================================" +
                         "\nЭто произвольный текст для проверки шифрования.";
    static String testPath = "C:\\Users\\admin\\IdeaProjects\\TestProject\\src\\com\\javarush\\test\\secretTest.txt";
    static int count = (int) (Math.random() * 1000);
    static String resultPath = "C:\\Users\\admin\\Desktop\\newSecret.txt";
    static String resultPath2 = "C:\\Users\\admin\\Desktop\\newSecret" + count + ".txt";

    public static void main(String[] args) {
        //Path pathScanner = Path.of(testPath);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите полный путь к файлу: ");
        Path pathScanner = Path.of(scanner.nextLine());
        if (Files.isRegularFile(pathScanner)) {
            try {
                String buffer = Files.readString(pathScanner) +"\n"+  test +"\n"+ message;
                if (!Files.exists(Path.of(resultPath))) {
                    Files.createFile(Path.of(resultPath));
                    String result = String.valueOf(Files.writeString(Path.of(resultPath), buffer));
                    System.out.println("Ваш файл зашифрован и лежит по адресу:");
                    System.out.println(result);
                } else {
                    Files.createFile(Path.of(resultPath2));
                    String result = String.valueOf(Files.writeString(Path.of(resultPath2), buffer));
                    System.out.println("Ваш файл зашифрован и лежит по адресу:");
                    System.out.println(result);
                }
            } catch (IOException e) {
                System.err.println("Системная ошибка!");
            }

        } else {
            System.err.println("Фаил не найден!");
        }
        System.out.println(message);
    }
}
