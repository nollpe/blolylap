package com.company;

import agents.Chorea;
import agents.Forget;
import agents.Invulnerable;
import agents.Paralyzing;
import character.Inventory;
import character.Player;
import equipment.Gloves;
import equipment.Bag;
import equipment.Labcoat;
import field.City;
import field.Field;
import game.Game;

import java.util.Scanner;

public class Main {
    static Player character1;
    public static void main(String[] args) {

        System.out.println("Valassz gec: \n1-Loot from not paralyzed character");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        switch (s){
            case "1":
                TestInit1();
                Test1();
                break;
            default:
                System.out.println("Ilyen nincs is fogykos");
        }
    }

    static void TestInit1() {
        Game game = Game.getInstance();
        City city = new City();
        game.setCity(city);
        city.generateMap();

        character1 = new Player();
        Player character2 = new Player();
        Player character3 = new Player();
        Field field = new Field();
        field.enter(character1);
        field.enter(character2);
        field.enter(character3);
        character1.setLocation(field);
        character2.setLocation(field);
        character3.setLocation(field);

        Chorea chorea = new Chorea();
        Forget forget = new Forget();
        Invulnerable invulnerable = new Invulnerable();
        Paralyzing paralyzing  = new Paralyzing();

        character1.addCastableAgent(chorea);
        character1.addCastableAgent(forget);
        character1.addCastableAgent(invulnerable);
        character1.addCastableAgent(paralyzing);

        Gloves gloves = new Gloves();
        Bag bag = new Bag();
        Labcoat labcoat = new Labcoat();


        character2.addEquipment(gloves);
        character2.addEquipment(labcoat);
        character2.addEquipment(bag);

    }

    static void Test1(){
        character1.loot();
    }

}
