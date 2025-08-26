package service;

import model.Report;

public class ReportGenerator {

    public void generate(Report report) {
        System.out.println("Starting report generation with the following configuration:");
        System.out.println(report); 
        System.out.println("...processing data, applying format, rendering charts...");
        System.out.println(" Report generation complete!");
    }
}