/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Charts;

/**
 *
 * @author Ritik
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import Model.MainAdmin;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;

public class PharmacyCharts extends javax.swing.JPanel {
    private static MainAdmin admin = new MainAdmin();

    public PharmacyCharts() {
        initComponents();
    }

    public static void createBarChartFromDatabase() {
        Map<String, Integer> medicineCounts = fetchDataForBarChart();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : medicineCounts.entrySet()) {
            dataset.addValue(entry.getValue(), "Medicines", entry.getKey());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Sales Trend of Medicines",
                "Medicine",
                "Count",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBaseItemLabelGenerator(new CategoryItemLabelGenerator() {
            @Override
            public String generateRowLabel(org.jfree.data.category.CategoryDataset dataset, int row) {
                return dataset.getRowKey(row).toString();
            }

            @Override
            public String generateColumnLabel(org.jfree.data.category.CategoryDataset dataset, int column) {
                return dataset.getColumnKey(column).toString();
            }

            @Override
            public String generateLabel(org.jfree.data.category.CategoryDataset dataset, int row, int column) {
                int count = dataset.getValue(row, column).intValue();
                int total = medicineCounts.values().stream().mapToInt(Integer::intValue).sum();
                double percentage = (count / (double) total) * 100;
                return String.format("%.2f%%", percentage);
            }
        });
        renderer.setBaseItemLabelsVisible(true);

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame barFrame = new JFrame("Bar Chart");
        barFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        barFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
        barFrame.setSize(800, 600);
        barFrame.setVisible(true);
    }

    private static Map<String, Integer> fetchDataForBarChart() {
        Map<String, Integer> medicineCounts = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(admin.getDbUrl(), admin.getDbUsername(), admin.getDbPassword())) {
            String sql = "SELECT Medicine, COUNT(*) AS Count FROM PharmacyPurchases GROUP BY Medicine";
            try (PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String medicine = resultSet.getString("Medicine");
                    int count = resultSet.getInt("Count");
                    medicineCounts.put(medicine, count);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Fetched data: " + medicineCounts); // Add this line for debugging

        return medicineCounts;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createBarChartFromDatabase());
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
    }
}
