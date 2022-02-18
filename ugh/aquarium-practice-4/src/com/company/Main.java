package com.company;

import com.company.animals.Animal;
import com.company.animals.fishes.BlueTang;
import com.company.animals.fishes.Clownfish;
import com.company.animals.fishes.Herring;
import com.company.animals.fishes.Piranha;
import com.company.animals.reptiles.Lizard;
import com.company.animals.reptiles.Snake;
import com.company.animals.reptiles.Turtle;
import com.company.aquariums.Aquarium;
import com.company.aquariums.RectangularAquarium;
import com.company.aquariums.RoundAquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int total = 0;

        total += step1();
        System.out.println("Total: " + total);

        total += step2();
        System.out.println("Total: " + total);

        total += step3();
        System.out.println("Total: " + total);

    }

    public static int step3(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Which accessories do you want to choose : ");
        for (String type: getTypesOfAccessories()){
            System.out.println(i + ". " + type);
            i++;
        }
        System.out.println(i + ". EXIT?");
        int option1 = scanner.nextInt();
        int j = 1;
        if ((option1 - 1 >=0) && (option1 - 1 < 4)){
            List<Accessory> list = DB.getAccessoriesByType(getTypesOfAccessories().get(option1 - 1));
            return printAccessories(scanner, j, list);
        } else {
            System.out.println("Wrong option selected");
            return 0;
        }
    }

    public static int printAccessories(Scanner scanner, int j, List<Accessory> list) {
        if (list != null) {
            for (Accessory accessory: list){
                System.out.println(j + ". " + accessory.getName() + " : " + accessory.getCost());
                j++;
            }
        }
        int option2 = scanner.nextInt() - 1;
        return list.get(option2).getCost();
    }

    public static List<String> getTypesOfAccessories(){
        List<String> list = new ArrayList<>();
        list.add("filter");
        list.add("feed");
        list.add("toys");
        list.add("sand");
        return list;
    }

    public static int step2(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Choose an aquarium:");
        for (Aquarium aquarium: getAquariums()){
            System.out.println(i + ". " + aquarium.getClass().getSimpleName());
            i++;
        }
        int option1 = scanner.nextInt();
        if (option1 - 1 == 0){
            System.out.println("Choose a volume for aquarium (2,5,10,30,50) : ");
            int option2 = scanner.nextInt();
            if (option2 == 2 || option2 == 5 || option2 == 10 || option2 == 30 || option2 == 50){
                RoundAquarium aquarium = new RoundAquarium();
                aquarium.setVolume(option2);
                return aquarium.getCost();
            } else {
                System.out.println("Wrong option selected");
                return 0;
            }
        } else if (option1 - 1 == 1){
            System.out.println("Choose a volume for aquarium (5,10,20,50,100) : ");
            int option2 = scanner.nextInt();
            if (option2 == 5|| option2 == 10 || option2 == 20 || option2 == 50 || option2 == 100){
                RectangularAquarium aquarium = new RectangularAquarium();
                aquarium.setVolume(option2);
                return aquarium.getCost();
            } else {
                System.out.println("Wrong option selected");
                return 0;
            }
        } else {
            System.out.println("Wrong option selected");
            return 0;
        }
    }

    public static List<Aquarium> getAquariums(){
        List<Aquarium> aquariums = new ArrayList<>();
        aquariums.add(new RoundAquarium());
        aquariums.add(new RectangularAquarium());

        return aquariums;
    }

    public static int step1(){
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        System.out.println("Choose an animal:");
        for (Animal animal: getAnimals()){
            System.out.println(i + ". " + animal.getName() + " : " + animal.getCost());
            i++;
        }
        int option = scanner.nextInt() - 1;

        if (option >=0 && option <=6){
            return getAnimals().get(option).getCost();
        } else {
            System.out.println("Wrong option selected");
            return 0;
        }
    }

    public static List<Animal> getAnimals(){
        List<Animal> animals = new ArrayList<>();
        animals.add(new BlueTang());
        animals.add(new Clownfish());
        animals.add(new Herring());
        animals.add(new Piranha());
        animals.add(new Lizard());
        animals.add(new Snake());
        animals.add(new Turtle());
        return animals;
    }

}
