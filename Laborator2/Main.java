package com;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();

        Depot d1 = new Depot("D1");
        Depot d2 = new Depot("D2");
        Depot d3 = new Depot("D2");

        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("V1");
        vehicles[1] = new Truck("V2");
        vehicles[2] = new Drone("V3");

        Client c1 = new Client("C1", 1);
        Client c2 = new Client("C2", 1);
        Client c3 = new Client("C3", 2);
        Client c4 = new Client("C4", 2);
        Client c5 = new Client("C5", 3);

        d1.setVehicles(vehicles[0], vehicles[1]);
        d2.setVehicles(vehicles[2]);

        pb.addDepots(d1, d2, d3);
        pb.addClients(c1, c2, c3, c4, c5);


        System.out.println(pb);
        System.out.println();

        System.out.println("Depot " + d1.getName() + " with vehicles:");
        Vehicle[] vehicles2 = d1.getVehicles();
        for (Vehicle v : vehicles2)
            System.out.println(v);
        System.out.println();

        System.out.println("Depot " + d2.getName() + " with vehicles:");
        vehicles2 = d2.getVehicles();
        for (Vehicle v : vehicles2)
            System.out.println(v);
        System.out.println();

        Tour t1 = new Tour(vehicles[0]);
        Tour t2 = new Tour(vehicles[1]);
        Tour t3 = new Tour(vehicles[2]);
        t1.addClients(c1, c3, c5);
        t2.addClients(c2);
        t3.addClients(c4);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        
        System.out.println();

        Solution s = new Solution(pb);



    }
}
