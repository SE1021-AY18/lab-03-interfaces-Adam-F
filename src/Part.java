/*
 * SE1021
 * Winter 2017
 * Lab 3
 * Created: 12/14/2016
 * Author: Adam Ferwerda
 */

/**
 * This interface controls the shared properties across the nuts, bolts, and sheet metal
 * @author  Adam Ferwerda
 * @version 1.0
 */
public interface Part {
    double getCost();
    String getName();
    double getWeight();
    void printBillOfMaterials();
}
