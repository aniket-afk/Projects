
package Charts;

/**
 *
 * @author Ritik
 */
import Model.MainAdmin;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;



public class TestTypeComparisonApp extends JFrame {

    private DefaultPieDataset dataset;

    public TestTypeComparisonApp() {
        initUI();
    }

    private void initUI() {
        setTitle("Different Test Comparison");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        dataset = createDataset();

        JFreeChart chart = ChartFactory.createPieChart(
                "Trend in LabTest", dataset, true, true, false);

        chart.setBackgroundPaint(Color.white);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");
        ((org.jfree.chart.plot.PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));

        add(chartPanel);

        setVisible(true);
    }

    private DefaultPieDataset createDataset() {
        DefaultPieDataset newDataset = new DefaultPieDataset();
        Connection connection = null;

        try {
            MainAdmin admin = new MainAdmin();
            connection = DriverManager.getConnection(admin.getDbUrl(), admin.getDbUsername(), admin.getDbPassword());

            // Execute SQL query to retrieve test type distribution
            String query = "SELECT Type_Of_Test, COUNT(*) AS RequestCount FROM TestRequest GROUP BY Type_Of_Test";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                int totalRequests = 0;

                while (resultSet.next()) {
                    String testType = resultSet.getString("Type_Of_Test");
                    int requestCount = resultSet.getInt("RequestCount");
                    newDataset.setValue(testType, requestCount);
                    totalRequests += requestCount;
                }

                // Calculate percentages and update the dataset
                for (int i = 0; i < newDataset.getItemCount(); i++) {
                    Number value = newDataset.getValue(i);

                    if (value != null) {
                        double percentage = (value.doubleValue() * 100.0) / totalRequests;
                        newDataset.setValue(newDataset.getKey(i), percentage);
                    }
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return newDataset;
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            new TestTypeComparisonApp();
        });
  
    }
}

