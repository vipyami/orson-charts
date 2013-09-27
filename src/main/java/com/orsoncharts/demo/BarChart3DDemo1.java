/* ===========
 * OrsonCharts
 * ===========
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.demo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.orsoncharts.ChartPanel3D;
import com.orsoncharts.Chart3D;
import com.orsoncharts.Chart3DFactory;
import com.orsoncharts.data.category.CategoryDataset3D;
import com.orsoncharts.data.category.DefaultCategoryDataset3D;
import com.orsoncharts.data.DefaultKeyedValues;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;

/**
 * A demo of a 3D bar chart.
 */
public class BarChart3DDemo1 extends JFrame {

    ChartPanel3D chartPanel3D;

    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public BarChart3DDemo1(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(createContent());
    }

    final JPanel createContent() {
        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(new Dimension(600, 400));
        CategoryDataset3D dataset = createDataset();
        Chart3D chart = Chart3DFactory.createBarChart("BarChart3DDemo1", 
                dataset, "Company", "Quarter", "$m Profit");
        this.chartPanel3D = new ChartPanel3D(chart);
        content.add(new DisplayPanel3D(this.chartPanel3D, true));
        return content;
    }
  
    /**
     * Creates a sample dataset.
     * 
     * @return A sample dataset. 
     */
    private CategoryDataset3D createDataset() {    
        DefaultCategoryDataset3D dataset = new DefaultCategoryDataset3D();
        
        DefaultKeyedValues s1 = new DefaultKeyedValues();
        s1.addValue("Q1", 1.0);
        s1.addValue("Q2", -2.0);
        s1.addValue("Q3", 3.0);
        s1.addValue("Q4", 4.0);
        dataset.addSeriesAsRow("Apple (AAPL)", s1);
        
        DefaultKeyedValues s2 = new DefaultKeyedValues();
        s2.addValue("Q1", 4.0);
        s2.addValue("Q2", 3.0);
        s2.addValue("Q3", 2.0);
        s2.addValue("Q4", 1.0);
        dataset.addSeriesAsRow("Google (GOOG)", s2);
        
        return dataset;
    }

    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        BarChart3DDemo1 app = new BarChart3DDemo1(
                "OrsonCharts: BarChart3DDemo1.java");
        app.pack();
        app.setVisible(true);
    }
}

