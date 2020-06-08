/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recipe;

/**
 *
 * @author rachelqiuyue
 */
public class Recipe {

    /**
     * @param args the command line arguments
     */
    Recipe(){}
    private Ingredient[] ings = new Ingredient[10];
    private String[] steps = new String[8];
    private int numStep;
    private int numIng;
    public void addStep(String s){
        steps[numStep] = s;
        numStep++;
    }
    public void addIngredient(double m, String s){
        ings[numIng] = new Ingredient(m,s);
        numIng++;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Recipe cookie = new Recipe();
        cookie.addIngredient(2,"Sugar");
        cookie.addIngredient(1,"Butter");
        cookie.addIngredient(2,"vanilla extract");
        cookie.addIngredient(2,"eggs");
        cookie.addIngredient(3,"flour");
        String[] steps = new String[8];
        steps[0] = "1. Preheat oven to 375 degrees F. Line a baking pan with parchment paper and set aside.";
        steps[1] = "2. In a separate bowl mix flour, baking soda, salt, baking powder. Set aside.";
        steps[2] = "3. Cream together butter and sugars until combined.";
        steps[3] = "4.Beat in eggs and vanilla until fluffy.";
        steps[4] = "5.Mix in the dry ingredients until combined.";
        steps[5] = "6. Add 12 oz package of chocolate chips and mix well.";
        steps[6] = "7. Roll 2-3 TBS";
        steps[7] = "8. Bake in preheated oven for approximately 8-10 minutes. Take them out when they are just BARELY starting to turn brown.";
        for (String s: steps){
            cookie.addStep(s);
        }
        
        System.out.println(cookie.toString());
    }
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i <numIng;++i){
            s += ings[i].getItem() + " "+ ings[i].getMeasurement()+"\n";
        }
        s += "\r\n\r\n";
        for (int i = 0; i <numStep;++i){
            s += steps[i]+"\n";
        }
        return s;
    }
}

class Ingredient{
    private double measurement;
    private String item;
    Ingredient(double m, String item){
        this.measurement = m;
        this.item = item;
    }
    final String getItem(){
        return item;
    }
    final double getMeasurement(){
        return measurement;
    }    
}
