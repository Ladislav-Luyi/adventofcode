package org.example;

public class Reindeer {
    String name;
    int speed;
    int maxEnergy;
    int currentEnergy;
    int currentRest;
    int requiredRest;
    int distance = 0;
    int points = 0;

    public Reindeer(String name,
                    int speed,
                    int maxEnergy,
                    int requiredRest) {
        this.name = name;
        this.speed = speed;
        this.maxEnergy = maxEnergy;
        this.requiredRest = requiredRest;
    }

    private boolean hasToRest(){
        if (currentRest == requiredRest){
            currentRest = 0;
            currentEnergy = 0;
            return false;
        }
        return currentEnergy == maxEnergy;
    }

    private void rest(){
        currentRest++;
    }

    public void addPoint(){
        points++;
    }


    public void move(){
        if (!hasToRest()){
            currentEnergy++;
            distance += speed;
        }else{
            rest();
        }
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getCurrentRest() {
        return currentRest;
    }

    public int getRequiredRest() {
        return requiredRest;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
               "name='" + name + '\'' +
               ", speed=" + speed +
               ", maxEnergy=" + maxEnergy +
               ", currentEnergy=" + currentEnergy +
               ", currentRest=" + currentRest +
               ", requiredRest=" + requiredRest +
               ", distance=" + distance +
               '}';
    }
}
