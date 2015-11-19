/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author X450
 */
public class dataTest {
    private String filename;
    private ArrayList<ArrayList<String>> dTest;
    
    private ArrayList<String> labels = new ArrayList<String>();
    
    @SuppressWarnings("empty-statement")
    public dataTest(String fl){
        String csvFile = fl;
        BufferedReader br = null;
        String sCurrentLine;
        String[] temp;
        ArrayList<String[]> dataset;
        ArrayList<String> tempTest = null;
        dTest = new ArrayList<ArrayList<String>>();
        try{
            br = new BufferedReader(new FileReader(csvFile));
            dataset = new ArrayList<String[]>();
            while (!(sCurrentLine = br.readLine()).equals("@data")) {}
            while ((sCurrentLine = br.readLine()) != null) {
                temp = sCurrentLine.split(",");
                dataset.add(temp);
            }
            for (int i = 0;i < dataset.size();i++){
                tempTest = new ArrayList<String>();
                for (int j = 0;j<(dataset.get(i).length)-1;j++){
                    //System.out.print(dataset.get(i)[j]);
                    tempTest.add(dataset.get(i)[j]);
                }
                
                labels.add(dataset.get(i)[dataset.get(i).length-1]);
                
                //System.out.println();
                //System.out.print(tempTest.size());
                dTest.add(tempTest);
                for (int k = 0;k<tempTest.size();k++){
                   // System.out.print(tempTest.get(k));
                    
                }
                //System.out.println();
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println("Done");
    }    
    
    public ArrayList<ArrayList<String>> getDS(){
        return dTest;
    }
    
    public ArrayList<String> getLabels(){
        return labels;
    }
}
