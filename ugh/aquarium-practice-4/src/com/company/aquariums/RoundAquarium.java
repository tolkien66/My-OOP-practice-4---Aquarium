package com.company.aquariums;

public class RoundAquarium implements Aquarium{
    private int volume;

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getCost() {
        return 2*volume;
    }
}
