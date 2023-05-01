package org.example;

public class Principal {
    public static void main(String[] args) {
        //Crear barcos
        Ship ship1 = new Ship("Ship1", 1, 1, 1);
        Ship ship2 = new Ship("Ship2", 2, 2, 2);
        Ship ship3 = new Ship("Ship3", 3, 3, 3);
        Ship ship4 = new Ship("Ship4", 4, 4, 4);
        Ship ship5 = new Ship("Ship5", 5, 5, 5);
        Ship ship6 = new Ship("Ship6", 6, 6, 6);
        // Crear grafos
        ShipGraph shipGraph = new ShipGraph();
        shipGraph.addShip(ship1);
        shipGraph.addShip(ship2);
        shipGraph.addShip(ship3);
        shipGraph.addShip(ship4);
        shipGraph.addShip(ship5);
        shipGraph.addShip(ship6);
        // Agregar aristas entre los vértices
        shipGraph.linkShips(ship1, ship2);
        shipGraph.linkShips(ship1, ship3);
        shipGraph.linkShips(ship2, ship4);
        shipGraph.linkShips(ship2, ship5);
        shipGraph.linkShips(ship3, ship5);
        shipGraph.linkShips(ship4, ship6);
        shipGraph.linkShips(ship5, ship6);
        // Imprimir grafo
        System.out.println("Grafo:");
        System.out.println(shipGraph);
        // Imprimir adyacencias de un vértice
        System.out.println("Adyacencias de Ship1:");
        try {
            System.out.println(shipGraph.getAdjacentShips(ship1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Imprimir si un vértice existe
        System.out.println("¿Existe Ship1?");
        System.out.println(shipGraph.hasShip(ship1));
        // Imprimir si una arista existe
        System.out.println("¿Existe arista entre Ship1 y Ship2?");
        try {
            System.out.println(shipGraph.hasLink(ship1, ship2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Imprimir si un vértice existe
        System.out.println("¿Existe Ship7?");
        System.out.println(shipGraph.hasShip(new Ship("Ship7", 7, 7, 7)));

        // Imprimir ruta más corta entre dos vértices
        System.out.println("Ruta más corta entre Ship1 y Ship7:");
        try {
            System.out.println(shipGraph.findShortestRoute(ship1, new Ship("Ship7", 7, 7, 7)));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
