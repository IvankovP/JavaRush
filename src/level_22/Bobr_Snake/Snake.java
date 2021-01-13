package level_22.Bobr_Snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public void setSections(List<SnakeSection> sections) {
        this.sections = sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive) return;
        if (direction == SnakeDirection.UP) move(0, -1);
        else if (direction == SnakeDirection.RIGHT) move(1, 0);
        else if (direction == SnakeDirection.DOWN) move(0, 1);
        else if (direction == SnakeDirection.LEFT) move(-1, 0);
    }

    public void move(int dx, int dy) {
        SnakeSection newHead = new SnakeSection(getX() + dx, getY() + dy);
        checkBorders(newHead);
        checkBody(newHead);

        if (isAlive) {
            sections.add(0, newHead);
            if (newHead.getX() == Room.game.getMouse().getX() && newHead.getY() == Room.game.getMouse().getY()) Room.game.eatMouse();
            else sections.remove(sections.size() - 1);

        }
    }

    public void checkBorders(SnakeSection head) {
        if (head.getX() < 0 || head.getX() >= Room.game.getWidth() ||
                head.getY() < 0 || head.getY() >= Room.game.getHeight()) isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        isAlive = !sections.contains(head);
    }
}
