package fr.cefim;

public class Robinet implements Runnable {

    private final Baignoire baignoire;

    private final int debit;

    public Robinet(Baignoire baignoire, int debit) {
        this.baignoire = baignoire;
        this.debit = debit;
    }

    public void remplirBaignoire() {
        while (this.baignoire.getCapacite() > this.baignoire.getVolume()) {
            synchronized (this.baignoire) {
                this.baignoire.setVolume(this.debit);
                System.out.println("> La baignoire se remplie : " + this.baignoire.getVolume());
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("> La baignoire est pleine !!!");
    }

    @Override
    public void run() {
        remplirBaignoire();
    }
}
