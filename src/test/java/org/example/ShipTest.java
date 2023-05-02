package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    private Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship("Destroyer", 3, 5, 5);
    }

    @Test
    void testGetName() {
        assertEquals("Destroyer", ship.getName());
    }

    @Test
    void testSetName() {
        ship.setName("Carrier");
        assertEquals("Carrier", ship.getName());
    }

    @Test
    void testGetSize() {
        assertEquals(3, ship.getSize());
    }

    @Test
    void testSetSize() {
        ship.setSize(5);
        assertEquals(5, ship.getSize());
    }

    @Test
    void testGetX() {
        assertEquals(5, ship.getX());
    }

    @Test
    void testSetX() {
        ship.setX(7);
        assertEquals(7, ship.getX());
    }

    @Test
    void testGetY() {
        assertEquals(5, ship.getY());
    }

    @Test
    void testSetY() {
        ship.setY(7);
        assertEquals(7, ship.getY());
    }
}
