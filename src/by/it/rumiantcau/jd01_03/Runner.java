package by.it.rumiantcau.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        Double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3 );

    }
}
