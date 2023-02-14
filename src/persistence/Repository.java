package persistence;

import java.util.List;

public interface Repository<T> {
    T salvar(T entidade);

    void atualizar(T entidade);

    boolean deletar(String id);

    T consultar(String id);

    T consultarPorNome(String nome);

    List<T> consultarPorParteNome(String nome);

    List<T> listarTodos();
}
