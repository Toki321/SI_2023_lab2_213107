import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testFunction_EveryBranch() {
        User user1 = new User("user1", "password", "user1@mail.com");
        User user2 = new User("user2", "password", "user2@mail.com");
        List<User> allUsers = List.of(user1, user2);

        assertThrows(RuntimeException.class, () -> SILab2.function(null, allUsers));

        User userWithNullPassword = new User("user3", null, "user3@mail.com");
        assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullPassword, allUsers));

        User userWithNullEmail = new User("user4", "password", null);
        assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullEmail, allUsers));

        User userWithNullUsername = new User(null, "password", "user5@mail.com");
        assertTrue(SILab2.function(userWithNullUsername, allUsers));

        User userWithInvalidEmail = new User("user6", "password", "user6mailcom");
        assertFalse(SILab2.function(userWithInvalidEmail, allUsers));

        User userWithSameEmailAndUsername = new User("user1", "password", "user1@mail.com");
        assertFalse(SILab2.function(userWithSameEmailAndUsername, allUsers));

        User userWithInvalidPassword = new User("user7", "user7", "user7@mail.com");
        assertFalse(SILab2.function(userWithInvalidPassword, allUsers));

        User userWithPasswordWithoutSpecialChars = new User("user8", "password12", "user8@mail.com");
        assertFalse(SILab2.function(userWithPasswordWithoutSpecialChars, allUsers));
    }

    @Test
    void testFunction_MultipleCondition() {
        User user1 = new User("user1", "password", "user1@mail.com");
        List<User> allUsers = List.of(user1);

        assertThrows(RuntimeException.class, () -> SILab2.function(null, allUsers));

        User userWithNullPassword = new User("user2", null, "user2@mail.com");
        assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullPassword, allUsers));

        User userWithNullEmail = new User("user3", "password", null);
        assertThrows(RuntimeException.class, () -> SILab2.function(userWithNullEmail, allUsers));

        User validUser = new User("user4", "password", "user4@mail.com");
        assertTrue(SILab2.function(validUser, allUsers));
    }
}
