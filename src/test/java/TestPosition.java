import org.example.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPosition {
    @Test
    public void testEq(){
        Position p1 = new Position(1, 0);
        Position p2 = new Position(1, 0);

        Assertions.assertTrue(p1.equals(p2));
        Assertions.assertTrue(p2.equals(p1));
        Assertions.assertTrue(p1.equals(p1));
    }
    @Test
    public void testNotEq(){
        Position p1 = new Position(1, 0);
        Position p2 = new Position(0, 1);

        Assertions.assertFalse(p1.equals(p2));
        Assertions.assertFalse(p2.equals(p1));
    }
}
