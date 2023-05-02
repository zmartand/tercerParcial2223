package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ShipGraphTest {
    private Ship ship1;
    private Ship ship2;
    private Ship ship3;
    private ShipGraph shipGraph;

    @BeforeEach
    void setUp() {
        ship1 = new Ship("Ship1", 1, 0, 0);
        ship2 = new Ship("Ship2", 2, 3, 4);
        ship3 = new Ship("Ship3", 3, 6, 8);
        shipGraph = new ShipGraph();
    }

    @Test
    void testAddShip() {
        assertTrue(shipGraph.addShip(ship1));
        assertTrue(shipGraph.hasShip(ship1));
        assertFalse(shipGraph.addShip(ship1)); // intenta agregar el mismo barco nuevamente, debería devolver falso
    }

    @Test
    void testLinkShips() {
        shipGraph.addShip(ship1);
        shipGraph.addShip(ship2);
        assertTrue(shipGraph.linkShips(ship1, ship2));
        assertFalse(shipGraph.linkShips(ship1, ship2)); // intenta agregar el mismo enlace nuevamente, debería devolver falso
        assertTrue(shipGraph.hasLink(ship1, ship2));
    }

    @Test
    void testGetAdjacentShips() throws Exception {
        shipGraph.addShip(ship1);
        shipGraph.addShip(ship2);
        shipGraph.linkShips(ship1, ship2);
        Set<Ship> adjacents = shipGraph.getAdjacentShips(ship1);
        assertTrue(adjacents.contains(ship2));
    }

    @Test
    void testFindShortestRoute() throws Exception {
        shipGraph.addShip(ship1);
        shipGraph.addShip(ship2);
        shipGraph.addShip(ship3);
        shipGraph.linkShips(ship1, ship2);
        shipGraph.linkShips(ship2, ship3);
        var route = shipGraph.findShortestRoute(ship1, ship3);
        assertNotNull(route); // la ruta existe
        assertEquals(3, route.size()); // la ruta pasa por 3 barcos
        assertEquals(ship1, route.get(0)); // el primer barco en la ruta es ship1
        assertEquals(ship3, route.get(2)); // el último barco en la ruta es ship3
    }
}
