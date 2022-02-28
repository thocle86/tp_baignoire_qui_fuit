package fr.cefim;

public class Baignoire implements Runnable {

    private final int capacite;
    private int volume;
    private int fuite;

    public Baignoire(int capacite, int volume, int fuite) {
        this.capacite = capacite;
        this.volume = volume;
        this.fuite = fuite;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getVolume() {
        return volume;
    }

    public int setVolume(int volume) {
        if (this.volume + volume < 0) {
            return 0;
        }
        return this.volume = Math.min(this.volume + volume, capacite);
    }

    public void fuiteBaignoire() {
        while (this.volume > 0) {
            setVolume(-this.fuite);
            System.out.println("> La baignoire se vide : " + this.volume);
        }
        System.out.println("> La baignoire est vide (" + this.volume + ")");
    }

    @Override
    public void run() {
        this.fuiteBaignoire();
    }
}
