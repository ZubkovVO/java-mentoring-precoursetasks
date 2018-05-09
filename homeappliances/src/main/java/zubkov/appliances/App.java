package zubkov.appliances;

import zubkov.appliances.exceptions.NoApplianceFoundException;
import zubkov.appliances.exceptions.OverPowerException;
import zubkov.appliances.model.Fridge;
import zubkov.appliances.model.HomeAppliance;
import zubkov.appliances.model.Kettle;
import zubkov.appliances.model.Oven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Apartment apartment = new Apartment();
        HomeAppliance oven = new Oven(1000, "medium","Bosh6572");
        HomeAppliance oven1 = new Oven(5000, "large","BoshXL");
        HomeAppliance fridge = new Fridge(600, "large","AristonCool231");
        HomeAppliance kettle = new Kettle(400, "small","Bosh1001");
        apartment.addAppl(oven);
        apartment.addAppl(oven1);
        apartment.addAppl(fridge);
        apartment.addAppl(kettle);
        apartment.applList();
        System.out.println();
        apartment.sortAppl();
        apartment.applList();
        System.out.println();
        System.out.println("Кол-во Watt до включения: " + apartment.wattCount());
        try {
            apartment.plugInAppliance(oven);
        } catch (OverPowerException e) {
            System.out.println(e.getMessage());
        }
        try {
            apartment.plugInAppliance(oven);
        } catch (OverPowerException e) {
            System.out.println(e.getMessage());
        }
        try {
            apartment.plugInAppliance(oven1);
        } catch (OverPowerException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Кол-во Watt после включения: " + apartment.wattCount());
        System.out.println();
        try {
            apartment.searchBySize("large");
        } catch (NoApplianceFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            apartment.searchBySize("Extra Large");
        } catch (NoApplianceFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            kettle.setWatt(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        HomeAppliance fridge2 = null;
        try {
            fridge2.getWatt();

        } catch (NullPointerException e){
            System.out.println(e.getMessage());

        }

        try {
            kettle.goSleep();

        } catch (UnsupportedOperationException e){
            System.out.println(e.getMessage());

        }
        try {
            apartment.clearApartment();
            apartment.clearApartment();
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        HomeAppliance kettle3 = new Kettle(9000, "small","MegaKettle");
        String stringPower = "123abc";
        try {
            kettle3.setWatt(Integer.valueOf(stringPower));
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }
}
