package TugasAsd7;

import java.util.ArrayList;
import java.util.Scanner;

public class buble{
    
    //METHOD ISI DATA
    static ArrayList<Double> inisialisasi(){
        ArrayList<Double> arrList = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        System.out.print("Input Banyak Data : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Double nilai = sc.nextDouble();
            arrList.add(nilai);
        }
        return arrList;
    }
    
    //METHOD CETAK
    static void cetak (ArrayList<Double> cetak){
        System.out.print("[");
        for(Double value : cetak){
            System.out.print(" "+value+" ");
        }
        System.out.println("]");
}
    
    //METHOD KLONING
    static ArrayList<Double> kloning(ArrayList<Double> kloning){
        ArrayList<Double> arrList1 = null;
        if(kloning != null){
            arrList1 = new ArrayList<>();
            for(Double value1 : kloning){
                arrList1.add(value1);
            }
        }
        return arrList1;
    }
    
    //METHOD SORTING
    static void tukarNilai (ArrayList<Double> tukarNilai, int indexA, int indexB){
        if(indexA >= 0 && indexA <tukarNilai.size() && indexB >= 0 && indexB <tukarNilai.size() && indexA != indexB){
            Double A, B, C;
            A = tukarNilai.get(indexA);
            B = tukarNilai.get(indexB);
            C = A;
            A = B;
            B = C;
            tukarNilai.set(indexA, A);
            tukarNilai.set(indexB, B);
        }
    }
    
    //ALGORITMA BUBBLE SORT
    static void bubbleSort (ArrayList<Double> bubble){
        int n = bubble.size();
        boolean adaPertukaran = true;
        do{
            adaPertukaran = false;
            for (int i = 1; i < n; i++) {
                if(bubble.get(i-1) > bubble.get(i)){
                    tukarNilai(bubble, (i-1), i);
                    adaPertukaran = true;
                }
            }
            n--;
        }while(adaPertukaran);
    }
    
    
            
    public static void main(String[] args) {
        ArrayList<Double> data = inisialisasi();
        System.out.print("Data Asli      : ");
        cetak(data);
        
        ArrayList<Double> data1 = kloning(data);
        System.out.print("Bubble Sort    : ");
        bubbleSort(data1);
        cetak(data1);
       
    }
    
}
