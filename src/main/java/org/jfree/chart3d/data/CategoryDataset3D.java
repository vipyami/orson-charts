/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jfree.chart3d.data;

import java.util.List;

/**
 * An interface for a dataset with multiple series of data in the form of
 * (key, key, value).  This could be used for a 3D bar chart, or a stacked
 * 3D bar chart.
 */
public interface CategoryDataset3D extends Dataset3D {

  public List<Comparable> getSeriesKeys();  
  public List<Comparable> getRowKeys();  
  public List<Comparable> getColumnKeys();
  public Number getValue(Comparable seriesKey, Comparable rowKey, Comparable columnKey);

}
