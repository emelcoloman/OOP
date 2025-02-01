package Practice;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void testWriteToFile(){
    try {
        User user = new User("testUser", "123",1, "test@example.com");
        user.writeToFile();
        try(BufferedReader br = new BufferedReader(new FileReader("/tmp/userDetails"))){
            String line1 = br.readLine();
            String line2 = br.readLine();
            assertEquals("Username: testUser", line1);
            assertEquals("Password: 123", line2);
            assertNull(br.readLine());
        } catch (IOException e){
            fail("IO Exception found ");
        }
    } catch (PasswordException e) {
        fail("Password exception");
    }

    }
    }