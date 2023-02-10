import java.math.BigDecimal;

public class Pequeno extends Veiculo{
    private static Integer idSerial = 0;
    private final String idPequeno;
    private final BigDecimal valorAluguel = new BigDecimal(100);

    public Pequeno(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idPequeno = "P" + idSerial;
        this.idSerial++;
    }

    public String getIdPequeno() {
        return this.idPequeno;
    }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }
}
