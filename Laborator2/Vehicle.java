package com;

import java.util.Objects;

public abstract class Vehicle {
    protected String name;
    protected Depot depot;
    protected String type;
    //protected VehicleType type;

    public Vehicle() {
    }

    public Vehicle(String name) {
        this.name = name;
        this.depot = null;
        this.type = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(name, vehicle.name);
    }

    public void setDepot(Depot d) {
        this.depot = d;
    }

}
