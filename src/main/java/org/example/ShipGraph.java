package org.example;

import java.util.*;

public class ShipGraph {
    private Map<Ship, Set<Ship>> shipAdjacencyList = new HashMap<>();

    public boolean addShip(Ship ship) {
        if (!shipAdjacencyList.containsKey(ship)) {
            shipAdjacencyList.put(ship, new HashSet<>());
            return true;
        }
        return false;
    }

    public boolean linkShips(Ship ship1, Ship ship2) {
        addShip(ship1);
        addShip(ship2);
        Set<Ship> adjacents1 = shipAdjacencyList.get(ship1);
        if (adjacents1.contains(ship2)) {
            return false;
        }
        double distance = calculateDistance(ship1, ship2);
        adjacents1.add(ship2);
        shipAdjacencyList.get(ship2).add(ship1);
        return true;
    }

    public Set<Ship> getAdjacentShips(Ship ship) throws Exception {
        if (!shipAdjacencyList.containsKey(ship)) {
            throw new Exception("Ship does not exist");
        }
        return shipAdjacencyList.get(ship);
    }

    public boolean hasShip(Ship ship) {
        return shipAdjacencyList.containsKey(ship);
    }

    public void exploreNetwork(Ship start) {
        Set<Ship> visited = new HashSet<>();
        Stack<Ship> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Ship current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current.getName() + " ");
                for (Ship neighbor : shipAdjacencyList.get(current)) {
                    stack.push(neighbor);
                }
            }
        }
    }

    public List<Ship> findShortestRoute(Ship start, Ship end) throws Exception {
        Map<Ship, Ship> pathTrace = new HashMap<>();
        Map<Ship, Double> shipDistances = new HashMap<>();
        PriorityQueue<Ship> shipQueue = new PriorityQueue<>(Comparator.comparingDouble(shipDistances::get));
        shipQueue.add(start);
        shipDistances.put(start, 0.0);

        while (!shipQueue.isEmpty()) {
            Ship current = shipQueue.poll();
            if (current.equals(end)) {
                break;
            }
            double currentDistance = shipDistances.get(current);
            for (Ship neighbor : getAdjacentShips(current)) {
                double newDistance = currentDistance + calculateDistance(current, neighbor);
                if (!shipDistances.containsKey(neighbor) || newDistance < shipDistances.get(neighbor)) {
                    shipDistances.put(neighbor, newDistance);
                    shipQueue.add(neighbor);
                    pathTrace.put(neighbor, current);
                }
            }
        }

        if (!pathTrace.containsKey(end)) {
            return null;
        }

        List<Ship> path = new ArrayList<>();
        Ship current = end;
        while (current != null) {
            path.add(0, current);
            current = pathTrace.get(current);
        }
        return path;
    }

    private double calculateDistance(Ship ship1, Ship ship2) {
        return Math.sqrt(Math.pow(ship1.getX() - ship2.getX(), 2) + Math.pow(ship1.getY() - ship2.getY(), 2));
    }
}

