/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melhorpetshop;

import java.util.Scanner;

/**
 *
 * @author nanda
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Bem vindo ao MelhorPetshop!");
        System.out.println("Insira a data, o número de cães pequenos e o número de cães grandes: ");
        String agenda = entrada.nextLine();

        MelhorPetshop melhorPet = new MelhorPetshop();
        melhorPet.carregaPetshops();

        System.out.println(melhorPet.retornaMelhorPetshop(agenda));

    }

}
