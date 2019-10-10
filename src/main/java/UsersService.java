import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UsersService {
    private List<User> users;


    public UsersService(List<User> users) {
        this.users = users;
    }

    public User getOldestWithPhone() {
        return users.stream()
                .filter(user -> user.getPhoneNumber()!=0)
                .findFirst()
                .orElse(new User());
    }

    private int getAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void writeOldestWithPhone() {
        User user = getOldestWithPhone();
        System.out.println(user.getName());
        System.out.println(user.getLastname());
        System.out.println(getAge(user.getBirthDate()));
        System.out.println(user.getPhoneNumber());
    }

    public int getQuantity() {
        return users.size();
    }


}
