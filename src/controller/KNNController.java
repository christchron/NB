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
public class KNNController {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Untuk KNN
        
        int k = 1;
        String fileName = "src/weather.nominal.arff";
        
        DataSet dataSet = new DataSet();
        dataSet.parseDataSet(fileName);
        
        Classifier classifier = new Classifier();
        Result result = classifier.doFullTraining(k, dataSet);
        
        result = classifier.doTenCrossFoldValidation(k, dataSet);   
        
        // Untuk NaiveBayes
        
        DSParse dset;
        dataTest dTest;
        dset = new DSParse("src/weather.nominal.arff");
        dTest = new dataTest("src/weather.nominal.arff");
        NBAlgo Freq;
        
        for (ArrayList<String> test : dTest.getDS()){
             Freq = new NBAlgo(dset,test);
             System.out.println(Freq.getResult());
        }
//        test.add("sunny");
//        test.add("hot");
//        test.add("high");
//        test.add("TRUE");
        
        //System.out.println("aaas");
        //System.out.println(Freq.getResult());
        //Freq.print();
    }
}
