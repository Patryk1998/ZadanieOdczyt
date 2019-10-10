import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private final String numberPattern = "\\d{9}";

    private Scanner createScanner(String path) throws FileNotFoundException {
        return new Scanner(new File(path));
    }

    public List<User> readFile(String path) throws ReadException, FileNotFoundException {
            Scanner scanner = createScanner(path);

            List<User> result = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(",");

                result.add(createUser(split));
            }
            scanner.close();
            return result;
    }

    private User createUser(String[] data) throws ReadException {
        if(data.length==4) return new User(data[0], data[1], LocalDate.parse(data[2]), validateNumber(data[3]));
        else if(data.length==3) return new User(data[0], data[1], LocalDate.parse(data[2]), 0);
        else throw new ReadException("Brakuje któregoś z pól oprócz numeru");
    }

    private int validateNumber(String number) {
        return number.matches(numberPattern) ? Integer.parseInt(number) : 0;
    }
}
