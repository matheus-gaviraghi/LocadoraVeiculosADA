package model;

public abstract class Cliente implements Entidade{
    private String nomeCliente;
    private String telefone;

    public Cliente(String nomeCliente, String telefone){
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
    }

    public void setNomeCliente(String nome){
        this.nomeCliente = nome;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public String getNomeCadastro(){
        return this.nomeCliente;
    }

    public abstract String tipoDeCliente();
    @Override
    public String toString() {
        return "Nome do cliente: " + this.nomeCliente +
                ", Telefone: " + this.telefone;
    }
}
