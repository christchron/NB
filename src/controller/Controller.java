/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import knn.KNN;
import nb.DSParse;
import nb.NBAlgo;
import nb.dataTest;
import result.*;

/**
 *
 * @author elvan_owen
 */
public class Controller {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Untuk KNN
        
//        int k = 1;
//        String fileName = "src/weather.nominal.arff";
//        
//        DataSet dataSet = new DataSet();
//        dataSet.parseDataSet(fileName);
//        
//        dataSet.inspect();
//        
//        System.out.println("\n\n\n\n-- KNN\n\n");
//        
//        Classifier classifier = new Classifier();
//        Result result = classifier.doFullTraining(k, dataSet);
//        
//        System.out.println("---- Full Training");
//        System.out.print("Accuracy : ");
//        System.out.printf("%.2f ", result.getAccuracy());
//        System.out.print("%");
        
//        result = classifier.doTenCrossFoldValidation(k, dataSet);   
//        System.out.println("---- 10 Fold Cross Validation");
//        System.out.print("Accuracy : ");
//        System.out.printf("%.2f", result.getAccuracy());
//        
        
        
        
        // Untuk NaiveBayes
        System.out.println("\n\n\n\n-- NB");
        
        DSParse dset;
        dataTest dTest;
        dset = new DSParse("src/glass.arff");
        dTest = new dataTest("src/glass.arff");
        NBAlgo Freq = null;
        
        ArrayList<String> labels = dTest.getLabels();
        
        int i = 0, wrongTest = 0, correctTest = 0;
        
        System.out.println("---- Full Training");
        for (ArrayList<String> test : dTest.getDS()){
             Freq = new NBAlgo(dset,test);
             System.out.println(test);
            
             String res = Freq.getResult();
             
             System.out.print("\tlabel - " + labels.get(i) + " - result - " + res);
             if (labels.get(i).equals(res)){
                 System.out.println(" -> True");
                 correctTest++;
             } else {
                 System.out.println(" -> False");
                 wrongTest++;
             }
             
             i++;
        }
        //Freq.print();
        
        double accuracy = (correctTest * 100) /(correctTest + wrongTest);
        System.out.println("Correctly Classified Instances : " + accuracy + " %");
        System.out.println("Incorrectly Classified Instances : " + (100-accuracy) + " %");
        
        System.out.println("\n\n---- 10 Fold Cross Validation");
        
        ArrayList<String[]> totalDataRecords = dset.getDS();
        ArrayList<ArrayList<String>> totalTestRecords = dTest.getDS();
        
        int totalSize = totalDataRecords.size();
        int step = totalSize / 10;
        wrongTest = 0;
        correctTest = 0;
        
        for (int j = 0 ; j < 10 ; j++){
            System.out.print("-- Test Iteration " + j + "\n");
            
            ArrayList<String[]> dataRecords = new ArrayList<>();
            ArrayList<ArrayList<String>> testRecords = new ArrayList<>();
            
            int startTestIndex = j * step ; 
            int finishTestIndex = (j + 1) * step;
            
            labels = new ArrayList<>();
            
            for (int w = 0;w<totalTestRecords.size();w++){
                if (w >= startTestIndex && w < finishTestIndex){
                    testRecords.add(totalTestRecords.get(w));
                    
                    String[] attrs = totalDataRecords.get(w);
                    labels.add(attrs[attrs.length - 1]);
                } else{
                    dataRecords.add(totalDataRecords.get(w));
                }
            }
            
//            for (i = j * step ; i < (j + 1) * step ; i++){
//                testRecords.add(totalTestRecords.get(i));
//            }
//            
//            for (k = 0 ; k < 10 ; k++){
//                if (k == j) continue;
//                
//                for (i = j * step ; i < (j + 1) * step ; i++){
//                    dataRecords.add(totalDataRecords.get(i));
//                }
//            }
            
            DSParse new_dset = new DSParse();
            new_dset.setDS(dataRecords);
//            System.out.println("-- -- -- -- -- --");
//            new_dset.inspect();
//            System.out.println("-- -- -- -- -- --");
            
            i = 0;
            for (ArrayList<String> test : testRecords){
//                for (int w = 0;w<test.size();w++){
//                    System.out.println("&& ");
//                    System.out.println(test.get(w));
//                }
                
                 Freq = new NBAlgo(new_dset,test);
    //             System.out.println(Freq.getResult());

                 String res = Freq.getResult();

                 System.out.print("\tlabel - " + labels.get(i) + " - result - " + res);
                 if (labels.get(i).equals(res)){
                     System.out.println(" -> True");
                     correctTest++;
                 } else {
                     System.out.println(" -> False");
                     wrongTest++;
                 }

                 i++;
            }
        }
        
        accuracy = (correctTest * 100) /(correctTest + wrongTest);
        System.out.println("Correctly Classified Instances : " + accuracy + " %");
        System.out.println("Incorrectly Classified Instances : " + (100-accuracy) + " %");
//        test.add("sunny");
//        test.add("hot");
//        test.add("high");
//        test.add("TRUE");
        
        //System.out.println("aaas");
        //System.out.println(Freq.getResult());
        //Freq.print();
    }
}
