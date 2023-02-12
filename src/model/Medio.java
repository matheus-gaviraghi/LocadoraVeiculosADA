package model;

import java.math.BigDecimal;

public class Medio extends Veiculo{

    private static Integer idSerial = 0;
    private final String idMedio;
    private final BigDecimal valorAluguel = new BigDecimal(150);

    public Medio(Integer ano, String marca, String modelo,
               String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idMedio = "M-" + idSerial;
        this.idSerial++;
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }


    @Override
    public String getId() {
        return this.getPlaca();
    }

    @Override
    public String getNomeCadastro(){ return this.idMedio; }

    @Override
    public String tipoDeVeiculo() {
        return "Médio";
    }

    @Override
    public String toString() {
        return this.idMedio + " -> " + super.toString() +
                ", Tipo: Médio" +
                ", Valor diária: R$ " + this.valorAluguel + ",00";
    }

}
