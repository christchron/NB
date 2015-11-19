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
        DSParse dset;
        dset = new DSParse("src/weather.nominal.arff");
        ArrayList<String> test= new ArrayList<String>();
        test.add("overcast");
        test.add("hot");
        test.add("high");
        test.add("FALSE");
        NBAlgo Freq = new NBAlgo(dset,test);
        //System.out.println("aaas");
        System.out.println(Freq.getResult());
        //Freq.print();
    }   
}
