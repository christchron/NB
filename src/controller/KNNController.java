/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Result.*;
import java.util.ArrayList;
import nb.DSParse;
import nb.NBAlgo;
import nb.dataTest;

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
        int k = 1;
        String fileName = "src/weather.nominal.arff";
        
        DataSet dataSet = new DataSet();
        dataSet.parseDataSet(fileName);
        
        Classifier executor = new Classifier();
        Result result = executor.doFullTraining(k, dataSet);
        
        Result result = executor.doTenCrossFoldValidation(k, dataSet);   
    }
}
