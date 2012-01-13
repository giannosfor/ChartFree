
package chartfree;

import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import main.*;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

public class Main_1 {


    public static void main(String[] args) {
        HashMap<String,Integer> counts = (HashMap<String, Integer>) new mainp("likes.json").getCounts();

        DefaultPieDataset dataset = new DefaultPieDataset();            
             
        try {
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                dataset.setValue((String)entry.getKey(),(Integer)entry.getValue());
            }

        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createPieChart3D("Facebook Likes", dataset, true, true, false);
       // JFreeChart chart = ChartFactory.createPieChart("Facebook Likes", dataset, true, true, false);
 //        PiePlot plot = (PiePlot) chart.getPlot();       
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setCircular(true);
        //plot.setStartAngle(290);
        //plot.setDirection(Rotation.CLOCKWISE);
        //plot.setForegroundAlpha(0.5f);
       // plot.setExplodePercent("Website", 0.30); //Only for 2D PieChart

        ChartFrame frame = new ChartFrame("Chart Statistics", chart , true);
        frame.pack();
        frame.setVisible(true);
        RefineryUtilities.centerFrameOnScreen(frame);
    }

}
