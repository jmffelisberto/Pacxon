package com.l10gr10.pacxon.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PositionTest {

    @Test
    public void testGetPositionX() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
    }

    @Test
    public void testGetPositionY() {
        Position position = new Position(5, 10);
        assertEquals(10, position.getY());
    }

    @Test
    public void testEquals() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(10, 5);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    public void testHashCode() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(10, 5);

        assertEquals(position1.hashCode(), position2.hashCode());
        assertNotEquals(position1.hashCode(), position3.hashCode());
    }

    @Test
    public void testEqualsPosition() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(10, 5);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    public void testEqualsObject() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(10, 5);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }
}
