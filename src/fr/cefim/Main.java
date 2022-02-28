package fr.cefim;

public class Main {
    public static void main(String[] args) {

        Baignoire baignoire = new Baignoire(500, 250, 70);
        Robinet robinet = new Robinet(baignoire, 50);

        Thread threadBaignoire = new Thread( baignoire );
        Thread threadRobinet = new Thread( robinet );

        threadBaignoire.start();
        threadRobinet.start();
    }
}
