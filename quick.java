package TugasAsd7;

import java.util.ArrayList;
import java.util.Scanner;

public class quick {
    
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
    
    //ALGORITMA QUICK SORT
    static int partisi (ArrayList<Double> arrList, int low, int high){
        Double pivot = arrList.get(high);
        int i = low-1;
        for (int j = low; j < high; j++) {
            if(arrList.get(j)<pivot){
                i++;
                tukarNilai(arrList, i, j);
            }
        }
        tukarNilai(arrList, i+1, high);
        return i+1;
    }
    static void quickSort(ArrayList<Double> arrList, int low, int high){
        if (low<high) {
            int indexPartisi = partisi(arrList, low, high);
            quickSort(arrList, low, indexPartisi-1);
            quickSort(arrList, indexPartisi+1, high);
        }
    }
            
    public static void main(String[] args) {
        ArrayList<Double> data = inisialisasi();
        System.out.print("Data Asli      : ");
        cetak(data);

        
        ArrayList<Double> data5 = kloning(data);
        System.out.print("Quick Sort     : ");
        quickSort(data5, 0, data5.size()-1);
        cetak(data5);
        
    }
    
}
