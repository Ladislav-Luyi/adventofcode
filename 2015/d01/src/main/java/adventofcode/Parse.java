package adventofcode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Parse {
    public static String input =
            """
                    Pizza Margherita;4,90 € / 400 g;8,00 € / 800 g;pomodoro, syr mozzarella, cesnakové okraje (1,7);
                    Pizza Šunková;5,90 € / 500 g;9,90 € / 1000 g;pomodoro, syr mozzarella, šunka, cesnakové okraje (1,7);
                    Pizza Šampiňónová;5,90 € / 450 g;9,90 € / 1000 g;pomodoro, syr mozzarella, šampiňóny, cesnakové okraje (1,7);
                    Pizza Alte;7,45 € / 600 g;11,00 € / 1150 g;pomodoro, syr mozzarella, šunka, saláma, olivy, kukurica, cesnakové okraje (1,7);
                    Pizza Prosciutto;7,45 € / 500 g;12,00 € / 1000 g;pomodoro, syr mozzarella, šunka prosciutto crudo, cesnakové okraje (1,7);
                    Pizza Quasimodo;7,45 € / 630 g;11,00 € / 1200 g;pomodoro, syr mozzarella, cibuľa, feferóny, saláma, klobása, paradajka, syr Niva, cesnakové okraje (1,7);
                    Pizza Sedliacka;7,45 € / 600 g;12,00 € / 1200 g;pomodoro, syr mozzarella, biela cibuľa, chilli, slanina, klobása, cesnak, vajce, cesnakové okraje (1,3,7);
                    Pizza Diabolská;7,45 € / 660 g;11,00 € / 1200 g;pomodoro, syr mozzarella, cibuľa, chilli, feferóny, saláma, klobása, vajce, cesnakové okraje (1,3,7);
                    Pizza Capri;6,90 € / 550 g;11,00 € / 1200 g;pomodoro, syr mozzarella, šunka, šampiňóny, kukurica, cesnakové okraje (1,7);
                    Pizza Salámová;5,95 € / 500 g;9,90 € / 1000 g;pomodoro, syr mozzarella, saláma, cesnakové okraje (1,7);
                    Pizza Quattro;5,95 € / 600 g;9,90 € / 1000 g;pomodoro, syr mozzarella, syr ementál, syr feta, syr niva, smotana, cesnakové okraje (1,7);
                    Pizza Quattro s ananásom;6,95 €;;pomodoro, syr mozzarella, syr ementál, syr feta, syr niva, smotana, ananás, cesnakové okraje (1,7);
                    Pizza Qattro so šunkou ;6,95 € / 700 g;11,00 € / 1100 g;pomodoro, syr mozzarella, syr ementál, syr feta, syr niva, šunka, smotana, cesnakové okraje (1,7);
                    Pizza Calzone (kapsa);6,90 € / 550 g;-;kapsa, pomodoro, šunka, saláma, kukurica, syr (1,7);
                    Slaná pletenka plnená fetou a špenátom;7,95 € / 550 g;-;cesnaková smotanová omáčka, syr feta, čerstvý špenát, cesnakové okraje (1,3,7);
                    Pizzová torta Avokádo;7,95 € / 550 g;-;smotanovo cesnakový základ, avokádo, syrové okraje, citrón, olivový olej, syr mozzarela, okraje potreté cesnakom (3,7);
                    Pizza Hawai s kuracím mäsom;6,95 € / 630 g;12,00 € / 1100 g;pomodoro, syr mozzarella, kuracie mäso, ananás, cesnakové okraje (1,3,7);
                    Pizza Hawai so šunkou;6,45 € / 600 g;11,00 € / 1100 g;pomodoro, syr mozzarella, šunka, ananás, cesnakové okraje (1,7);
                    Pizza Roma;6,95 € / 680 g;12,00 € / 1200 g;pomodoro, syr mozzarella, šunka, vajce, šampiňóny, brokolica, olivy, cesnakové okraje (1,3,7);
                    Pizza Max pikant ;6,95 € / 720 g;11,00 € / 1100 g;pikantné pomodoro, saláma, syr niva, syr mozzarella, paradajka, chilli papričky drvené,  cesnakové okraje (1,3,7);
                    Pizza Tunis;6,95 € / 600 g;12,00 € / 1200 g;pomodoro, syr mozzarella, chilli, kuracie mäso, kukurica, cesnakové okraje (1,7);
                    Pizza Vegetariana ;6,95 € / 700 g;12,00 € / 1200 g;pomodoro, syr mozzarella, kukurica, šampiňóny, paradajka, olivy, brokolica, syr feta, cesnakové okraje (1,7);
                    Pizza Bambino;5,95 € / 550 g;11,00 € / 1100 g;pomodoro, syr mozzarella, šunka, kukurica, oregano (1,7);
                    Pizza Tuniaková;6,95 € / 600 g;12,00 € / 1100 g;pomodoro, syr mozzarella, cibuľa, tuniak, paradajka, cesnakové okraje (1,4,7);
                    Pizza Liptovská;6,95 € / 580 g;12,00 € / 1150 g;smotana, syr mozzarella, slanina, bryndza, cibuľa (1,7);
                    Capresse;7,95 € / 550 g;-;krájané paradajky, syr mozzarella, čerstvý špenát, cesnakové okraje (1,7) ;
                    Vege pizza s avokádom;7,95 € / 550 g  ;-;krájané paradajky, avokádo, cuketa, syr mozzarella, čerstvý špenát, cesnakové okraje (1,7) ;
                    """;

    public static void main(String[] args) {
        int counter = 0;
        Pizza pizza = null;
        List<Pizza> list= new ArrayList<>();
        for ( String line :  input.split(";")){
            if (counter == 0){
                pizza = new Pizza();
            }

//            System.out.println("counter " + counter + " line " + line);

            counter++;

            if (counter == 1){
                pizza.name = line;
            }else
            if (counter == 2){
                String[] split = line.split(" / ");
                if (!line.equals("-")) {
                    pizza.price1 = Double.valueOf(split[0].replace(" €", "").replace(",", "."));
                    if (split.length != 1) {
                        pizza.g1 = split[1];
                    }
                }
            }else
            if (counter == 3){
                if (line.contains("€")) {
                    String[] split = line.split(" / ");
                    pizza.price2 = Double.valueOf(split[0].replace(" €", "").replace(",", "."));
                    pizza.g2 = split[1];
                }
            }else
            if (counter == 4){
                pizza.description = line;
            }

            if (counter == 4){
                counter = 0;
                list.add(pizza);
            }

        }
        list.sort(Comparator.naturalOrder());
        list.forEach(System.out::println);
    }

    static final class Pizza implements Comparable<Pizza>{
        private  String name;
        private  Double price1;
        private  String g1;
        private  Double price2;
        private  String g2;
        private  String description;

        Pizza(String name, Double price1, String g1, Double price2, String g2, String description) {
            this.name = name;
            this.price1 = price1;
            this.g1 = g1;
            this.price2 = price2;
            this.g2 = g2;
            this.description = description;
        }
        Pizza (){}

            @Override
            public String toString() {
                return name + "|" + price1+" € / " + g1 + "|" + price2 + " € / " + g2 + "\n" +
                       description;
            }

        public String name() {
            return name;
        }

        public Double price1() {
            return price1;
        }

        public String g1() {
            return g1;
        }

        public Double price2() {
            return price2;
        }

        public String g2() {
            return g2;
        }

        public String description() {
            return description;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Pizza) obj;
            return Objects.equals(this.name, that.name) &&
                    Objects.equals(this.price1, that.price1) &&
                    Objects.equals(this.g1, that.g1) &&
                    Objects.equals(this.price2, that.price2) &&
                    Objects.equals(this.g2, that.g2) &&
                    Objects.equals(this.description, that.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, price1, g1, price2, g2, description);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice1(Double price1) {
            this.price1 = price1;
        }

        public void setG1(String g1) {
            this.g1 = g1;
        }

        public void setPrice2(Double price2) {
            this.price2 = price2;
        }

        public void setG2(String g2) {
            this.g2 = g2;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public int compareTo(Pizza o) {
            return Double.compare(this.price1, o.price1);
        }
    }
}
