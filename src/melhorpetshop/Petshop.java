/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melhorpetshop;

/**
 * @author nanda
 */
public class Petshop {

    private String nome;
    private double precoBanhoCaoPequeno;
    private double precoBanhoCaoGrande;
    private double precoBanhoCaoPequenoFinalDeSemana;
    private double precoBanhoCaoGrandeFinalDeSemana;
    private double distancia;
    private Double custoTotal;
    
    public void petshop(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrecoBanhoCaoPequeno() {
        return precoBanhoCaoPequeno;
    }

    public void setPrecoBanhoCaoPequeno(Double precoBanhoCaoPequeno) {
        this.precoBanhoCaoPequeno = precoBanhoCaoPequeno;
    }

    public Double getPrecoBanhoCaoGrande() {
        return precoBanhoCaoGrande;
    }

    public void setPrecoBanhoCaoGrande(Double precoBanhoCaoGrande) {
        this.precoBanhoCaoGrande = precoBanhoCaoGrande;
    }

    public Double getPrecoBanhoCaoPequenoFinalDeSemana() {
        return precoBanhoCaoPequenoFinalDeSemana;
    }

    public void setPrecoBanhoCaoPequenoFinalDeSemana(Double precoBanhoCaoPequenoFinalDeSemana) {
        this.precoBanhoCaoPequenoFinalDeSemana = precoBanhoCaoPequenoFinalDeSemana;
    }

    public Double getPrecoBanhoCaoGrandeFinalDeSemana() {
        return precoBanhoCaoGrandeFinalDeSemana;
    }

    public void setPrecoBanhoCaoGrandeFinalDeSemana(Double precoBanhoCaoGrandeFinalDeSemana) {
        this.precoBanhoCaoGrandeFinalDeSemana = precoBanhoCaoGrandeFinalDeSemana;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void alteraValorBanho() {
        this.precoBanhoCaoGrandeFinalDeSemana = precoBanhoCaoGrande + (precoBanhoCaoGrande * 0.2);
        this.precoBanhoCaoPequenoFinalDeSemana = precoBanhoCaoPequeno + (precoBanhoCaoPequeno * 0.2);
    }

    public Double calculaCusto(int quantidadeCaesGrandes, int quantidadeCaesPequenos) {
        Double custo = (quantidadeCaesGrandes * this.precoBanhoCaoGrande) + (quantidadeCaesPequenos * this.precoBanhoCaoPequeno);
        return custo;
    }

    public Double calculaCustoFinalDeSemana(int quantidadeCaesGrandes, int quantidadeCaesPequenos) {
        Double custo = (quantidadeCaesGrandes * this.precoBanhoCaoGrandeFinalDeSemana) + (quantidadeCaesPequenos * this.precoBanhoCaoPequenoFinalDeSemana);
        return custo;
    }

}
