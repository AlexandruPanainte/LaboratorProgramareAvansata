package com;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private Vehicle vehicle;
    private List<Client> clients = new ArrayList<Client>();
    private int length;

    public Tour(Vehicle v) {
        this.vehicle = v;
    }

    public Tour(int len) {
        this.length = len;
    }

    public void addClients(Client... c) {
        for (Client c1 : c)
            clients.add(c1);
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "vehicle=" + vehicle +
                ", clients=" + clients +
                '}';
    }
}