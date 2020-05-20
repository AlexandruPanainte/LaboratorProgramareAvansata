package com;

import java.util.ArrayList;
import java.util.List;

public class Problem {
    private List<Depot> depots = new ArrayList<Depot>();
    private List<Client> clients = new ArrayList<Client>();

    /**
     * Adds depots to the problem.
     * <p>
     * It doesn't allow adding the same depot twice.
     * @param d an argument of variable number of depots
     */
    public void addDepots(Depot... d) {
        for (Depot d1 : d) {
            boolean ok = true;
            for (Depot d2 : depots) {
                if (d2.equals(d1))
                    ok = false;
            }
            if (ok == true)
                depots.add(d1);
        }
    }

    /**
     * Adds clients to the problem.
     * <p>
     * It doesn't allow adding the same client twice.
     * @param c an argument of variable number of clients
     */
    public void addClients(Client... c) {
        for (Client c1 : c) {
            boolean ok = true;
            for (Client c2 : clients) {
                if (c2.equals(c1))
                    ok = false;
            }
            if (ok == true)
                clients.add(c1);
        }
    }

    /**
     * Returns an array list of all the vehicles from all depots.
     * <p>
     * This method gets the vehicles of every depot and adds them to
     * an array list that will be returned.
     * @return the array list of vehicles
     */
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (Depot d : depots) {
            for (Vehicle v : d.getVehicles())
                vehicles.add(v);
        }
        return vehicles;
    }

    /**
     * Returns an array list of all clients.
     * @return the array list of clients
     */
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                "\n clients=" + clients +
                '}';
    }
}
