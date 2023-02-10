import java.math.BigDecimal;

public class SUV extends Veiculo{
    private static Integer idSerial = 0;
    private final String idSUV;
    private final BigDecimal valorAluguel = new BigDecimal(200);

    public SUV(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idSUV = "S" + idSerial;
        this.idSerial++;
    }

    public String getIdSUV() {
        return this.idSUV;
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }
}
