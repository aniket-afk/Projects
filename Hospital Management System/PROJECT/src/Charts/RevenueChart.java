package Charts;


import Model.MainAdmin;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RevenueChart extends javax.swing.JPanel {
    private static MainAdmin admin = new MainAdmin();

    public RevenueChart() {
        initComponents();
    }

    public static void createPieChartFromDatabase() {
        DefaultPieDataset dataset = fetchDataForPieChart();

        JFreeChart chart = ChartFactory.createPieChart(
                "Revenue Comparison",
                dataset,
                true,
                true,
                false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}: {1} ({2})"));
        plot.setSectionPaint("PharmacyPurchases", new Color(79, 129, 189));  // Blue
        plot.setSectionPaint("TestRequest", new Color(155, 187, 89));  // Green

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame pieFrame = new JFrame("Revenue Comparison Chart");
        pieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pieFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        pieFrame.setSize(800, 600);
        pieFrame.setVisible(true);
    }

    private static DefaultPieDataset fetchDataForPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        double pharmacyRevenue = fetchTotalRevenueFromPharmacy();
        double testRevenue = fetchTotalRevenueFromTestRequest();

        dataset.setValue("PharmacyPurchases", pharmacyRevenue);
        dataset.setValue("TestRequest", testRevenue);

        return dataset;
    }

    private static double fetchTotalRevenueFromPharmacy() {
        double totalRevenue = 0;

        try (Connection conn = DriverManager.getConnection(admin.getDbUrl(), admin.getDbUsername(), admin.getDbPassword())) {
            String sql = "SELECT SUM(TotalPrice) AS TotalRevenue FROM PharmacyMedsPrice";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    totalRevenue = resultSet.getDouble("TotalRevenue");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRevenue;
    }

    private static double fetchTotalRevenueFromTestRequest() {
        double totalRevenue = 0;

        try (Connection conn = DriverManager.getConnection(admin.getDbUrl(), admin.getDbUsername(), admin.getDbPassword())) {
            String sql = "SELECT SUM(Cost_of_Test) AS TotalRevenue FROM TestRequest";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {
                    totalRevenue = resultSet.getDouble("TotalRevenue");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalRevenue;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createPieChartFromDatabase());
    }

    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
    }
}
