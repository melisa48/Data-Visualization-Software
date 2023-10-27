import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class BarChart extends JPanel {
    private final ArrayList<Integer> data;

    public BarChart(ArrayList<Integer> data) {
        this.data = data;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / data.size();
        int maxDataValue = data.stream().max(Integer::compare).orElse(0);

        for (int i = 0; i < data.size(); i++) {
            int barHeight = (int) ((double) data.get(i) / maxDataValue * height);
            g.fillRect(i * barWidth, height - barHeight, barWidth - 2, barHeight);
        }
    }
}

public class DataVisualizationApp {
    public static void main(String[] args) {
        ArrayList<Integer> sampleData = new ArrayList<>();
        sampleData.add(50);
        sampleData.add(70);
        sampleData.add(30);
        sampleData.add(90);

        JFrame frame = new JFrame("Data Visualization Software");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        BarChart chart = new BarChart(sampleData);
        frame.add(chart);

        frame.setVisible(true);
    }
}

