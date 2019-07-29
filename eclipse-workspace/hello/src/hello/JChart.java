package hello;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
public class JChart extends ApplicationFrame{
	String m_Title = null;
	public JChart()
	{
		 super("Creating my graph");//Call to constructor of parent class with string argument.
		 /*ChartPanel chartPanel = (ChartPanel) createDemoPanel();
		    chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
		    setContentPane(chartPanel);*/
    }
	 public JPanel createDemoPanel(XYDataset dataset1) {
	        JFreeChart chart = createJFChart(dataset1);
	        ChartPanel panel = new ChartPanel(chart);
	        panel.setPreferredSize(new java.awt.Dimension(500,270));
		    setContentPane(panel);
	        panel.setFillZoomRectangle(true);
	        panel.setMouseWheelEnabled(true);
	        return panel;
	    }
	private JFreeChart createJFChart(XYDataset dataset) {

	      
     	JFreeChart chart = ChartFactory.createScatterPlot(
                 m_Title,  // title
                 "unit",             // x-axis label
                 "unit",   // y-axis label
                 dataset            // data
                 );
             
         chart.setBackgroundPaint(Color.white);

         XYPlot plot = (XYPlot) chart.getPlot();
         plot.setBackgroundPaint(Color.lightGray);
         plot.setDomainGridlinePaint(Color.white);
         plot.setRangeGridlinePaint(Color.white);
         plot.setDomainCrosshairVisible(true);
         plot.setRangeCrosshairVisible(true);
         
         plot.setAxisOffset(new RectangleInsets(0.4, -0.35, 0.45, -0.4));

         XYItemRenderer r = plot.getRenderer();
         r.setSeriesPaint(0, Color.green);
         
         if (r instanceof XYLineAndShapeRenderer) {
             XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
             renderer.setBaseShapesVisible(true);
             renderer.setBaseShapesFilled(true);
             renderer.setDrawSeriesLineAsPath(true);
         }

         return chart;

     }
	
	public void setChartTitle (String title){
		m_Title = title;
	}
	public XYDataset createxydataset(String des) {
		DefaultXYDataset xydataset = new DefaultXYDataset();
		int a = 10;
		int b = 8;
		int size = 100000;//list.size();
		System.out.println(size);
		double[][] datas = new double[2][size];
		for (int i = 0; i < size; i++) {
			//MainClass bean = list.get(i);
			double x = a*Math.cos(i);// Double.parseDouble();
			double y = b*Math.sin(i);//Double.parseDouble(bean.getDatingScore());
			
			datas[0][i] = x;
			datas[1][i] = y;
			//System.out.println(datas[0][i]+"  "+datas[1][i]);
		}
		System.out.println(datas[0].length);
		xydataset.addSeries(des, datas);
		return xydataset;
}
	
}
