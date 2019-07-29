/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melhorpetshop;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author nanda
 */
public class MelhorPetshop {

    /**
     * @param args the command line arguments
     */
    private Double melhorCustoTotal;
    private String resultado;
    private String dataTexto;
    private String caesPequenos;
    private String caesGrandes;
    private int numeroCaesPequenos;
    private int numeroCaesGrandes;
    private String entrada;

    public void MelhorPetshop() {
    }

    Petshop petshop0 = new Petshop();
    Petshop petshop1 = new Petshop();
    Petshop petshop2 = new Petshop();

    public void carregaPetshops() {

        petshop0.setNome("Meu Canino Feliz");
        petshop0.setPrecoBanhoCaoPequeno(20.00);
        petshop0.setPrecoBanhoCaoGrande(40.00);
        petshop0.alteraValorBanho();
        petshop0.setDistancia(2.0);
        petshop0.setCustoTotal(0.0);

        petshop1.setNome("Vai Rex");
        petshop1.setPrecoBanhoCaoPequeno(15.00);
        petshop1.setPrecoBanhoCaoGrande(50.00);
        petshop1.setPrecoBanhoCaoPequenoFinalDeSemana(20.00);
        petshop1.setPrecoBanhoCaoGrandeFinalDeSemana(55.00);
        petshop1.setDistancia(1.7);
        petshop1.setCustoTotal(0.0);

        petshop2.setNome("ChowChawgas");
        petshop2.setPrecoBanhoCaoPequeno(30.00);
        petshop2.setPrecoBanhoCaoGrande(45.00);
        petshop2.setPrecoBanhoCaoPequenoFinalDeSemana(30.00);
        petshop2.setPrecoBanhoCaoGrandeFinalDeSemana(45.00);
        petshop2.setDistancia(0.8);
        petshop2.setCustoTotal(0.0);
    }

    private String calculaMelhorCustoTotal() {
        if (finalDeSemana()) {
            petshop0.setCustoTotal(petshop0.calculaCustoFinalDeSemana(numeroCaesGrandes, numeroCaesPequenos));
            petshop1.setCustoTotal(petshop1.calculaCustoFinalDeSemana(numeroCaesGrandes, numeroCaesPequenos));
            petshop2.setCustoTotal(petshop2.calculaCustoFinalDeSemana(numeroCaesGrandes, numeroCaesPequenos));

        } else {
            petshop0.setCustoTotal(petshop0.calculaCusto(numeroCaesGrandes, numeroCaesPequenos));
            petshop1.setCustoTotal(petshop1.calculaCusto(numeroCaesGrandes, numeroCaesPequenos));
            petshop2.setCustoTotal(petshop2.calculaCusto(numeroCaesGrandes, numeroCaesPequenos));
        }

        //lista de petshop ou petshops com menores custos
        List<Petshop> petshops = new ArrayList<Petshop>();

        melhorCustoTotal = petshop2.getCustoTotal();
        petshops.add(petshop2);

        if (petshop0.getCustoTotal() <= melhorCustoTotal) {
            if (Objects.equals(petshop0.getCustoTotal(), melhorCustoTotal)) {
                petshops.add(petshop0);
            } else {
                petshops.remove(petshop2);
                petshops.add(petshop0);
                melhorCustoTotal = petshop0.getCustoTotal();
            }
            melhorCustoTotal = petshop0.getCustoTotal();

        }

        if (petshop1.getCustoTotal() <= melhorCustoTotal) {
            if (Objects.equals(petshop1.getCustoTotal(), melhorCustoTotal)) {
                petshops.add(petshop1);
            } else {
                petshops.add(petshop1);
                if (petshops.contains(petshop2)) {
                    petshops.remove(petshop2);
                }
                if (petshops.contains(petshop0)) {
                    petshops.remove(petshop0);
                }
                melhorCustoTotal = petshop1.getCustoTotal();
            }
            melhorCustoTotal = petshop1.getCustoTotal();
        }

        Petshop petshopGanhador = new Petshop();
        
        //define qual o melhor petshop da lista de petshops com menores custos considerando empate
        if (petshops.size() >= 1) {

            petshopGanhador = petshops.get(0);
            for (int tamanho = 0; tamanho < petshops.size(); tamanho++) {
                Petshop petshopAuxiliar = new Petshop();
                petshopAuxiliar = petshops.get(tamanho);
                if (petshopAuxiliar.getDistancia() < petshopGanhador.getDistancia()) {
                    petshopGanhador = petshopAuxiliar;
                }

            }
            return "Canil: " + petshopGanhador.getNome() + "  Custo em reais: " + String.valueOf(melhorCustoTotal);

        } else {
            return "Canil: " + petshopGanhador.getNome() + "  Custo em reais: " + String.valueOf(melhorCustoTotal);
        }
    }

    public String retornaMelhorPetshop(String agenda) {
        this.entrada = agenda;
        converte(entrada);
        resultado = calculaMelhorCustoTotal();

        return resultado;
    }

    public void converte(String agenda) {
        //convertendo a string de entrada para os parametros do programa
        String[] entradas = agenda.split(" ");
        this.dataTexto = entradas[0];
        this.caesPequenos = entradas[1];
        this.caesGrandes = entradas[2];

        // convertendo a string quantidade de caes para o tipo inteiro
        this.numeroCaesPequenos = Integer.parseInt(caesPequenos);
        this.numeroCaesGrandes = Integer.parseInt(caesGrandes);
    }

    private Boolean finalDeSemana() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAgenda = LocalDate.parse(dataTexto, formato);

        DayOfWeek dia = dataAgenda.getDayOfWeek();
        return dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY;
    }
}
