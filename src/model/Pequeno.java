package model;

import java.math.BigDecimal;

public class Pequeno extends Veiculo{

    private static Integer idSerial = 0;
    private final String idPequeno;
    private final BigDecimal valorAluguel = new BigDecimal(100);

    public Pequeno(Integer ano, String marca, String modelo,
                   String placa, Double quilometragem, Double cilindradas) {
        super(ano, marca, modelo, placa, quilometragem, cilindradas);
        this.idPequeno = "P-" + idSerial;
        this.idSerial++;
    }

    @Override
    public String getId() {
        return this.getPlaca();
    }

    @Override
    public String getNomeCadastro(){ return this.idPequeno; }

    public BigDecimal getValorAluguel() {
        return this.valorAluguel;
    }

    @Override
    public String tipoDeVeiculo() {
        return "Pequeno";
    }

    @Override
    public String toString() {
        return this.idPequeno + " -> " + super.toString() +
                ", Tipo: Pequeno" +
                ", Valor diária: R$ " + this.valorAluguel + ",00";
    }
}
