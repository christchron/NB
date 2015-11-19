

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.*;
import java.util.*;
import java.lang.*;
/**
 *
 * @author X450
 */
public class DataSet {
    private String filename, relation;
    private ArrayList<String[]> dataset;
    private HashMap<String, String[]> attributes;
    
    private HashMap<String, String[]> getDatasetAttributes(String dataString){
        String frontSplit[] = dataString.split("{");
                    
        String attribute = frontSplit[0].split(" ")[1];
        String data = frontSplit[1].split("}")[0]; // sunny, overcast, rainy
        attributes.put(attribute, data.split(","));
        
        return attributes;
    }
    
    private String getDatasetRelation(String dataString){
        String relation = dataString.split(" ")[1];
                    
        return relation;
    }
    
    @SuppressWarnings("empty-statement")
    public void parseDataSet(String fileName){
        
        BufferedReader br = null;
        String sCurrentLine;
        String[] temp;
        int tempLength = 0, j = 0;
        
        try{
            //Map<String, String> maps = new HashMap<String, String>();
            br = new BufferedReader(new FileReader(fileName));
                    /*while ((line = br.readLine()) != null) {
                            // use comma as separator
                            String[] country = line.split(cvsSplitBy);
                            maps.put(country[4], country[5]);
                    }
                    //loop map
                    for (Map.Entry<String, String> entry : maps.entrySet()) {
                            System.out.println("Country [code= " + entry.getKey() + " , name="
                                    + entry.getValue() + "]");
                    }*/
            dataset = new ArrayList<String[]>();
            while ((sCurrentLine = br.readLine()) != null) {
                //System.out.println(sCurrentLine);
                
                if (sCurrentLine.startsWith("@attribute")){
                    attributes = getDatasetAttributes(sCurrentLine);
                }
                
                if (sCurrentLine.startsWith("@relation")){
                    relation = getDatasetRelation(sCurrentLine);
                }
                
                if (sCurrentLine.startsWith("@") || sCurrentLine.startsWith("%") || sCurrentLine.equals("")){
                    continue;
                }
                
                temp = sCurrentLine.split(",");
                tempLength = temp.length;
                    //dataset[j][i] = temp[i];
                    //System.out.println(temp[i]);
                dataset.add(temp);
                    
                    //System.out.println((String[])dataset.get(i));
                
                //System.arraycopy(temp, 0, dataset[j], 0, tempLength);
            }
//            for (int i = 0;i<dataset.size();i++){
//                for (int p=0;p<dataset.get(i).length;p++){
//                   // System.out.print(dataset.get(i)[p]);
//                }
//                //System.out.println();
//            }
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
    
    public String getRelation(){
        return relation;
    }
    
    public HashMap<String, String[]> getAttributes(){
        return attributes;
    }
}
