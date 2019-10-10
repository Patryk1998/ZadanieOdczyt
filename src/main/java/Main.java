import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            UsersService usersService = new UsersService(new FileReader().readFile("src\\main\\resources\\users.txt"));
            System.out.println("Liczba użytkowników: " + usersService.getQuantity());
            usersService.writeOldestWithPhone();
        } catch (FileNotFoundException | ReadException e) {
            System.out.println(e.getMessage());
        }

    }
}
