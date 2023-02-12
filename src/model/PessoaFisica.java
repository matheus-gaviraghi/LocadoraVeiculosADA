package model;

import java.time.LocalDate;
import java.time.Period;

public class PessoaFisica extends Cliente{
    private final LocalDate dataDeNascimento;
    private String cpf;


    public PessoaFisica(String nomeCliente, String telefone, LocalDate dataDeNascimento, String cpf){
        super(nomeCliente, telefone);
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String getId() {
        return this.cpf;
    }

    public int getIdade() {
        return Period.between(dataDeNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String tipoDeCliente() {
        return "Pessoa Física";
    }

    @Override
    public String toString() {
        return super.toString()  +
                ", Data de Nascimento: " + dataDeNascimento +
                ", CPF: " + this.cpf +
                ", Idade: " + this.getIdade();
    }
}
