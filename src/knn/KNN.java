/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knn;

import java.util.*;

/**
 *
 * @author Gerry
 */
public class KNN {
  
  private ArrayList<ArrayList<knnObject>> arrResult = new ArrayList<>();
          
  public void sortList(ArrayList<knnObject> arrList){
    int min = arrList.get(0).getDifference();
    ArrayList<knnObject> temp;
    Collections.sort(arrList, new Comparator<knnObject>(){
      @Override
      public int compare(knnObject knnObj1, knnObject knnObj2) {
          return knnObj1.getDifference() - knnObj2.getDifference();
      }
    });
  }
  
  public ArrayList<ArrayList<knnObject>> getNearestNeighbor(int k, ArrayList<String[]> listModelSet, ArrayList<String[]> listTestSet){
    int difference;
    for(int i=0; i<listTestSet.size(); i++){
      ArrayList<knnObject> arrList = new ArrayList<>();
      for(int j=0; j<listModelSet.size(); j++){
        difference = 0;
        for(int l=0; l<listTestSet.get(i).length; l++){
          if(!listTestSet.get(i)[l].equals(listModelSet.get(j)[l])){
            difference++;
          }
        }
        knnObject knnObj = new knnObject();
        knnObj.setDifference(difference);
        knnObj.setData(listModelSet.get(j));
        arrList.add(knnObj);
      }
      sortList(arrList);
      
      ArrayList<knnObject> subList = new ArrayList<>();
      for(int m=0; m<k; m++){
        subList.add(arrList.get(m));
      }
      arrResult.add(subList);
    }    
    /*for(int i=0; i<arrResult.size(); i++){
      for(int j=0; j<arrResult.get(i).size(); j++){
        System.out.println(arrResult.get(i).get(j).getData()[0]);
      }
    }*/
    return arrResult;
  }
  
  
  public double accuracy(int k, ArrayList<String[]> listModelSet, ArrayList<String[]> listTestSet){
    HashMap<String, Integer> counter = new HashMap<>();
    getNearestNeighbor(k, listModelSet, listTestSet);
    int countTrue=0;
    String maxLabel="";
    
    for(int i=0; i<arrResult.size(); i++){
      for(int j=0; j<arrResult.get(i).size(); j++){
        String[] knnObjectData = arrResult.get(i).get(j).getData();
        
        Integer value = counter.get(knnObjectData[knnObjectData.length-1]);
        if (value != null) {
          counter.put(knnObjectData[knnObjectData.length-1], value+1);
        } else {
          counter.put(knnObjectData[knnObjectData.length-1], 1);
        }
      }
      
      int max = -1;
      for (String label : counter.keySet()) {
        if(counter.get(label)>max){
          max = counter.get(label);
          maxLabel = label;
        }
      }
      if(listTestSet.get(i)[listTestSet.get(i).length-1].equals(maxLabel)){
        countTrue++;
      }
    } 

    return ((double)countTrue/arrResult.size()*100);
  }
}
