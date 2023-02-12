package model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

public class Locacao {

    private static Integer idSerial = 0;
    private String idLocacao;
    private Cliente cliente;
    private Veiculo veiculo;

    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;

    private String localLocacao;
    private String localDevolucao;

    public Locacao(Cliente cliente){
        this.cliente = cliente;
        this.idLocacao = "L-" + idSerial;
        this.idSerial++;
    }

    private LocalDateTime getDataLocacao() {
        return this.dataLocacao;
    }

    private void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    private LocalDateTime getDataDevolucao() {
        return this.dataDevolucao;
    }

    private void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void alugar(Veiculo veiculo, LocalDateTime dataLocacao, String localLocacao){
        if(!veiculo.isDisponivel()){
            throw new RuntimeException("Infelizmente não é possível alugar o veículo de placa "+ veiculo.getId()+" nesse momento.");
        } else{
            this.dataLocacao = dataLocacao;
            this.veiculo = veiculo;
            this.localLocacao = localLocacao;
            veiculo.setDisponivel(false);
            System.out.println("Veículo de placa " + veiculo.getId() + " alugado com sucesso para cliente de ID " + this.cliente.getId());
        }
    }

    public void devolver(LocalDateTime dataDevolucao, String localDevolucao){
        if(dataDevolucao.isBefore(dataLocacao) || dataDevolucao == null){
            throw new IllegalArgumentException("A data de devolução é anterior à data de locação!");
        }

        this.dataDevolucao = dataDevolucao;
        this.localDevolucao = localDevolucao;

        long dias = Duration.between(dataLocacao, dataDevolucao).toDays() + 1;

        System.out.println("\nO veículo " + veiculo.getNomeCadastro() + " foi devolvido em " +
                this.localDevolucao + " após " + dias + " dia(s)! " +
                "O valor total do aluguel é de R$ " + this.calcularAluguel(dias));
        veiculo.setDisponivel(true);
    }

    private BigDecimal calcularAluguel(long dias){

        BigDecimal valorAluguel;
        Double desconto;

        valorAluguel = calcularDesconto(dias);
        valorAluguel = valorAluguel.multiply(veiculo.getValorAluguel());
        valorAluguel = valorAluguel.multiply(new BigDecimal(dias));

        return valorAluguel;
    }

    private BigDecimal calcularDesconto(long dias){
        if (cliente instanceof PessoaFisica && dias > 5) {
            return new BigDecimal(0.95);
        } else if (cliente instanceof PessoaJuridica && dias > 3){
            return new BigDecimal(0.90);
        } else {
            return new BigDecimal(1);
        }
    }

    @Override
    public String toString() {
        return "Locação: " + this.idLocacao +
                ", Nome cliente: " + cliente.getNomeCadastro() +
                ", ID do cliente: " + cliente.getId() +
                ", ID do veículo: " + veiculo.getNomeCadastro() +
                ", Placa veículo: " + veiculo.getId() +
                ", Local de locação: " + this.localLocacao;
    }
}
