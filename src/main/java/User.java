import java.time.LocalDate;

public class User implements Comparable<User> {

    private String name;
    private String lastname;
    private LocalDate birthDate;
    private int phoneNumber;

    public User() {
    }

    public User(String name, String lastname, LocalDate birthDate, int phoneNumber) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public int compareTo(User otherUser) {
        LocalDate otherBirthDate = otherUser.getBirthDate();
        return birthDate.isAfter(otherBirthDate) ? 1 : -1;
    }
}
