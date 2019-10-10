import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileReaderTest {

    private FileReader fileReader = new FileReader();
    private final String general = "src\\main\\resources\\usersTest.txt";
    private final String createUserConditionsAndNumberValidation = "src\\main\\resources\\usersTest1.txt";
    private final String createUserExceptions = "src\\main\\resources\\usersTest2.txt";




    @Test
    public void readFileReturnSameList() throws Exception {
        //Given

        //When
        List<User> resultList = fileReader.readFile("src\\main\\resources\\usersTest.txt");
        User user1 = resultList.get(0);
        User user2 = resultList.get(1);

        //Then
        Assert.assertEquals("Patryk", user1.getName());
        Assert.assertEquals("Lis", user1.getLastname());
        Assert.assertEquals(LocalDate.parse("2000-12-20"), user1.getBirthDate());
        Assert.assertEquals(999999999, user1.getPhoneNumber());
        Assert.assertEquals("Kopa", user2.getName());
        Assert.assertEquals("Liso", user2.getLastname());
        Assert.assertEquals(LocalDate.parse("2001-12-20"), user2.getBirthDate());
        Assert.assertEquals(999222111, user2.getPhoneNumber());
    }

    @Test
    public void createUserConditionsAndNumberValidation() throws Exception {
        //Given
        List<User> users = fileReader.readFile(createUserConditionsAndNumberValidation);

        //When

        //Then
        Assert.assertEquals(999999999, users.get(0).getPhoneNumber());
        Assert.assertEquals(0, users.get(1).getPhoneNumber());
        Assert.assertEquals(0, users.get(2).getPhoneNumber());
    }

    @Test(expected = Exception.class)
    public void createUserException() throws Exception {
        //Given
        //When
        //Then

        fileReader.readFile(createUserExceptions);
    }
}