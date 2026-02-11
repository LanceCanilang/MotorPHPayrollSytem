package com.motorph.payroll.model;

public class PartTimeEmployee extends Employee { 

    public PartTimeEmployee(int employeeId, String lastName, String firstName, 
                                    String birthday, String address, String phoneNumber, 
                                    String sssNumber, String philhealthNumber, String tinNumber, 
                                    String pagibigNumber, String status, String position, 
                                    String supervisor, double basicSalary, double riceSubsidy, 
                                    double phoneAllowance, double clothingAllowance, 
                                    double grossSemiMonthlyRate, double hourlyRate) 
        {
            super(employeeId, lastName, firstName, birthday, address, phoneNumber, sssNumber, 
                    philhealthNumber, tinNumber, pagibigNumber, status, position, supervisor, 
                    basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, 
                    hourlyRate);
        }
    
    @Override
    public double calculateSalary() {
        return getGrossSemiMonthlyRate();
    }
}
