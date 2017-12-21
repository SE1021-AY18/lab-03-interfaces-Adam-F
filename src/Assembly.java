/*
 * SE1021
 * Winter 2017
 * Lab 3
 * Created: 12/14/2016
 * Author: Adam Ferwerda
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 * This class creates a collection of parts. Also handles the display of a given product
 * @author Adam Ferwerda
 * @version 1.0
 */
public class Assembly implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$##.##");
    private DecimalFormat weightFormat = new DecimalFormat("##.### lbs");
    String name;
    ArrayList<Part> subParts = new ArrayList<>();
    public static final double USD_PER_SUB_PART = .25;
    public void addPart(Part part) {
        subParts.add(part);
    }
    public Assembly(String name) {
        this.name = name;
    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        double collectionWeight = 0;
        for (int i=0;i<subParts.size();i++) {
            collectionWeight += subParts.get(i).getWeight();
        }
        return collectionWeight;
    }

    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.name + "\n====================");
        for (int i=0;i<subParts.size();i++) {
            System.out.println("Part: " + subParts.get(i).getName() + "s\n" +
                    "Cost: " + costFormat.format(subParts.get(i).getCost()) + "\n" +
                    "Weight: " + weightFormat.format(subParts.get(i).getWeight()) + "\n");
        }
        System.out.println("TotalCost: " + costFormat.format(this.getCost()) + "\n" +
                "Total weight: " + weightFormat.format(this.getWeight()) + "\n");
        for (int i=0;i<subParts.size();i++) {
            subParts.get(i).printBillOfMaterials();
        }
    }
}
