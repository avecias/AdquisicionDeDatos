/*
Termometro digital
 */
package com.app.modelo.dial;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.ThermometerPlot;
import org.jfree.data.general.DefaultValueDataset;

public class Termometro {

    public DefaultValueDataset DATASET;
    private ThermometerPlot plot;
    private JFreeChart chart;
    private ChartPanel panelChart;

    public Termometro() {
    }

    public ChartPanel crearChart() {
        DATASET = new DefaultValueDataset(37.2);
        plot = new ThermometerPlot(DATASET);
        chart = new JFreeChart("Termometro", plot);
        ChartUtilities.applyCurrentTheme(chart);
        panelChart = new ChartPanel(chart);
        return panelChart;
    }

}
