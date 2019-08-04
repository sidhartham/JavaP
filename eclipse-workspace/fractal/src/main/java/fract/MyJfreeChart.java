package fract;

import java.awt.Color; 
import java.awt.BasicStroke; 
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

public class MyJfreeChart //Name of the class
             extends   //This is called inheritance. 
                       //All the protected and public methods are accessible to the inherited class.
                       //
             ApplicationFrame //Java awt class
{
	
	public MyJfreeChart()
	{
		 super("Creating my graph");//Call to constructor of parent class with string argument.
	        
	}
	
	   /**
     * Creates a panel 
     *
     * @return A panel.
     */
   /* public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        
        return panel;
    }*/
    
    private static JFreeChart createJFChart(XYDataset dataset) {

      
     	JFreeChart chart = ChartFactory.createScatterPlot(
                 "Test",  // title
                 "unit",             // x-axis label
                 "unit",   // y-axis label
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
    public static XYDataset createxydataset(String des) {
    	JuliaSet JS = new JuliaSet();
    	ArrayList< double[][]> datas = new ArrayList< double[][]>();
		DefaultXYDataset xydataset = new DefaultXYDataset();
		JS.CreateJset();
		//JS.Meff();
		datas = JS.ReturnXYDatasets();
		System.out.println(datas.size() + des);
		for(int i =0; i < datas.size(); i ++){
			xydataset.addSeries(String.valueOf(i), datas.get(i));
			
			System.out.println(xydataset.getSeriesCount());
		}
		return xydataset;

	}
    public void SetMarkerRadius()
    {
    	
    }
	public void Setaxis()//origin)
	{
}
	
}
