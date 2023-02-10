public abstract class Veiculo {
    private Integer ano;
    private String marca;
    private String modelo;
    private String placa;
    private Double quilometragem;
    private Double cilindradas;

    public Veiculo(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.quilometragem = quilometragem;
        this.cilindradas = cilindradas;
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

    @Override
    public String toString() {
        return "Veiculo{" +
                "ano=" + ano +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", quilometragem=" + quilometragem +
                ", cilindradas=" + cilindradas +
                '}';
    }
}
