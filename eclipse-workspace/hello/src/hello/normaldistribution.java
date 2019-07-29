package hello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;


public class normaldistribution extends JFrame{
    double m_mean = 25;
    int m_points = 10000;
    double m_std = 1000005;
    int m_alpha = 1;
    int m_beta = 1;
    static String m_title;
    public normaldistribution() {
        super("XY Line Chart Example with JFreechart");
 
        JPanel chartPanel = createChartPanel();
     //   add(chartPanel, BorderLayout.CENTER);
 
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
	public XYDataset normald(int mean , int std){
		 XYSeriesCollection dataset = new XYSeriesCollection();
		 
		    XYSeries series1 = new XYSeries("Object 1");
    	double min = mean - 10 * std;
    	double max = mean + 10 * std;
    	for(int i = 0; i < 1000000000 ; i++)
    	{
    	    double x = Math.random() * (max - min) + min;
    	    double y = Math.pow(Math.E, -1 * Math.pow((x - mean) / std, 2) / 2) / (std * Math.sqrt(2 * Math.PI));
    	    series1.add(x, y);
    	    System.out.println(i + " - " + x + " , " + y);
    	}
    	
    	dataset.addSeries(series1);
    	
    	return dataset;
    }
	public XYDataset exponentiald(double mean , double std){
		 XYSeriesCollection dataset = new XYSeriesCollection();
		 
		    XYSeries series1 = new XYSeries("Object 1");
    double[] pop = new double[2 * m_points];
   	double min = 0;
   	double max = 1 /( std * Math.sqrt(2 * Math.PI));
   	DescriptiveStatistics stats = new DescriptiveStatistics();
   	for(int i = 1; i <= m_points ; i++)
   	{
   	    //double y = Math.random() * (max - min) + min;
   		double y = i * max / (m_points) ;
   	    double x;
   	    if(Math.random() - 0.5 > 0)
   	        x = mean + (std * Math.sqrt(2 * Math.log(1 / (std * y * Math.sqrt(2 * Math.PI)))));
   	    else
   	        x = mean - (std * Math.sqrt(2 * Math.log(1 / (std * y * Math.sqrt(2 * Math.PI)))));
        series1.add(x, y);   	   
        stats.addValue(x);
   	    pop[i] = x;
   	   /* double xpos = mean + (std * Math.sqrt(2 * Math.log(1 / (std * y * Math.sqrt(2 * Math.PI)))));
   	    double xneg = mean - (std * Math.sqrt(2 * Math.log(1 / (std * y * Math.sqrt(2 * Math.PI)))));
   	    series1.add(xpos, y);
   	    series1.add(xneg, y);
        stats.addValue(xpos);
        stats.addValue(xneg);
	    pop[i] = xpos;
	    pop[i] = xneg;*/
   	}
   	StandardDeviation sd = new StandardDeviation(false);
   	double sd1 = sd.evaluate(pop);
    m_title = stats.toString();
    System.out.println(sd1);
   	dataset.addSeries(series1);
   	
   	return dataset;
   }
	private JPanel createChartPanel() {
	    XYDataset dataset = exponentiald(m_mean , m_std);
	 
	    //JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,  xAxisLabel, yAxisLabel, dataset);
	 
	   // return new ChartPanel(chart);
	    CreateChart( dataset);
	    return null;
	}
	
	private static JFreeChart createJFChart(XYDataset dataset) {

	      
     	JFreeChart chart = ChartFactory.createScatterPlot(
                 m_title,  // title
                 "X",             // x-axis label
                 "f(x)",   // y-axis label
                 dataset            // data
                 );
              //   true,               // create legend?
             //    true,               // generate tooltips?
             //    false               // generate URLs?
         // );
     	
         chart.setBackgroundPaint(Color.white);

         XYPlot plot = (XYPlot) chart.getPlot();
         plot.setBackgroundPaint(Color.lightGray);
         plot.setDomainGridlinePaint(Color.white);
         plot.setRangeGridlinePaint(Color.white);
         //XYItemRenderer renderer = new XYItemRenderer() ;
       //  plot.setRenderer(renderer);//(0, Color.green);
         //plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
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

        // DateAxis axis = (DateAxis) plot.getDomainAxis();
        // axis.
        // axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

         return chart;

     }

    //Given an dataset, creaate a graph and add it to window
    public void CreateChart( XYDataset xyd)
    {
    	//this.
    	JFreeChart chart = createJFChart(xyd);
    	 ChartPanel panel = new ChartPanel(chart);
         panel.setFillZoomRectangle(true);
         panel.setMouseWheelEnabled(true);
         
    	//ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        panel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(panel); //Call to the parent class method for setting the panel into window display
    }
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new normaldistribution().setVisible(true);
            }
        });
    }
}
