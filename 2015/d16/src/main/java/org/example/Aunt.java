package org.example;

import java.util.Objects;

public class Aunt {
    private String name;
    private int children = -1;
    private int cats = -1;
    private  int samoyeds = -1;
    private  int pomeranians = -1;
    private  int akitas = -1;
    private  int vizslas = -1;
    private  int goldfish = -1;
    private  int trees = -1;
    private  int cars = -1;
    private  int perfumes = -1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getCats() {
        return cats;
    }

    public void setCats(int cats) {
        this.cats = cats;
    }

    public int getSamoyeds() {
        return samoyeds;
    }

    public void setSamoyeds(int samoyeds) {
        this.samoyeds = samoyeds;
    }

    public int getPomeranians() {
        return pomeranians;
    }

    public void setPomeranians(int pomeranians) {
        this.pomeranians = pomeranians;
    }

    public int getAkitas() {
        return akitas;
    }

    public void setAkitas(int akitas) {
        this.akitas = akitas;
    }

    public int getVizslas() {
        return vizslas;
    }

    public void setVizslas(int vizslas) {
        this.vizslas = vizslas;
    }

    public int getGoldfish() {
        return goldfish;
    }

    public void setGoldfish(int goldfish) {
        this.goldfish = goldfish;
    }

    public int getTrees() {
        return trees;
    }

    public void setTrees(int trees) {
        this.trees = trees;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public int getPerfumes() {
        return perfumes;
    }

    public void setPerfumes(int perfumes) {
        this.perfumes = perfumes;
    }

    @Override
    public String toString() {
        return "Aunt{" +
               "name='" + name + '\'' +
               ", children=" + children +
               ", cats=" + cats +
               ", samoyeds=" + samoyeds +
               ", pomeranians=" + pomeranians +
               ", akitas=" + akitas +
               ", vizslas=" + vizslas +
               ", goldfish=" + goldfish +
               ", trees=" + trees +
               ", cars=" + cars +
               ", perfumes=" + perfumes +
               '}';
    }

    Integer getNumberOfUnknown(){
        int i = 0;
        if (children == -1){
            i++;
        }
        if (cats == -1){
            i++;
        }
        if (samoyeds == -1){
            i++;
        }
        if (pomeranians == -1){
            i++;
        }
        if (akitas == -1){
            i++;
        }
        if (vizslas == -1){
            i++;
        }
        if (goldfish == -1){
            i++;
        }
        if (trees == -1){
            i++;
        }
        if (cars == -1){
            i++;
        }
        if (perfumes == -1){
            i++;
        }
        return i;
    }

    Integer countRelevant(){
        int i = 0;
        if (cats != -1){
            i++;
        }
        if (trees != -1){
            i++;
        }
        if (pomeranians != -1){
            i++;
        }
        if (goldfish != -1){
            i++;
        }
        return i;
    }



}
