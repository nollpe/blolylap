package field;

import java.util.Random;

public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    public Direction oppositeDirection() {
        switch (this) {
            case EAST -> {
                return WEST;
            }
            case WEST -> {
                return EAST;
            }
            case NORTH -> {
                return SOUTH;
            }
            case SOUTH -> {
                return NORTH;
            }
            default -> {
                return this;
            }
        }
    }

    public Direction randomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
