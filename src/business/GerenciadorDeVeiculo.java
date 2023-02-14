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

        if(existeVeiculo(veiculo.getId())){
            throw new RuntimeException("Já existe um registro de veículo do tipo %s com a placa %s".formatted(veiculo.tipoDeVeiculo(), veiculo.getPlaca()));
        }

        repository.salvar(veiculo);
    }

    public boolean existeVeiculo(String placa){
        return repository.consultar(placa) != null;
    }

    public Veiculo consultarPorNomeCadastro(String idTipoVeiculo){
        return repository.consultarPorNome(idTipoVeiculo);
    }

    public void editarVeiculo(String idTipoVeiculo, boolean disponibilidade){
        Veiculo veiculo = consultarPorNomeCadastro(idTipoVeiculo);

        if(veiculo == null){
            throw new RuntimeException("Não foi encontrado um veículo com o identificador " + idTipoVeiculo + " informado.");
        }

        veiculo.setDisponivel(disponibilidade);
        repository.atualizar(veiculo);
    }

    public boolean deletarVeiculo(String id){
        return repository.deletar(id);
    }

    public List<Veiculo> listarTodos(){
        List<Veiculo> lista = repository.listarTodos();

        if(lista.isEmpty()){
            System.out.println("Lista de veículos vazia!");
            return null;
        }

        return lista;
    }

    public List<Veiculo> listarVeiculosDisponiveis(){
        List<Veiculo> listaDisponiveis = repository.consultarVeiculosDisponiveis();

        if(listaDisponiveis.isEmpty()){
            System.out.println("Lista de veículos disponíveis vazia!");
            return null;
        }

        return listaDisponiveis;
    }

    public List<Veiculo> listarVeiculosPorParteNome(String nome){
        List<Veiculo> listaVeiculos = repository.consultarPorParteNome(nome);

        if(listaVeiculos.isEmpty()){
            System.out.println("Não há veículos com nome similar à esse!");
            return null;
        }

        return listaVeiculos;
    }
}
