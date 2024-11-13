package adventofcode;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private Game(){}

    public int getGameId() {
        return gameId;
    }

    // Game 1: 9 red, 5 blue, 6 green; 6 red, 13 blue; 2 blue, 7 green, 5 red
    public static Game createGame(String s){
        Game g = new Game();
        String[] gameAndRest = s.split(": ");
        g.gameId = Integer.parseInt(gameAndRest[0].split(" ")[1]);
        for ( String l : gameAndRest[1].split("; ") ){
            Bag b = new Bag();
//            System.out.println(l);
            String[] numbersAndColors = l.split(", ");
            for (String numberAndColor : numbersAndColors){
            String[] splitNumberAndColor = numberAndColor.split(" ");
            Integer number = Integer.valueOf(splitNumberAndColor[0]);
            String color = splitNumberAndColor[1].replace(",","");
            switch(color) {
                case "red":
                    b.setRed(number);
                    break;
                case "blue":
                    b.setBlue(number);
                    break;
                case "green":
                    b.setGreen(number);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + color);


            }
            }
            g.addBag(b);
        }
        return g;
    }

    private static int playableGames = 0;
    private int gameId;
    private LinkedList<Bag> bags = new LinkedList<>();

    private void addBag(Bag b ){
        bags.add(b);
    }

    public LinkedList<Bag> getBags() {
        return bags;
    }

    public static int getPlayableGames() {
        return playableGames;
    }

    public boolean isPlayable(Bag b){
        if (
            areGamesPlayable(bags, b)
        ){
          playableGames += gameId;
          return true;
        }
        return false;
    }

    boolean areGamesPlayable(List<Bag> values, Bag bag){
        for (Bag iBag : values) {
            boolean b =
                    iBag.getBlue() <= bag.getBlue() &&
                    iBag.getRed() <= bag.getRed() &&
                    iBag.getGreen() <= bag.getGreen();
            if (!b){
                return false;
            }
        }
        return true;
    }

    private Bag toBagOfMaxValues(){
        Bag b = new Bag();
        for (Bag iBag : bags) {
            if (b.getGreen() < iBag.getGreen()){
                b.setGreen(iBag.getGreen());
            }
            if (b.getRed() < iBag.getRed()){
                b.setRed(iBag.getRed());
            }
            if (b.getBlue() < iBag.getBlue()){
                b.setBlue(iBag.getBlue());
            }
        }
        return b;
    }

    private static int sumOfPowerOfMaxColors = 0;

    public static int getSumOfPowerOfMaxColors() {
        return sumOfPowerOfMaxColors;
    }


    void countMaxColors(){
        Bag bagOfMaxValues = toBagOfMaxValues();
        int powerOfMaxValues =  bagOfMaxValues.getBlue() * bagOfMaxValues.getRed() * bagOfMaxValues.getGreen() ;
        System.out.println("max values "  + bagOfMaxValues);
        System.out.println(powerOfMaxValues);
        sumOfPowerOfMaxColors =
                sumOfPowerOfMaxColors + powerOfMaxValues
                       ;
    }

}
