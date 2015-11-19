/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb;

import java.util.ArrayList;

/**
 *
 * @author X450
 */
public class NB {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
<<<<<<< HEAD
        DataSet dset;
        dset = new DataSet("src/car.csv");
        ArrayList<String> test= new ArrayList<String>();
        test.add("low");
        test.add("low");
        test.add("4");
        test.add("more");
        test.add("small");
        test.add("low");
        NBAlgo Freq = new NBAlgo(dset,test);
        //System.out.println("aaas");
        System.out.println(Freq.getResult());
=======
        DSParse dset;
        dataTest dTest;
        dset = new DSParse("src/weather.nominal.arff");
        dTest = new dataTest("src/weather.nominal.arff");
        NBAlgo Freq;
        //ArrayList<String> test= new ArrayList<String>();
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
>>>>>>> 578028d438697b669a7c5df8206b7f1b45147252
        //Freq.print();
    }   
}
