public class SheetMetal implements  Part{
    /**
     * LBS_MULTIPLIER is used in the weight calculation that accounts for the weight of steel per pound
     */
    public final double LBS_MULTIPLIER = 0.1;
    /**
     * USD_MULTIPLIER is used to calculated the cost per item
     */
    public final double USD_MULTIPLIER = 0.5;
    private double lengthInches;
    private double thicknessInches;
    private double widthInches;
    public SheetMetal(double lengthInches, double thicknessInches, double widthInches){
        this.lengthInches = lengthInches;
        this.thicknessInches = thicknessInches;
        this.widthInches = widthInches;
    }
    @Override
    public double getCost() {
        return USD_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }

    @Override
    public String getName() {
        return this.lengthInches + "x" + this.widthInches + "x" + this.thicknessInches + " sheet";
    }

    @Override
    public double getWeight() {
        return LBS_MULTIPLIER * thicknessInches * widthInches * lengthInches;
    }
    /**
     * The display method for each object
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.getName() + "\n" +
                "====================\n" +
                "Length: " + this.lengthInches + " inches\n" +
                "Width: " + this.widthInches + " inches\n" +
                "Thickness: " + this.thicknessInches + " inches\n" +
                "Cost: $" + this.getCost() + "\n" +
                "Weight: " + this.getWeight() + " lbs\n");
    }
}
