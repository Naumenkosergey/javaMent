package module3oop;

public class PracticalTask3_3_13 {

/*На игровом поле находится робот. Позиция робота на поле описывается двумя целочисленным координатами: X и Y.
 Ось X смотрит слева направо, ось Y - снизу вверх. (Помните, как рисовали графики функций в школе?)

В начальный момент робот находится в некоторой позиции на поле. Также известно, куда робот смотрит: вверх, вниз,
направо или налево. Ваша задача — привести робота в заданную точку игрового поля.

Робот описывается классом Robot. Вы можете пользоваться следующими его методами (реализация вам неизвестна):*/

    public static void moveRobot(Robot robot, int toX, int toY) {
        setDirectionUp(robot);
        if ((toY - robot.getY()) < 0) {
            robot.turnRight();
            robot.turnRight();
        }
        move(robot, Math.abs(toY - robot.getY()));
        setDirectionUp(robot);
        if ((toX - robot.getX()) < 0) {
            robot.turnLeft();
        } else {
            robot.turnRight();
        }
        move(robot, Math.abs(toX - robot.getX()));
    }



    private static void move(Robot robot, int count) {
        for (int i = 0; i < count; i++) {
            robot.stepForward();
        }
    }

    private static void setDirectionUp(Robot robot) {
        if (robot.getDirection().equals(Direction.UP)) {
            return;
        } else if (robot.getDirection().equals(Direction.DOWN)) {
            robot.turnLeft();
            robot.turnLeft();
        } else if (robot.getDirection().equals(Direction.LEFT)) {
            robot.turnRight();
        } else if (robot.getDirection().equals(Direction.RIGHT)) {
            robot.turnLeft();
        }
    }
}
