package persistence;

import model.Entidade;

import java.util.ArrayList;
import java.util.List;

public class RepositoryEmMemoriaGenerico<T extends Entidade> implements Repository<T> {

    private final List<T> dados;

    public RepositoryEmMemoriaGenerico() {
        this.dados = new ArrayList<>();
    }

    @Override
    public T salvar(T entidade) {
        if (existe(entidade)) {
            throw new IllegalArgumentException("Já existe uma entidade com esse id cadastrado");
        }
        dados.add(entidade);
        return entidade;
    }

    private boolean existe(T entidade) {
        String id = entidade.getId();
        return existe(id);
    }

    private boolean existe(String id) {
        return consultar(id) != null;
    }

    @Override
    public void atualizar(T entidade) {
        if (!existe(entidade)) {
            throw new IllegalArgumentException("Não existe uma entidade com esse ID cadastrado para atualizar");
        }

        deletar(entidade.getId());
        salvar(entidade);
    }

    @Override
    public boolean deletar(String id) {
        if (existe(id)) {
            T consultar = consultar(id);
            dados.remove(consultar);
            return true;
        }
        return false;
    }

    @Override
    public T consultar(String id) {
        for (T entidade: dados) {
            if (entidade.getId().equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public T consultarPorNome(String nomeCadastro) {
        for (T entidade: dados) {
            if (entidade.getNomeCadastro().equals(nomeCadastro)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public List<T> consultarPorParteNome(String nome) {
        int tamanhoNome = nome.length();
        List<T> listaDeObjetosEncontrados = new ArrayList<>();

        for (T entidade: dados) {
            String nomeCadastro = entidade.getNomeCadastro();
            if(tamanhoNome <= nomeCadastro.length()) {
                if (nomeCadastro.substring(0, tamanhoNome).equals(nome)) {
                    listaDeObjetosEncontrados.add(entidade);
                }
            }
        }
        return listaDeObjetosEncontrados;
    }


    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(dados);
    }
}