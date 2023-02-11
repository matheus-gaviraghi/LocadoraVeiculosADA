import business.GerenciadorDeVeiculo;
import model.Pequeno;
import model.Veiculo;
import persistence.Repository;
import persistence.VeiculoEmMemoriaRepository;
import persistence.VeiculoRepository;

public class Locadora {

    public static void main(String[] args) {

        VeiculoRepository repositorioDeVeiculo = new VeiculoEmMemoriaRepository();
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo<>(repositorioDeVeiculo);

        Veiculo carroPequeno = new Pequeno(2020, "FIAT", "Palio",
                "S1S3159", 8900.00, 1.6);

        //carroPequeno.setDisponivel(false);

        gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno);

        gerenciadorDeVeiculo.listarTodos().forEach(System.out::println);

        System.out.println("Veiculos Disponíveis:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);
    }
}
