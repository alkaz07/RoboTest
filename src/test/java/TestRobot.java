import org.example.Direction;
import org.example.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestRobot {
    @Test
    public void testStep1(){
        Robot robot = new Robot(Direction.LEFT, -10, 12);
        robot.stepForward();
        Robot expected = new Robot(Direction.LEFT, -11, 12);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, -1, 0",
            "5, 5, 4, 5",
            "-10, 12, -11, 12",
            "1, -12, 0, -12"
    })
    public void testStepLeft(int x0, int y0, int expX, int expY){
        Robot robot = new Robot(Direction.LEFT, x0, y0);
        robot.stepForward();
        Robot expected = new Robot(Direction.LEFT, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 1, 0",
            "5, 5, 6, 5",
            "-10, 12, -9, 12",
            "-1, -12, 0, -12"
    })
    public void testStepRight(int x0, int y0, int expX, int expY){
        Robot robot = new Robot(Direction.RIGHT, x0, y0);
        robot.stepForward();
        Robot expected = new Robot(Direction.RIGHT, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, -1",
            "5, 5, 5, 4",
            "-10, -12, -10, -13",
            "-13, 1, -13, 0"
    })
    public void testStepDown(int x0, int y0, int expX, int expY){
        Robot robot = new Robot(Direction.DOWN, x0, y0);
        robot.stepForward();
        Robot expected = new Robot(Direction.DOWN, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, 0, 1",
            "5, 5, 5, 6",
            "-10, -12, -10, -11",
            "-13, -1, -13, 0"
    })
    public void testStepUp(int x0, int y0, int expX, int expY){
        Robot robot = new Robot(Direction.UP, x0, y0);
        robot.stepForward();
        Robot expected = new Robot(Direction.UP, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "'S', UP, 0, 0, UP, 0, 1",
            "'S', DOWN, 0, 0, DOWN, 0, -1",
            "'S', LEFT, 0, 0, LEFT, -1, 0",
            "'S', RIGHT, 0, 0, RIGHT, 1, 0",
            "'L', UP, 0, 0, LEFT, 0, 0",
            "'L', DOWN, 0, 0, RIGHT, 0, 0",
            "'L', LEFT, 0, 0, DOWN, 0, 0",
            "'L', RIGHT, 0, 0, UP, 0, 0",
            "'R', UP, 0, 0, RIGHT, 0, 0",
            "'R', DOWN, 0, 0, LEFT, 0, 0",
            "'R', LEFT, 0, 0, UP, 0, 0",
            "'R', RIGHT, 0, 0, DOWN, 0, 0",
    })
    public void testOneCmd(char cmd, Direction d0, int x0, int y0, Direction expD, int expX, int expY){
        Robot robot = new Robot(d0, x0, y0);
        robot.doCmd(cmd);
        Robot expected = new Robot(expD, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "S, UP, 0, 0, UP, 0, 1",
            "SSSSS, UP, 0, 0, UP, 0, 5",
            "LLSSSSS, UP, 0, 0, DOWN, 0, -5",
            "LLSSSSSLL, UP, 0, 0, UP, 0, -5",

    })
    public void testProga(String proga,  Direction d0, int x0, int y0, Direction expD, int expX, int expY){
        Robot robot = new Robot(d0, x0, y0);
        robot.runProgram(proga);
        Robot expected = new Robot(expD, expX, expY);
        Assertions.assertEquals(expected, robot);
    }

    @ParameterizedTest
    @CsvSource({
            "SSLSLSLSSRSRS, 5",
            "LSSSS, -1",
            "SSRSSRSSRSSS, 8"
    })
    public void testZadacha(String proga, int resultExpected){
        Robot robot = new Robot(Direction.UP, 0, 0);
        int res = robot.calcStepsUntilOldPos(proga);
        Assertions.assertEquals(resultExpected, res);
        System.out.println("proga = " + proga + " res = "+res+" robot = "+robot);
    }
}
