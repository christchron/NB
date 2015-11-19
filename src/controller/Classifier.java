/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import result.Result;
import java.util.*;
import knn.*;

/**
 *
 * @author elvan_owen
 */
public class Classifier {
    public Result doFullTraining(int k, DataSet dataSet){
        ArrayList<String[]> dataRecords = dataSet.getDS();
           
        Result result = new Result();
        result.setAccuracy(new KNN().accuracy(k, dataRecords, dataRecords));
        
        return result;
    }
    
    public Result doTenCrossFoldValidation(int totalNearest, DataSet dataSet){
        ArrayList<String[]> totalDataRecords = dataSet.getDS();
        
        int totalSize = totalDataRecords.size();
        int step = totalSize / 10;
        double totalAccuracy = 0;
        
        for (int j = 0 ; j < 10 ; j++){
            ArrayList<String[]> dataRecords = new ArrayList<String[]>();
            ArrayList<String[]> testRecords = new ArrayList<String[]>();
            
            for (int i = j * step ; i < (j + 1) * step ; i++){
                dataRecords.add(Arrays.copyOf(totalDataRecords.get(i), step - 1));
            }
            
            for (int k = 0 ; k < 10 ; k++){
                if (k == j) continue;
                
                for (int i = j * step ; i < (j + 1) * step ; i++){
                    testRecords.add(Arrays.copyOf(totalDataRecords.get(i), step - 1));
                }
            }
            
            totalAccuracy += new KNN().accuracy(totalNearest, dataRecords, testRecords);
        }
        
        Result result = new Result();
        result.setAccuracy(totalAccuracy / 10);
        
        return result;
    }
}
