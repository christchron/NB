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
import java.util.ArrayList;
import java.lang.*;
/**
 *
 * @author X450
 */
public class DSParse {
    private String filename;
    private ArrayList<String[]> dataset;
    @SuppressWarnings("empty-statement")
    public DSParse(String fl){
        String csvFile = fl;
        BufferedReader br = null;
        String sCurrentLine;
        String[] temp;
        int j=0;
        try{
            br = new BufferedReader(new FileReader(csvFile));
            dataset = new ArrayList<String[]>();
            while (!(sCurrentLine = br.readLine()).equals("@data")) {}
            while ((sCurrentLine = br.readLine()) != null) {
                temp = sCurrentLine.split(",");
                dataset.add(temp);
            }
            for (int i = 0;i<dataset.size();i++){
                for (int p=0;p<dataset.get(i).length;p++){
                   // System.out.print(dataset.get(i)[p]);
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
        System.out.println("Done");
    }
    
    public ArrayList<String[]> getDS(){
        return dataset;
    }
}
