import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UsersServiceTest {

    private static UsersService usersService;

    @BeforeClass
    public static void init() {
        User user1 = new User("AAA", "AAA", LocalDate.of(2000, 10,11), 0);
        User user2 = new User("BBB", "BBB", LocalDate.of(2001, 10,11), 999999999);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        usersService = new UsersService(users);
    }

    @Test
    public void getOldestWithPhone() {
        //Given

        //When
        User oldest = usersService.getOldestWithPhone();

        //Then
        Assert.assertEquals("BBB", oldest.getName());
    }
}