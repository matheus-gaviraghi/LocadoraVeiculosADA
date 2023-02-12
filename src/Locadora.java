import business.GerenciadorDeCliente;
import business.GerenciadorDeVeiculo;
import model.Cliente;
import model.Pequeno;
import model.PessoaFisica;
import model.Veiculo;
import persistence.ClienteEmMemoriaRepository;
import persistence.Repository;
import persistence.VeiculoEmMemoriaRepository;
import persistence.VeiculoRepository;

import java.time.LocalDate;
import java.time.Month;

public class Locadora {

    public static void main(String[] args) {

        // Manipulação de veículo
        VeiculoEmMemoriaRepository repositorioDeVeiculo = new VeiculoEmMemoriaRepository();
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo<>(repositorioDeVeiculo);

        Veiculo carroPequeno = new Pequeno(2020, "FIAT", "Palio",
                "S1S3159", 8900.00, 1.6);

        gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno);

        System.out.println("Veículos registrados:");
        gerenciadorDeVeiculo.listarTodos().forEach(System.out::println);;

        //carroPequeno.setDisponivel(false);
        System.out.println("Veiculos Disponíveis:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);;

        // Tentando adicionar o mesmo veiculo
        // gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno);

        // Manipulação de cliente
        ClienteEmMemoriaRepository repositorioDeCliente = new ClienteEmMemoriaRepository();
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente<>(repositorioDeCliente);

        PessoaFisica pessoaFisica1 = new PessoaFisica("Matheus", "999999999", LocalDate.of(1991, Month.FEBRUARY, 15), "12345");

        gerenciadorDeCliente.adicionarCliente(pessoaFisica1);
        gerenciadorDeCliente.listarTodos().forEach(System.out::println);

        // Tentando adicionar o mesmo cliente
       // gerenciadorDeCliente.adicionarCliente(pessoaFisica1);
    }
}
