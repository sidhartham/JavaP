package hello;

import java.awt.Color;
import java.util.Scanner;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;


public class MainClass extends ApplicationFrame{
	public MainClass(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	 public static void main(String[] args){
	    	/* MyJfreeChart demo = new MyJfreeChart();
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);*/
		 MainClass thisinstance = new MainClass("this chart");
		 thisinstance.ShowGraph() ;
	        
	 }
	 void ShowGraph(){
	        XYDataset datapoints = createxydataset("");
	        JFreeChart dp = createChart(datapoints);
	        
	        ChartPanel panel = new ChartPanel(dp);
	        panel.setFillZoomRectangle(true);
	        panel.setMouseWheelEnabled(true);
	        panel.setPreferredSize(new java.awt.Dimension(500,270));
	        setContentPane(panel);
	        
	        pack();
	        RefineryUtilities.centerFrameOnScreen(this);
	       setVisible(true);
	        
	        if (true)
	        	return ;
	        JChart demo = new JChart();
	        demo.setChartTitle("Sidhartha Chart");
	        demo.pack();
	        demo.createDemoPanel(datapoints);
	        ChartFactory.createXYLineChart(null, null, null, createxydataset(""));
	        
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);
	        
}
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
	     	JFreeChart chart = ChartFactory.createXYLineChart(//createScatterPlot(
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
			int size = 10;//list.size();
			//System.out.println(size);
			 int n = 32; //Integer.parseInt(args[0]);
		        Complex[] x = new Complex[n];
		        // original data
		        
		       // for (int i = 0; i < n; i++) {
		        //    x[i] = new Complex(i,-2*Math.random() + 1);
		       // }
		        
		        double step = 0.1;
		        for (int i = 0; i < n; i++) {
			          x[i] = new Complex(i*step,Math.sin(i*step));//-2*Math.random() + 1);
		        	
		        	// x[i] = new Complex(i,i);
			        }
		        
			double[][] datas = FFT.show(x);
			
			 Complex[] y = FFT.fft(x);
			 
			 double [][] dataf =FFT.show(y);
			 int skip = 1;
			 int skip2 =1;
			 for (int i = skip; i < n-skip2; i++) {
				 
				 //if ( i < 20 )continue;
				// if ( i > 10  && i < 20)continue;
				 //if ( i <1  ||i > 30)continue;
				 //y[i] = new Complex(0,y[i].im()); 
				// y[i] = new Complex(y[i].re(),0);
				// y[i] = new Complex(0,0);
				// if( i > n/2)
				// y[i] = new Complex((y[i+1].re()- y[i-1].re() ) /2,(y[i+1].im()- y[i-1].im() ) /2);
			 }
			// y[0] = new Complex(y[0].re(),0);
			// y[16] = new Complex(y[16].re(),0);
			// y[0] = new Complex(0,0);

		        // take inverse FFT
		        Complex[] z = FFT.ifft(y);
		       // z[31] = new Complex(34,-2*Math.random() + 1);
		        double[][] datas2 = FFT.show(z);
		       // show(z, "z = ifft(y)");
			//System.out.println(datas[0].length);
			xydataset.addSeries(des, datas);
			xydataset.addSeries("aa", datas2);
			//xydataset.addSeries("aaf", dataf);
			
			return xydataset;

		}
	 public static XYDataset createxydataset2(String des) {
			DefaultXYDataset xydataset = new DefaultXYDataset();
			int size = 10;//list.size();
			//System.out.println(size);
			 int n = 32; //Integer.parseInt(args[0]);
		        Complex[] x = new Complex[n];

		        // original data
		        for (int i = 0; i < n; i++) {
		            //x[i] = new Complex(i, 0);
		            x[i] = new Complex(i,-2*Math.random() + 1);
		        }
			double[][] datas = FFT.show(x);
			/*for (int i = 0; i < size; i++) {
				//MainClass bean = list.get(i);
				double X = i;// Double.parseDouble();
				double y = i;//Double.parseDouble(bean.getDatingScore());
				
				datas[0][i] = x;
				datas[1][i] = y;
				//System.out.println(datas[0][i]+"  "+datas[1][i]);
			}*/
			System.out.println(datas[0].length);
			xydataset.addSeries(des, datas);
			
			return xydataset;

		}
	 public class LogisticMap {

		    


		    // plot the logistic map using standard draw
		   
				
		    }
		}


