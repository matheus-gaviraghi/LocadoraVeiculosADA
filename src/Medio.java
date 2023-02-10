import java.math.BigDecimal;

public class Medio extends Veiculo{
    private static Integer idSerial = 0;
    private final String idMedio;
    private final BigDecimal valorAluguel = new BigDecimal(150);

    public Medio(Integer ano, String marca, String modelo,
               String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idMedio = "M" + idSerial;
        this.idSerial++;
    }

    public String getIdMedio() {
        return this.idMedio;
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }
}
