package org.example;

import java.util.Objects;

public class Robot {
    Direction d;
    Position pos;

    public Robot(Direction d, Position pos) {
        this.d = d;
        this.pos = pos;
    }

    public Robot(Direction direction, int x, int y) {
        this.d=direction;
        pos = new Position(x, y);
    }

    @Override
    public String toString() {
        return "Robot{" +
                "d=" + d +
                ", pos=" + pos +
                '}';
    }

    public void turnRight(){
        switch (d){
            case UP -> d = Direction.RIGHT;
            case RIGHT -> d=Direction.DOWN;
            case DOWN -> d=Direction.LEFT;
            case LEFT -> d=Direction.UP;
        }
    }

    public void turnLeft(){
        switch (d){
            case UP -> d = Direction.LEFT;
            case RIGHT -> d=Direction.UP;
            case DOWN -> d=Direction.RIGHT;
            case LEFT -> d=Direction.DOWN;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Robot robot)) return false;
        return d == robot.d && Objects.equals(pos, robot.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(d, pos);
    }

    public void stepForward(){
        switch (d){
            case UP -> pos.y++;
            case RIGHT -> pos.x++;
            case DOWN -> pos.y--;
            case LEFT -> pos.x--;
        }
    }

    public void doCmd(char cmd){
        switch (cmd){
            case 'S' -> stepForward();
            case 'R' -> turnRight();
            case 'L' -> turnLeft();
        }
    }

    public void runProgram(String proga){
        for (char c : proga.toCharArray()){
            doCmd(c);
        }
    }
}
