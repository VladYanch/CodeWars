import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainTest {
    @Test
    void troubleTest() {
        assertArrayEquals(new int[]{1, 3, 5, 6, 7, 4}, Main.trouble(new int[]{1, 3, 5, 6, 7, 4, 3}, 7));
        assertArrayEquals(new int[]{4, 1, 4}, Main.trouble(new int[]{4, 1, 1, 1, 4}, 2));
        assertArrayEquals(new int[]{2, 2}, Main.trouble(new int[]{2, 6, 2}, 8));
        assertArrayEquals(new int[]{2}, Main.trouble(new int[]{2, 2, 2, 2, 2, 2}, 4));
    }
}