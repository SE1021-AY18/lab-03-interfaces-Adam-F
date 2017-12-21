/*
 * SE1021
 * Winter 2017
 * Lab 3
 * Created: 12/14/2016
 * Author: Adam Ferwerda
 */

/**
 * This class creates a bolt object that is used different assemblies of products
 * @author Adam Ferwerda
 * @version 1.0
 */
public class Bolt implements  Part {
    /**
     * LBS_MULTIPLIER is used in the weight calculation that accounts for the weight of steel per pound
     */
    public static final double LBS_MULTIPLIER = 0.05;
    /**
     * USD_MULTIPLIER is used to calculated the cost per item
     */
    public static final double USD_MULTIPLIER = 1;
    private double diameterInches;
    private double lengthInches;

    /**
     * default constructor that sets up the basic properties of a bolt
     * @param diameterInches of the bolt
     * @param lengthInches of the bolt
     */
    public Bolt(double diameterInches, double lengthInches){
        this.diameterInches = diameterInches;
        this.lengthInches = lengthInches;
    }
    @Override
    public double getCost() {
        return USD_MULTIPLIER * diameterInches * lengthInches;
    }

    @Override
    public String getName() {
        return diameterInches + "x" + lengthInches + " bolt";
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * Math.pow(diameterInches,2) * lengthInches;
    }
    /**
     * The display method for each object
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("==========================\n" +
                getName() + "\n==========================\n" +
                "Diameter: " + diameterInches + " inches\n" +
                "Length: " + lengthInches + " inches\n" +
                "Cost: $" + getCost() + "\n" +
                "Weight: " + getWeight() + " lbs\n"
                            );

    }
}
