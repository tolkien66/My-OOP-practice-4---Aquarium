package com.company.aquariums;

public class RectangularAquarium implements Aquarium{
    private int volume;

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getCost() {
        return volume;
    }
}
