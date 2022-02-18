package com.company.animals.reptiles;

import com.company.animals.Animal;

public class Reptile implements Animal {

    protected String name;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int getCost() {
        return 0;
    }
}
