package com;

public class Depot {
    private String name;
    private Vehicle vehicles[];

    public Depot() {
        this.name = null;
    }

    public Depot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                '}';
    }

    /**
     * Sets the home depot of each vehicle given as argument.
     *<p>
     * It doesn't allow adding the same vehicle twice.
     * @param vehicles an argument of variable number of vehicles
     */
    public void setVehicles(Vehicle... vehicles) {
        boolean ok = true;
        for (Vehicle v1 : vehicles) {
            ok = true;
            if (this.vehicles != null)
                for (Vehicle v2 : this.vehicles) {
                    if (v2.equals(v1))
                        ok = false;
                }
        }
        if (ok == true)
            this.vehicles = vehicles;
        for (Vehicle v : vehicles) {
            v.setDepot(this);
        }

    }

    /**
     * Returns an array list of all the vehicles from a certain depot.
     * @return an array of vehicles
     */
    public Vehicle[] getVehicles() {
        return vehicles;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return name.equals(depot.name);
    }

}

