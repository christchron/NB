/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb;

import java.util.*;

/**
 *
 * @author elvan_owen
 */
public class Controller {
    public void doFullTraining(){
        DataSet dataSet = new DataSet();
        
        String fileName = "";
        int k;
        
        dataSet.parseDataSet(fileName);
        ArrayList<String[]> dataRecords = dataSet.getDS();
        
        ArrayList<String[]> testRecords = new ArrayList<String[]>();
        
        for (int i=0;i<dataRecords.size();i++){
            testRecords.add(Arrays.copyOf(dataRecords.get(i), dataRecords.size()-1));
        }
        
//        KNN.getNearestNeightbour(dataRecords, testRecords, k);
    }
    
    public void doTenCrossFoldValidation(){
        DataSet dataSet = new DataSet();
        
        String fileName = "";
        int totalNearest;
        
        dataSet.parseDataSet(fileName);
        ArrayList<String[]> totalDataRecords = dataSet.getDS();
        
        int totalSize = totalDataRecords.size();
        int step = totalSize / 10;
        
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

//            KNN.getNearestNeightbour(dataRecords, testRecords, k);
        }  
    }
}
