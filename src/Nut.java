import jdk.internal.org.objectweb.asm.tree.FieldInsnNode;

public class Nut implements Part {
    private double diameterInches;
    public final double LBS_MULTIPLIER = 0.01;
    public final double USD_MULTIPLIER = 0.5;

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
