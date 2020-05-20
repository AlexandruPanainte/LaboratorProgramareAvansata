package com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    private List<Client> clients = new ArrayList<Client>();
    private List<Vehicle> vehicles = new ArrayList<Vehicle>();
    Tour[] tours;

    /**
     * Makes a tour for every vehicle.
     * <p>
     * Every vehicle gets clients that are not already allocated
     * and that have strictly ascending visiting tomes.
     * @param p a given problem instance
     */
    public Solution(Problem p) {
        clients = p.getClients();
        //clients.sort();
        vehicles = p.getVehicles();
        tours = new Tour[vehicles.size()];
        Tour t;
        for (int i = 0; i < vehicles.size(); i++) {
            t = new Tour(vehicles.get(i));
            for (int j = 0; j < clients.size(); j++) {
                List<Client> tClients = t.getClients();
                if (tClients.size() == 0) {
                    t.addClients(clients.get(j));

                    clients = deleteClient(clients, j);
                    j--;
                } else if (tClients.get(tClients.size() - 1).getVisitingTime() < clients.get(j).getVisitingTime()) {
                    t.addClients(clients.get(j));

                    clients = deleteClient(clients, j);
                    j--;
                }
            }
            tours[i] = t;
        }
        for (int i = 0; i < tours.length; i++) {
            System.out.println(tours[i]);
        }
    }

    /**
     * Removes the clients that have been allocated.
     * @param clients an array list of clients
     * @param index the position from which to delete the client
     * @return the modified array list of clients
     */
    public List<Client> deleteClient(List<Client> clients, int index) {
        List<Client> copy = new ArrayList<Client>(clients.size() - 1);
        copy.addAll(0, clients.subList(0, index));
        copy.addAll(index, clients.subList(index + 1, clients.size()));
        return copy;
    }

}