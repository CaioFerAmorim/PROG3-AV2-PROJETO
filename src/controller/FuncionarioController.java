package controller;

import data.FuncionarioData;
import model.Funcionario;
import java.util.List;

public class FuncionarioController {

    private FuncionarioData funcionarioData;

    public FuncionarioController() {
        this.funcionarioData = new FuncionarioData();
    }

    public void iniciarSistema() {
        // Exemplo de lógica para inicializar o sistema
        // Carregar dados, preparar ambiente, etc.
        System.out.println("Sistema iniciado.");
        carregarFuncionarios();  // Exemplo de carregar os funcionários
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarioData.adicionarFuncionario(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioData.getFuncionarios();
    }

    public Funcionario buscarFuncionario(String nome) {
        return funcionarioData.buscarFuncionario(nome);
    }

    public boolean atualizarFuncionario(String nome, double novoSalario) {
        return funcionarioData.atualizarFuncionario(nome, novoSalario);
    }

    public boolean excluirFuncionario(String nome) {
        return funcionarioData.excluirFuncionario(nome);
    }

    public void salvarFuncionarios() {
        funcionarioData.salvarDados();
    }

    public void carregarFuncionarios() {
        funcionarioData.carregarDados();
    }
}