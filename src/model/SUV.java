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
        return this.idSUV;
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Tipo: SUV" +
                ", ID: " + this.idSUV +
                ", Valor diária: R$ " + this.valorAluguel + ",00";
    }
}