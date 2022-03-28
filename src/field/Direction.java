package field;

import java.util.Random;

/**
 * Irányokat tároló enumeráció
 */
public enum Direction {
    NORTH, SOUTH, WEST, EAST;

    /**
     * Megfordítja az irányt
     *
     * @return visszaadja az ellentétes irányt
     */
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

    /**
     * Véletlenszerű irányt generál
     *
     * @return a véletlenszerű irány
     */
    public Direction randomDirection() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}