import business.GerenciadorDeCliente;
import business.GerenciadorDeVeiculo;
import model.*;
import persistence.ClienteEmMemoriaRepository;
import persistence.VeiculoEmMemoriaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppLocadora {

    public static void main(String[] args) {

        System.out.println("##########################################");
        System.out.println("    Locadora de Veículos em JAVA");
        System.out.println("##########################################\n");

        // ###########################################################
        //                    Manipulação de veículos
        // ###########################################################
        VeiculoEmMemoriaRepository repositorioDeVeiculo = new VeiculoEmMemoriaRepository();
        GerenciadorDeVeiculo gerenciadorDeVeiculo = new GerenciadorDeVeiculo<>(repositorioDeVeiculo);

        // Criação dos veículos
        Veiculo carroPequeno1 = new Pequeno(2020, "FIAT", "Palio", "LWO-1445", 85_900.00, 1.6);
        Veiculo carroPequeno2 = new Pequeno(2023, "FIAT", "Argo", "IFO-1361", 1_200.00, 1.4);
        Veiculo carroPequeno3 = new Pequeno(2014, "VW", "Gol", "HTC-2711", 230_200.00, 1.0);
        Veiculo carroMedio1 = new Medio(2022, "Honda", "Civic", "MVN-4060", 8_900.00, 2.0);
        Veiculo carroMedio2 = new Medio(2021, "Toyota", "Corolla", "MTM-6755", 48_423.00, 2.0);
        Veiculo carroSUV = new SUV(2018, "Toyota", "SW4", "NBM-9199", 145_000.00, 2.8);

        // Registro dos veículos na Locadora
        gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno1);
        gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno2);
        gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno3);
        gerenciadorDeVeiculo.adicionarVeiculo(carroMedio1);
        gerenciadorDeVeiculo.adicionarVeiculo(carroMedio2);
        gerenciadorDeVeiculo.adicionarVeiculo(carroSUV);

        System.out.println("Veículos registrados:");
        gerenciadorDeVeiculo.listarTodos().forEach(System.out::println);;

        // Supondo que o carroPequeno3 esteja em manutenção
        carroPequeno3.setDisponivel(false);

        System.out.println("\nVeiculos disponíveis para alugar:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);;

        // Descomente abaixo para testar a adição de um mesmo veículo novamente no registro
        // gerenciadorDeVeiculo.adicionarVeiculo(carroPequeno3);

        // ###########################################################
        //                    Manipulação de clientes
        // ###########################################################
        ClienteEmMemoriaRepository repositorioDeCliente = new ClienteEmMemoriaRepository();
        GerenciadorDeCliente gerenciadorDeCliente = new GerenciadorDeCliente<>(repositorioDeCliente);

        // Criação das pessoas
        PessoaFisica pessoaFisica1 = new PessoaFisica("Matheus Gaviraghi", "(11) 50664-4788", LocalDate.of(2000, Month.OCTOBER, 16), "213.290.110-40");
        PessoaFisica pessoaFisica2 = new PessoaFisica("José Afonso", "(21) 41425-9861", LocalDate.of(1991, Month.FEBRUARY, 15), "657.649.090-90");
        PessoaJuridica pessoaJuridica1 = new PessoaJuridica("La Casa de Pastel", "(95) 74279-1717",LocalDate.of(2020, Month.FEBRUARY, 1), "22.203.472/0001-84");
        PessoaJuridica pessoaJuridica2 = new PessoaJuridica("Posto VemDiesel", "(88) 66072-3880",LocalDate.of(2005, Month.JANUARY, 7), "38.609.904/0001-91");
        PessoaJuridica pessoaJuridica3 = new PessoaJuridica("Rapaduras do Zé", "(51) 33262-9044",LocalDate.of(2000, Month.NOVEMBER, 10), "11.894.916/0001-59");

        // Registro dos clientes
        gerenciadorDeCliente.adicionarCliente(pessoaFisica1);
        gerenciadorDeCliente.adicionarCliente(pessoaFisica2);
        gerenciadorDeCliente.adicionarCliente(pessoaJuridica1);
        gerenciadorDeCliente.adicionarCliente(pessoaJuridica2);
        gerenciadorDeCliente.adicionarCliente(pessoaJuridica3);

        System.out.println("\nClientes registrados: ");
        gerenciadorDeCliente.listarTodos().forEach(System.out::println);

        // Descomente abaixo para testar a adição de um mesmo cliente no registro
        // gerenciadorDeCliente.adicionarCliente(pessoaFisica1);

        // ###########################################################
        //                    Manipulação de locações
        // ###########################################################
        List<Locacao> registroDeLocacoes = new ArrayList<>();

        // Alugando veículos
        Locacao locacaoPF1 = new Locacao(pessoaFisica1);
        registroDeLocacoes.add(locacaoPF1);
        locacaoPF1.alugar(carroMedio1, LocalDateTime.of(2023, 2, 12, 01, 16, 30), "São Paulo");

        // Mostrando carros disponíveis após essa locação
        System.out.println("\nVeiculos disponíveis após o carro M-0 ser alugado:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        // Mostrando lista de locações
        System.out.println("\nLista de locações:");
        registroDeLocacoes.forEach(System.out::println);

        // Devolução do veículo
        locacaoPF1.devolver(LocalDateTime.of(2023, 2, 12, 01, 16, 30), "Porto Alegre");

        // Mostrando lista de locações após devolução do veículo
        System.out.println("\nLista de locações após devolução do veículo M-0:");
        registroDeLocacoes.forEach(System.out::println);

        // Mostrando veículos disponíveis após a devolução
        System.out.println("\nVeiculos disponíveis após o carro M-0 ser devolvido:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        // Realizando o aluguel de todos os veículos
        System.out.println("\nRealizando o aluguel de todos os veículos:");
        locacaoPF1.alugar(carroPequeno1, LocalDateTime.of(2023, 2, 12, 01, 15, 00), "Florianópolis");

        Locacao locacaoPF2 = new Locacao(pessoaFisica2);
        locacaoPF2.alugar(carroMedio2, LocalDateTime.of(2023, 2, 12, 01, 15, 00), "Jaraguá do Sul");
        registroDeLocacoes.add(locacaoPF2);

        Locacao locacaoPJ1 = new Locacao(pessoaJuridica1);
        locacaoPJ1.alugar(carroSUV, LocalDateTime.of(2023, 2, 12, 01, 15, 00), "Belo Horizonte");
        registroDeLocacoes.add(locacaoPJ1);

        Locacao locacaoPJ2 = new Locacao(pessoaJuridica2);
        locacaoPJ2.alugar(carroMedio1, LocalDateTime.of(2023, 2, 12, 01, 15, 00), "Marau");
        registroDeLocacoes.add(locacaoPJ2);

        Locacao locacaoPJ3 = new Locacao(pessoaJuridica3);
        locacaoPJ3.alugar(carroPequeno2, LocalDateTime.of(2023, 2, 12, 01, 15, 00), "Santa Rosa");
        registroDeLocacoes.add(locacaoPJ3);

        // Mostrando todas as locações registradas
        System.out.println("\nLista de locações:");
        registroDeLocacoes.forEach(System.out::println);

        // Devolvendo veículos e mostrando lista de veículos disponíves a cada devolução
        locacaoPF1.devolver(LocalDateTime.of(2023, 2, 15, 01, 16, 30), "Tuparendi");
        System.out.println("\nVeículos disponíveis para locação:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        locacaoPF2.devolver(LocalDateTime.of(2023, 2, 17, 01, 16, 30), "Giruá");
        System.out.println("\nVeículos disponíveis para locação:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        locacaoPJ1.devolver(LocalDateTime.of(2023, 3, 21, 01, 16, 30), "Santa Bárbara do Sul");
        System.out.println("\nVeículos disponíveis para locação:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        locacaoPJ2.devolver(LocalDateTime.of(2023, 4, 18, 01, 16, 30), "Goiânia");
        System.out.println("\nVeículos disponíveis para locação:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

        locacaoPJ3.devolver(LocalDateTime.of(2023, 6, 17, 01, 16, 30), "Santos");
        System.out.println("\nVeículos disponíveis para locação:");
        gerenciadorDeVeiculo.listarVeiculosDisponiveis().forEach(System.out::println);

    }
}
