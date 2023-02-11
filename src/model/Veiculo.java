package model;

public abstract class Veiculo implements Entidade{

    private static final long serialVersionUID = 1L;

    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;
    private Double quilometragem;
    private Double cilindradas;

    private boolean isDisponivel;

    public Veiculo(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.cilindradas = cilindradas;
        this.isDisponivel = true;
    }

    public Integer getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public Double getQuilometragem() {
        return quilometragem;
    }

    public Double getCilindradas() {
        return cilindradas;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    @Override
    public String toString() {
        return  "Ano: " + ano +
                ", Marca: " + marca +
                ", Modelo: " + modelo +
                ", Placa: " + placa +
                ", Quilometragem: " + quilometragem +
                ", Cilindradas: " + cilindradas;
    }
}
