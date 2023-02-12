package model;

import java.math.BigDecimal;

public class SUV extends Veiculo {

    private static Integer idSerial = 0;
    private final String idSUV;
    private final BigDecimal valorAluguel = new BigDecimal(200);

    public SUV(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idSUV = "S-" + idSerial;
        this.idSerial++;
    }

    @Override
    public String getId() {
        return this.getPlaca();
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }

    @Override
    public String tipoDeVeiculo() {
        return "SUV";
    }

    @Override
    public String getNomeCadastro(){ return this.idSUV; }

    @Override
    public String toString() {
        return this.idSUV + " -> " + super.toString() +
                ", Tipo: SUV" +
                ", Valor diária: R$ " + this.valorAluguel + ",00";
    }
}
