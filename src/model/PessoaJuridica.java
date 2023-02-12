package model;

import java.time.LocalDate;
import java.time.Period;

public class PessoaJuridica extends Cliente{

    private final LocalDate dataDeAbertura;
    private String cnpj;

    public PessoaJuridica(String nomeCliente, String telefone,
                          LocalDate dataDeAbertura, String cnpj){
        super(nomeCliente, telefone);
        this.dataDeAbertura = dataDeAbertura;
        this.cnpj = cnpj;
    }

    public LocalDate getDataDeAbertura() {
        return this.dataDeAbertura;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    @Override
    public String getId() {
        return this.cnpj;
    }

    public int getAnosCnpj() {
        return Period.between(dataDeAbertura, LocalDate.now()).getYears();
    }

    @Override
    public String tipoDeCliente() {
        return "Pessoa Jurídica";
    }

    @Override
    public String toString() {
        return super.toString()  +
                ", CNPJ: " + this.cnpj +
                ", Anos de Razão Social: " + this.getAnosCnpj();
    }
}
