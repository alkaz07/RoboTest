package org.example;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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
            case UP -> pos = pos.shiftUp();
            case RIGHT -> pos = pos.shiftRight();
            case DOWN -> pos = pos.shiftDown();
            case LEFT -> pos = pos.shiftLeft();
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

    public int calcStepsUntilOldPos(String proga){
//        Set<Position> memory = new HashSet<>();
        Set<Position> memory = new LinkedHashSet<>();
        memory.add(pos);
        for (char c : proga.toCharArray()){
            doCmd(c);
            if (c == 'S'){
                if (memory.contains(pos)){
                    System.out.println("-- Memory: ---");
                    memory.forEach(IO::println);
                    return memory.size();   //останавливаемся и рассказываем, сколько всего точек посетили
                }
                else{
                    memory.add(pos);
                }
            }
        }
        System.out.println("-- Memory: ---");
        memory.forEach(IO::println);
        return -1;
    }

}
