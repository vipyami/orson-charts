/* ===========
 * OrsonCharts
 * ===========
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.demo;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static com.orsoncharts.demo.AreaChart3DDemo1.createDemoPanel;
import com.orsoncharts.graphics3d.DefaultDrawable3D;
import com.orsoncharts.graphics3d.Object3D;
import com.orsoncharts.graphics3d.Point3D;
import com.orsoncharts.graphics3d.Rotate3D;
import com.orsoncharts.graphics3d.ViewPoint3D;
import com.orsoncharts.graphics3d.World;
import com.orsoncharts.graphics3d.swing.DisplayPanel3D;
import com.orsoncharts.graphics3d.swing.Panel3D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A demo of the viewing point.
 */
public class ViewPointDemo extends JFrame {

    List<Point3D> xlist;
    List<Point3D> ylist;
    List<Point3D> zlist;
    Panel3D panel3D;
    
    /**
     * Creates a new test app.
     *
     * @param title  the frame title.
     */
    public ViewPointDemo(String title) {
        super(title);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        getContentPane().add(createDemoPanel());
    }

    /**
     * Returns a panel containing the content for the demo.  This method is
     * used across all the individual demo applications to allow aggregation 
     * into a single "umbrella" demo (OrsonChartsDemo).
     * 
     * @return A panel containing the content for the demo.
     */
    public JPanel createDemoPanel() {
        JPanel content = new JPanel(new BorderLayout());
        content.setPreferredSize(OrsonChartsDemo.DEFAULT_CONTENT_SIZE);
        World world = new World();
        world.add(Object3D.createCube(1.0, 0, 0, 0, Color.BLUE));
        ViewPoint3D vp = new ViewPoint3D(new Point3D(10, 10, 10), 0);
        xlist = addRing(false, world, new Point3D(0, 25, 0), Point3D.UNIT_X, Color.GREEN);
        //ylist = addRing(true, world, new Point3D(5, 5, 5), vp.getVerticalRotationAxis(), Color.CYAN);
        ylist = addRing(true, world, new Point3D(5, 5, 5), vp.getVerticalRotationAxis(), Color.CYAN);
        //ylist = addRing(true, world, new Point3D(5, -5, 0), vp.getVerticalRotationAxis(), Color.CYAN);
        ylist = addRing(true, world, new Point3D(0, 0, 5), Point3D.UNIT_Y, Color.ORANGE);
        zlist = addRing(true, world, new Point3D(0, 5, 0), Point3D.UNIT_Z, Color.RED);
        DefaultDrawable3D drawable = new DefaultDrawable3D(world);
        this.panel3D = new Panel3D(drawable);
        panel3D.setViewPoint(vp);
        content.add(new DisplayPanel3D(panel3D));
        return content;
    }
    
    private List<Point3D> addRing(boolean b, World world, Point3D pt, Point3D v1, Color color) {
        boolean first = true;
        List<Point3D> result = new ArrayList<Point3D>();
        Rotate3D r = new Rotate3D(Point3D.ORIGIN, v1, 0);
        for (int i = 0; i < 60; i++) {
            r.setAngle(2 * Math.PI / 60 * i);
            Point3D p = r.applyRotation(pt);
            result.add(p);
            if (b) {
                if (first) {
                    world.add(Object3D.createCube(0.20, p.x, p.y, p.z, Color.RED));
                    first = false;
                } else {
                    world.add(Object3D.createCube(0.20, p.x, p.y, p.z, color));                    
                }
            }
        }
        return result;
    }

    public void animate() {
        while (true) {
            for (Point3D p : this.xlist) {
//                this.panel3D.setViewPoint(new ViewPoint3D(p, 0, this.panel3D.getViewPoint().getTheta()));
                this.panel3D.getViewPoint().moveLeftRight(Math.PI / 60);
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ViewPointDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Starting point for the app.
     *
     * @param args  command line arguments (ignored).
     */
    public static void main(String[] args) {
        ViewPointDemo app = new ViewPointDemo(
                "OrsonCharts: ViewPointDemo.java");
        app.pack();
        app.setVisible(true);
//        app.animate();
    }

}