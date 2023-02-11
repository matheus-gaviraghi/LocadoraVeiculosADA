package business;

import model.Medio;
import model.Pequeno;
import model.Veiculo;
import persistence.VeiculoRepository;

import java.util.List;

public class GerenciadorDeVeiculo<T extends Veiculo> {

    private final VeiculoRepository repository;

    public GerenciadorDeVeiculo(VeiculoRepository repository){
        this.repository = repository;
    }

    public void adicionarVeiculo(T veiculo){
        String tipoVeiculo;

        if(veiculo instanceof Pequeno){
            tipoVeiculo = "Pequeno";
        } else if (veiculo instanceof Medio) {
            tipoVeiculo = "Médio";
        } else {
            tipoVeiculo = "SUV";
        }

        if(existeVeiculo(veiculo.getPlaca())){
            throw new RuntimeException("Já existe um registro do tipo %s com a placa %s".formatted(tipoVeiculo, veiculo.getPlaca()));
        }

        repository.salvar(veiculo);
    }

    public boolean existeVeiculo(String placa){
        return repository.consultar(placa) != null;
    }

    public Veiculo consultarPorPlaca(String placa){
        return repository.consultar(placa);
    }

    public void editarVeiculo(String placa, boolean disponibilidade){
        Veiculo veiculo = consultarPorPlaca(placa);

        if(veiculo == null){
            throw new RuntimeException("Não foi encontrado um veículo com a placa " + placa + " informada");
        }

        veiculo.setDisponivel(disponibilidade);
        repository.atualizar(veiculo);
    }

    public boolean deletarVeiculo(String id){
        return repository.deletar(id);
    }

    public List<Veiculo> listarTodos(){
        return repository.listarTodos();
    }

    public List<Veiculo> listarVeiculosDisponiveis(){
        return repository.consultarVeiculosDisponiveis();
    }
}
