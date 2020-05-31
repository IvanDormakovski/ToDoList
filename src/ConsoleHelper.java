import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static void write(String message) {
        System.out.println(message);
    }

    static String readString() {
        String message = null;
        try {
            message = reader.readLine();
        } catch (IOException e) {
            write("Enter the data:");
            return readString();
        }
        return message;
    }

    static int readInt() {
        int message = 0;
        try {
            message = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            write("Enter a numeric value:");
            return readInt();
        }
        return message;
    }
}
