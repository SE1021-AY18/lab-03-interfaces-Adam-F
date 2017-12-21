import java.text.DecimalFormat;

public class Duplicate implements Part{
    private Part identicalPart;
    private DecimalFormat costFormat = new DecimalFormat("$##.##");
    private DecimalFormat weightFormat = new DecimalFormat("##.### lbs");
    private int numDuplicates;
    public static final double REDUCTION_FACTOR1 = 0.95;
    public static final double REDUCTION_FACTOR2 = 0.9;
    public static final int USD_THRESHOLD1 = 5;
    public static final int USD_THRESHOLD2 =10;


    public Duplicate(Part part, int numDuplicates) {
        this.identicalPart = part;
        this.numDuplicates = numDuplicates;
    }

    @Override
    public double getCost() {
        double currentCost = identicalPart.getCost() * numDuplicates;
        if(numDuplicates >= USD_THRESHOLD1 && numDuplicates < USD_THRESHOLD2){
            currentCost *= REDUCTION_FACTOR1;
        }
        else if(numDuplicates >= USD_THRESHOLD2){
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
