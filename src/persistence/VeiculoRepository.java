package persistence;

import model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends Repository<Veiculo>{

    List<Veiculo> consultarVeiculosDisponiveis();

}
