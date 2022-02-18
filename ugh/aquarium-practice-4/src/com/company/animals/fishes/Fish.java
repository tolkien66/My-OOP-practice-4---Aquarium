package com.company.animals.fishes;

import com.company.animals.Animal;

public class Fish implements Animal {

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
