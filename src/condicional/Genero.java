package condicional;

import java.util.Scanner;

public class Genero {

    public static void main(String[] args) {

        char genero;
        Scanner sc = new Scanner(System.in);

        System.out.print ("Informe o gênero (F) ou (M): ");
        genero = sc.next().charAt(0);
        genero = Character.toUpperCase(genero);

        System.out.println((genero == 'F' ) ? "Feminino" : (genero == 'M') ? "Masculino" : "Valor Inválido");


    }
}
