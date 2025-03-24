package com.kevin.creation.builder.entity;

// 产品
public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;

    public void setSize(String size) {
        this.size = size;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", cheese=" + cheese + ", pepperoni=" + pepperoni + ", mushrooms=" + mushrooms + "]";
    }
}
