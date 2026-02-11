/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.motorph.payroll.model;

/**
 *
 * @author newtouch
 */
public class ProbationaryEmployee extends Employee{

    public ProbationaryEmployee(int employeeId, String lastName, String firstName, 
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
