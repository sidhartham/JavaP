package hello;
//package org.jfree.chart.demo;

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

/**
 * An example of a time series chart.  For the most part, default settings are
 * used, except that the renderer is modified to show filled shapes (as well as
 * lines) at each data point.
 */
public class TimeSeriesChartDemo1 extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    static {
        // set a theme using the new shadow generator feature available in
        // 1.0.14 - for backwards compatibility it is not enabled by default
        ChartFactory.setChartTheme(new StandardChartTheme("JFree/Shadow",
                true));
    }

    /**
     * A demonstration application showing how to create a simple time series
     * chart.  This example uses monthly data.
     *
     * @param title  the frame title.
     */
    public TimeSeriesChartDemo1(String title) {
        super(title);
        ChartPanel chartPanel = (ChartPanel) createDemoPanel();
        chartPanel.setPreferredSize(new java.awt.Dimension(500,270));
        setContentPane(chartPanel);
    }

    /**
     * Creates a chart.
     *
     * @param dataset  a dataset.
     *
     * @return A chart.
     */
    /*
    private static JFreeChart createChart(XYDataset dataset) {

    	JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Legal & General Unit Trust Prices",  // title
                "unit",             // x-axis label
                "unit",   // y-axis label
                dataset,            // data
                true,               // create legend?
                true,               // generate tooltips?
                false               // generate URLs?
         );
        chart.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

        return chart;

    }*/
    private static JFreeChart createChart(XYDataset dataset) {

        /* JFreeChart chart = ChartFactory.createTimeSeriesChart(
             "Legal & General Unit Trust Prices",  // title
             "Date",             // x-axis label
             "Price Per Unit",   // y-axis label
             dataset,            // data
             true,               // create legend?
             true,               // generate tooltips?
             false               // generate URLs?
         );*/
     	JFreeChart chart = ChartFactory.createScatterPlot(
                 "Legal & General Unit Trust Prices",  // title
                 "",             // x-axis label
                 "",   // y-axis label
                 dataset            // data
                 );
              //   true,               // create legend?
             //    true,               // generate tooltips?
             //    false               // generate URLs?
         // );
         chart.setBackgroundPaint(Color.red);

         XYPlot plot = (XYPlot) chart.getPlot();
         plot.setBackgroundPaint(Color.lightGray);
         plot.setDomainGridlinePaint(Color.white);
         plot.setRangeGridlinePaint(Color.white);
         //XYItemRenderer renderer = new XYItemRenderer() ;
       //  plot.setRenderer(renderer);//(0, Color.green);
         //plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
         plot.setDomainCrosshairVisible(true);
         plot.setRangeCrosshairVisible(true);
         NumberAxis ax = (NumberAxis)plot.getRangeAxis();
         ax.setAttributedLabel("harekrushna");
         ax.setTickUnit(new NumberTickUnit(5));
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
        // axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

         return chart;

     }

    public static XYDataset createxydataset(String des) {
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
    
    public static double logistic(double y, double r) {
        return 4.0 * r * y * (1.0 - y);
    }
    /*public static XYDataset createxydataset(String des) {
    	DefaultXYDataset xydataset = new DefaultXYDataset();
        int N = 70;
        int size = 0;//100;
        int sizestep = 30;
        
        for (double r = 0.7; r <= 1.0; r += 0.3/N) {
        	size = size + sizestep ;
        }
        double[][] datas = new double[2][size];
        
        //StdDraw.setXscale(0.7, 1.0);
       // StdDraw.setYscale(0.0, 1.0);
       // StdDraw.enableDoubleBuffering();

        int iLstIndex = 0 ;
        for (double r = 0.7; r <= 1.0; r += 0.3/N) {

            // choose random initial value
            double y = Math.random();
            
            // ignore first 1000 iterates
            for (int i = 0; i < 1000; i++)
                y = logistic(y, r);
            
            // plot next 1000 iterates
            for (int i = 0; i < sizestep; i++) {
                y = logistic(y, r);
                System.out.println(r);
                 /*r = i*i;// Double.parseDouble();
    			 y = 2*i;//Double.parseDouble(bean.getDatingScore());
    			
    			datas[0][i+iLstIndex] = r;
    			datas[1][i+iLstIndex] = y;
                
            }
            iLstIndex = iLstIndex+sizestep;
        }
           // StdDraw.show();
           // StdDraw.pause(10);
        System.out.println(datas[0].length);
		xydataset.addSeries(des, datas);
		return xydataset;
        }*/
    /*public static XYDataset createxydataset(String des) {
    	DefaultXYDataset xydataset = new DefaultXYDataset();
        int N = 900;
        int size = 0;//100;
       // int sizestep = 30;
        
        ComplexNumber x = new ComplexNumber();
        double Sreal, Simg;//real and imaginary part of variable
        //double BlowVal = 240;
        
        for (double r = 0; r <= 900; r += 900/N )
        {
        //	size = size + sizestep ;
        }
        size = 901;
        double[][] datas = new double[2][size];
        
        for (int blowval = 0; blowval <= 10; blowval++){
        	
        	ArrayList< double[][]> aa = new ArrayList< double[][]>();
        	// aa.get
        	//StdDraw.setXscale(0.7, 1.0);
        	// StdDraw.setYscale(0.0, 1.0);
        	// StdDraw.enableDoubleBuffering();
           
        	ComplexNumber z = new ComplexNumber() ;
        int iLstIndex = 0 ;
        
        Sreal = Math.random();
        Simg = Math.random();
        
        z.SetXY(Sreal, Simg);
        
        int iIndex = 0 ;
        for (double r = 0; r <=900; r += 900/N) {
        	z.Square();*/
            // choose random initial value
            // ignore first 1000 iterates
            //for (int i = 0; i < 1000; i++)
            //    z.Square(); 
            // plot next 1000 iterates
            // for (int i = 0; i < sizestep; i++) {
            	 
               // y = logistic(y, r);
                //System.out.println(r);
                 /*r = i*i;// Double.parseDouble();
    			 y = 2*i;//Double.parseDouble(bean.getDatingScore());
    			
        	int[] A = new int[100];
        	for(int iIndex1 = 0; iIndex1 <= 100; iIndex1 ++){
        		for(int iIndex2 = 0; iIndex2 <= 100; iIndex2 ++){
        			
        		
        	      
    			datas[0][A[iIndex1]] = z.RealPart();
    			datas[1][A[ iIndex2]] = z.ImgPart();
    			//array i Index . iIndex ++
    			
    			System.out.println(datas[0][iIndex] );
    			iIndex++;
            //}
            //iLstIndex = iLstIndex+sizestep;
                  }
           // StdDraw.show();
           // StdDraw.pause(10);
       
        if(Math.sqrt(z.RealPart()*z.RealPart() + z.ImgPart()*z.ImgPart()) <= blowval){
        	
            System.out.println(datas[0].length);
		    xydataset.addSeries(des, datas);
		    return xydataset;
        }
        else{
        return null;
        }
        	}
        }
        }
        }
    */
   /* 
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

	}*/
    /**
     * Creates a dataset, consisting of two series of monthly data.
     *
     * @return The dataset.
     */
    private static XYDataset createDataset() {
    	if (true)
    	return createxydataset("sidhartha");
        TimeSeries s1 = new TimeSeries("L&G European Index Trust");
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);

        TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
        s2.add(new Month(2, 2001), 129.6);
        s2.add(new Month(3, 2001), 123.2);
        s2.add(new Month(4, 2001), 117.2);
        s2.add(new Month(5, 2001), 124.1);
        s2.add(new Month(6, 2001), 122.6);
        s2.add(new Month(7, 2001), 119.2);
        s2.add(new Month(8, 2001), 116.5);
        s2.add(new Month(9, 2001), 112.7);
        s2.add(new Month(10, 2001), 101.5);
        s2.add(new Month(11, 2001), 106.1);
        s2.add(new Month(12, 2001), 110.3);
        s2.add(new Month(1, 2002), 111.7);
        s2.add(new Month(2, 2002), 111.0);
        s2.add(new Month(3, 2002), 109.6);
        s2.add(new Month(4, 2002), 113.2);
        s2.add(new Month(5, 2002), 111.6);
        s2.add(new Month(6, 2002), 108.8);
        s2.add(new Month(7, 2002), 101.6);

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;

    }

    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        ChartPanel panel = new ChartPanel(chart);
        panel.setFillZoomRectangle(true);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    /*
    public static void main(String[] args) {

        TimeSeriesChartDemo1 demo = new TimeSeriesChartDemo1(
                "Time Series Chart Demo 1");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
    */

}

