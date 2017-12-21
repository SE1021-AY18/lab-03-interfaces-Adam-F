/*
 * SE1021
 * Winter 2017
 * Lab 3
 * Created: 12/14/2016
 * Author: Adam Ferwerda
 */
import java.text.DecimalFormat;
/**
 * This class handles the duplication of parts. As well as building a collection of parts to make an assembly
 * @author Adam Ferwerda
 * @version 1.0
 */
public class Duplicate implements Part{
    private Part identicalPart;
    private DecimalFormat costFormat = new DecimalFormat("$##.##");
    private DecimalFormat weightFormat = new DecimalFormat("##.### lbs");
    private int numDuplicates;
    /**
     * Discount factor 5% off
     */
    public static final double REDUCTION_FACTOR1 = 0.95;
    /**
     * Discount factor 10% off
     */
    public static final double REDUCTION_FACTOR2 = 0.9;
    /**
     * Part cost break point threshold for 5% off
     */
    public static final int USD_THRESHOLD1 = 5;
    /**
     * Part cost break point threshold for 10% off
     */
    public static final int USD_THRESHOLD2 =10;

    /**
     * Default constructor
     * @param part object of the current part (i.e bolt, sheet metal, nut)
     * @param numDuplicates the number of duplicate instances
     */
    public Duplicate(Part part, int numDuplicates) {
        this.identicalPart = part;
        this.numDuplicates = numDuplicates;
    }

    /**
     *  This determines the when the cost reduction is applied and for how much
     *  This company offers price breaks when a customer buys a certain number of products
     * @return the calculated cost with a given discount applied
     */
    @Override
    public double getCost() {
        double currentCost = identicalPart.getCost() * numDuplicates;
        if(numDuplicates >= USD_THRESHOLD1 && numDuplicates < USD_THRESHOLD2){
            currentCost *= REDUCTION_FACTOR1;
        }else if(numDuplicates >= USD_THRESHOLD2){
            currentCost *= REDUCTION_FACTOR2;
        }
        return currentCost;
    }

    @Override
    public String getName() {
        return this.numDuplicates + " " + identicalPart.getName();
    }

    @Override
    public double getWeight() {
        return identicalPart.getWeight() * numDuplicates;
    }
    /**
     * The display method for the collection of objects
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" + this.getName() + "s\n====================\n" +
                "Duplicate part: " + this.getName().substring(3,this.getName().length()) + "\n" +
                "Copies: " + numDuplicates + "\n" +
                "Individual cost: " + costFormat.format(this.identicalPart.getCost()) + "\n" +
                "Individual weight: " + weightFormat.format(this.identicalPart.getWeight()) + "\n\n" +
                "Total cost: " + this.costFormat.format(this.getCost()) + "\n" +
                "Total weight: " + this.weightFormat.format(this.getWeight()) + "\n");
        this.identicalPart.printBillOfMaterials();
    }
}
