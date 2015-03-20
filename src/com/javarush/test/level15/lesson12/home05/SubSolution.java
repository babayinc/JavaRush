package com.javarush.test.level15.lesson12.home05;

/**
 * Created by ukr-maksimyak on 16.03.2015.
 */
public class SubSolution extends Solution {

    public SubSolution(int pub1) {
        super(pub1);
    }

    public SubSolution(String pub1) {
        super(pub1);
    }

    public SubSolution(double pub1) {
        super(pub1);
    }

    protected SubSolution(int prot1, int prot2) {
        super(prot1, prot2);
    }

    protected SubSolution(int prot2, String prot1) {
        super(prot2, prot1);
    }

    protected SubSolution(double prot1, double prot2) {
        super(prot1, prot2);
    }

    SubSolution() {

    }

    SubSolution(int def1, double def2, int def3) {
        super(def1, def2, def3);
    }

    SubSolution(double def1, int def2, int def3) {
        super(def1, def2, def3);
    }

    private SubSolution(Object priv1, int priv2){}
    private SubSolution(String priv1, int priv2){}
    private SubSolution(double priv1, int priv2){}

}
