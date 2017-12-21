/*
 * SE1021
 * Winter 2017
 * Lab 3
 * Created: 12/14/2016
 * Author: Adam Ferwerda
 */

/**
 * This class creates a nut object that is used different assemblies of products
 * @author Adam Ferwerda
 * @version 1.0
 */
public class Nut implements Part {
    private double diameterInches;
    /**
     * LBS_MULTIPLIER is used in the weight calculation that accounts for the weight of steel per pound
     */
    public final double LBS_MULTIPLIER = 0.01;
    /**
     * USD_MULTIPLIER is used to calculated the cost per item
     */
    public final double USD_MULTIPLIER = 0.5;

    /**
     * default constructor
     * @param diameterInches of the nut
     */
    public Nut(double diameterInches){
        this.diameterInches = diameterInches;
    }
    @Override
    public double getCost() {
        return USD_MULTIPLIER * Math.pow(diameterInches,2);
    }
    @Override
    public String getName() {
        return diameterInches + " nut";
    }
    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(diameterInches,2);
    }

    /**
     * The display method for each object
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.getName() + "\n" +
                "====================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n");
    }
}
