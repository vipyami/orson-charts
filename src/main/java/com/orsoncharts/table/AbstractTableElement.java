/* ===========
 * OrsonCharts
 * ===========
 * 
 * (C)opyright 2013 by Object Refinery Limited.
 * 
 */

package com.orsoncharts.table;

import com.orsoncharts.ArgChecks;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import java.util.Map;

/**
 *
 * @author dgilbert
 */
public abstract class AbstractTableElement {
    
    /** The foreground paint. */
    private Paint foregroundPaint;
    
    /** The background paint (this can be <code>null</code>). */
    private Paint backgroundPaint;
    
    /** The insets. */
    private Insets insets;
    
    public AbstractTableElement() {
        this.foregroundPaint = Color.BLACK;
        this.backgroundPaint = null;
        this.insets = new Insets(2, 2, 2, 2);
    }

    /**
     * Returns the foreground paint.
     * 
     * @return The foreground paint (never <code>null</code>). 
     */
    public Paint getForegroundPaint() {
        return this.foregroundPaint;
    }

    /**
     * Sets the foreground paint.
     * 
     * @param paint  the paint (<code>null</code> not permitted). 
     */
    public void setForegroundPaint(Paint paint) {
        ArgChecks.nullNotPermitted(paint, "paint");
        this.foregroundPaint = paint;
    }
    
    /**
     * Returns the background paint.
     * 
     * @return The background paint (never <code>null</code>). 
     */
    public Paint getBackgroundPaint() {
        return this.backgroundPaint;
    }

    /**
     * Sets the background paint.
     * 
     * @param paint  the paint (<code>null</code> not permitted). 
     */
    public void setBackgroundPaint(Paint paint) {
        ArgChecks.nullNotPermitted(paint, "paint");
        this.backgroundPaint = paint;
    }
    
    public Insets getInsets() {
        return this.insets;
    }
    
    public void setInsets(Insets insets) {
        this.insets = insets;
    }
    
    public Dimension2D preferredSize(Graphics2D g2, Rectangle2D bounds) {
        return preferredSize(g2, bounds, null);
    }

    public abstract Dimension2D preferredSize(Graphics2D g2, Rectangle2D bounds, 
            Map<String, Object> constraints);
   
}
