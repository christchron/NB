/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
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
        
        int k = 1;
        String fileName = "weather.nominal.arff";
        
        DataSet dataSet = new DataSet();
        dataSet.parseDataSet(fileName);
        
        dataSet.inspect();
        
        System.out.println("\n\n\n\n-- KNN\n\n");
        
        Classifier classifier = new Classifier();
        Result result = classifier.doFullTraining(k, dataSet);
        
        System.out.println("---- Full Training");
        System.out.println("Accuracy : " + result.getAccuracy());
        
        result = classifier.doTenCrossFoldValidation(k, dataSet);   
        System.out.println("---- 10 Fold Cross Validation");
        System.out.println("Accuracy : " + result.getAccuracy());
        
        
        
        
        
        // Untuk NaiveBayes
        System.out.println("\n\n\n\n-- NB\n\n");
        
        DSParse dset;
        dataTest dTest;
        dset = new DSParse("weather.nominal.arff");
        dTest = new dataTest("weather.nominal.arff");
        NBAlgo Freq;
        
        ArrayList<String> labels = dTest.getLabels();
        
        int i = 0, wrongTest = 0, correctTest = 0;
        
        for (ArrayList<String> test : dTest.getDS()){
             Freq = new NBAlgo(dset,test);
//             System.out.println(Freq.getResult());
             
             String res = Freq.getResult();
             
             System.out.print("label - " + labels.get(i) + " - result - " + res);
             if (labels.get(i).equals(res)){
                 System.out.println(" -> True");
                 correctTest++;
             } else {
                 System.out.println(" -> False");
                 wrongTest++;
             }
             
             i++;
        }
        
        System.out.println("---- Full Training");
        
        double accuracy = (correctTest * 100) /(correctTest + wrongTest);
        System.out.println("Accuracy : " + accuracy + " %");
        
        System.out.println("---- 10 Fold Cross Validation");
        System.out.println("Accuracy : " + result.getAccuracy());
//        test.add("sunny");
//        test.add("hot");
//        test.add("high");
//        test.add("TRUE");
        
        //System.out.println("aaas");
        //System.out.println(Freq.getResult());
        //Freq.print();
    }
}
