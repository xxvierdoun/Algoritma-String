package TugasAsd7;

import java.util.ArrayList;
import java.util.Scanner;

public class merge{
    
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

    //ALGORITMA MERGE SORT
    static void mergeSort(ArrayList<Double> merge){
        int n = merge.size();
        if(n<2){
            return;
        }
        int tengah = n/2;
        
        ArrayList<Double> mergeKiri = new ArrayList<>();
        for (int i = 0; i < tengah; i++) {
            mergeKiri.add(merge.get(i));
        }
        
        ArrayList<Double> mergeKanan = new ArrayList<>();
        for (int i = tengah; i < n; i++) {
            mergeKanan.add(merge.get(i));
        }
        
        mergeSort(mergeKiri);
        mergeSort(mergeKanan);
        
        merge(merge, mergeKiri, mergeKanan);
    }
    
    static void merge(ArrayList<Double> merge, ArrayList<Double> mergeKiri, ArrayList<Double> mergeKanan){
        int i = 0, j=0, k=0;
        int sKiri = mergeKiri.size();
        int sKanan = mergeKanan.size();
        
        while(i<sKiri && j<sKanan){
            if (mergeKiri.get(i)<mergeKanan.get(j)) {
                merge.set(k++, mergeKiri.get(i++));
            }
            else{
                merge.set(k++, mergeKanan.get(j++));
            }
        }
        while(i<sKiri){
            merge.set(k++, mergeKiri.get(i++));
        }
        while(j<sKanan){
            merge.set(k++, mergeKanan.get(j++));
        }
    }
    
            
    public static void main(String[] args) {
        ArrayList<Double> data = inisialisasi();
        System.out.print("Data Asli      : ");
        cetak(data);
        
        ArrayList<Double> data4 = kloning(data);
        System.out.print("Merge Sort     : ");
        mergeSort(data4);
        cetak(data4);
        
        
    }
    
}
