/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.ArrayList;

/**
 *
 * @author Gerry
 */
public class knnObject {
  private int difference;
  private int index;
  private String[] listData;
  
  public knnObject(){
    difference = 0;
    index = 0;
  }
  
  public int getDifference(){
    return difference;
  }
  
  public int getIndex(){
    return index;
  }
  
  public String[] getData(){
    return listData;
  }
  
  public void setDifference(int _difference){
    difference = _difference;
  }
  
  public void setIndex(int _index){
    index = _index;
  }
  
  public void setData(String[] _listData){
    listData = _listData;
  }
}
