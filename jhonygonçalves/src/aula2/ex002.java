
package aula2;

import java.util.Scanner;

public class ex002 {
    public static void main(String[] args){
        Scanner x = new Scanner(System.in);
        System.out.println("Digite o valor de A: ");
        double a = x.nextDouble();
        System.out.println("Digite o valor de B: ");
        double b = x.nextDouble();
        double divisao = a / b;
        System.out.println("O valor da divisão de A com B = " + divisao);
    }
}
