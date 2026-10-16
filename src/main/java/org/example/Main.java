package org.example;

//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> в поле.
public class Main {
    static void main() {
        firstSteps();
    }

    private static void firstSteps() {
        Robot robot = new Robot(Direction.UP, 5, 5);
        System.out.println("robot = " + robot);
        robot.turnRight();
        System.out.println("robot = " + robot);
        robot.turnRight();
        System.out.println("robot = " + robot);
        robot.stepForward();
        System.out.println("robot = " + robot);
    }
}
