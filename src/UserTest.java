import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UserTest {

    @Test
    public void checkUserIds() {
        User user1 = new User("Ana");
        User user2 = new User("Luiz");

        assertEquals(user1.id + 1, user2.id);
    }

    @Test
    public void checkUserName(){
        User user1 = new User("Ana");
        assertEquals("Ana", user1.name);
    }
}
