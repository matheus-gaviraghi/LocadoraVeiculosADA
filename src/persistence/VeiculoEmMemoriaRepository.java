package persistence;

import model.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoEmMemoriaRepository extends RepositoryEmMemoriaGenerico<Veiculo> implements VeiculoRepository {

    @Override
    public List<Veiculo> consultarVeiculosDisponiveis() {

        List<Veiculo> veiculosDisponiveis = new ArrayList<>();

        for (Veiculo veiculo: listarTodos()){
            if(veiculo.isDisponivel()){
                veiculosDisponiveis.add(veiculo);
            }
        }
        return veiculosDisponiveis;

        // Usando stream:
        /*return listarTodos().stream()
                .filter(veiculo -> veiculo.isDisponivel())
                .collect(Collectors.toList());*/
    }
}
