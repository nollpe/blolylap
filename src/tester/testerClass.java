package tester;

import agents.*;
import cast.CastImpared;
import character.Inventory;
import character.Player;
import equipment.Bag;
import equipment.Equipment;
import equipment.Gloves;
import equipment.Labcoat;
import field.*;
import game.Game;
import game.Timer;
import getCastOn.GetCastOnInvulnerable;
import getLootTakenFrom.LootTakenStunned;
import graphics.Equipments.BagControl;
import graphics.GraphicsConstroller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class testerClass {

    public testerClass() {

    }

    /**
     * Main függvény
     * Innen vezéreljük a konzolon kersztüli tesztelést
     *
     * @param args bemeneti argumentumok (nem használt)
     */
    public static void main(String[] args) {
        Game C = Game.getInstance();
        C.startGame();
    }
}