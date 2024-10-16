package com.modernJava.optionalClassInsteadOfNull;

public class OptionalClassInsteadOfNull {
    public static void main(String[] args) {
        OptionalClassInsteadOfNull instead = new OptionalClassInsteadOfNull();
//        String name1 = instead.getCarInsuranceName1(new Person());
//        System.out.println("name1: " + name1);

//        String name2 = instead.getCarInsuranceName2(new Person());
//        System.out.println("name2: " + name2);

        String name3 = instead.getCarInsuranceName3(new Person());
        System.out.println("name3: " + name3);
    }

    public String getCarInsuranceName1(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public String getCarInsuranceName2(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null)
                    return insurance.getName();
            }
        }
        return "Unknown";
    }

    public String getCarInsuranceName3(Person person) {
        if (person == null) {
            return "Unknown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }
}
