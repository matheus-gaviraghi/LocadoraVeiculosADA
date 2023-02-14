package business;

import model.Cliente;
import model.PessoaFisica;
import model.Veiculo;
import persistence.ClienteEmMemoriaRepository;
import persistence.Repository;
import persistence.VeiculoRepository;

import java.util.List;

public class GerenciadorDeCliente <T extends Cliente> {
    private final ClienteEmMemoriaRepository repository;

    public GerenciadorDeCliente(ClienteEmMemoriaRepository repository){
        this.repository = repository;
    }

    public boolean existeCliente(String id){
        return repository.consultar(id) != null;
    }

    public void adicionarCliente(T cliente){

        if(existeCliente(cliente.getId())){
            throw new RuntimeException("Já existe um registro do tipo %s com o id %s".formatted(cliente.tipoDeCliente(), cliente.getId()));
        }

        repository.salvar(cliente);
    }

    public Cliente consultarPorNomeCadastro(String nome){
        return repository.consultarPorNome(nome);
    }

    public void editarCliente(String nome, String telefone){
        Cliente cliente = consultarPorNomeCadastro(nome);

        if(cliente == null){
            throw new RuntimeException("Não foi encontrado um cliente com o nome " + nome + " informado.");
        }

        cliente.setNomeCliente(nome);
        cliente.setTelefone(telefone);
        repository.atualizar(cliente);
    }

    public boolean deletarCliente(String id){
        return repository.deletar(id);
    }

    public List<Cliente> listarTodos(){
        return repository.listarTodos();
    }

    public List<Cliente> listarClientesPorParteNome(String nome){
        List<Cliente> listaClientes = repository.consultarPorParteNome(nome);

        if(listaClientes.isEmpty()){
            System.out.println("Não há clientes com nome similar à esse!");
            return null;
        }

        return listaClientes;
    }
}
