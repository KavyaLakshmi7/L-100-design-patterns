import model.Report;
import model.ReportFormat;
import service.ReportGenerator;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Builder Pattern: Report Generation System ---\n");
        ReportGenerator generator = new ReportGenerator();
        System.out.println("Building a simple CSV report...");
        Report csvReport = new Report.Builder("quarterly_sales_2024.csv")
                               .withFormat(ReportFormat.CSV)
                               .build();
        generator.generate(csvReport);
        System.out.println("\n" + "=".repeat(40) + "\n");
        System.out.println("Building a formal PDF report for executives...");
        Report pdfReport = new Report.Builder("user_engagement_metrics.sql")
                               .withTitle("Q3 User Engagement Analysis")
                               .withHeader("Confidential - For Internal Use Only")
                               .withFooter("Page 1 of 10")
                               .shouldIncludeCharts(true)
                               .withFormat(ReportFormat.PDF) 
                               .build();
        generator.generate(pdfReport);
        System.out.println("\n" + "=".repeat(40) + "\n");       
        System.out.println("Building an HTML report for a web dashboard...");
        Report htmlReport = new Report.Builder("live_server_stats.json")
                                .withFormat(ReportFormat.HTML)
                                .withTitle("Live Server Status")
                                .shouldIncludeCharts(true)
                                .build();
        generator.generate(htmlReport);
    }
}