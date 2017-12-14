public class Nut implements Part {
    private double diameterInches;
    public final double LBS_MULTIPLIER = 0.01;
    public final double USD_MULTIPLIER = 0.5;

    public Nut(double diameterInches){
        this.diameterInches = diameterInches;
    }
    @Override
    public double getCost() {
        return 0;
    }
    @Override
    public String getName() {
        return null;
    }
    @Override
    public double getWeight() {
        return 0;
    }
    @Override
    public void printBillOfMaterials() {

    }
}
