package data;

import model.Funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioData {

    private List<Funcionario> funcionarios;
    private final String FILE_PATH = "funcionarios.txt";

    public FuncionarioData() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(String nome) {
        return funcionarios.stream()
                .filter(f -> f.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarFuncionario(String nome, double novoSalario) {
        Funcionario funcionario = buscarFuncionario(nome);
        if (funcionario != null) {
            funcionario.setSalario(novoSalario);
            return true;
        }
        return false;
    }

    public boolean excluirFuncionario(String nome) {
        return funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Funcionario funcionario : funcionarios) {
                writer.write(funcionario.getClass().getSimpleName() + "," +
                             funcionario.getNome() + "," +
                             funcionario.getSalario());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void carregarDados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String tipo = dados[0];
                String nome = dados[1];
                double salario = Double.parseDouble(dados[2]);

                switch (tipo) {
                    case "Desenvolvedor":
                        adicionarFuncionario(new model.Desenvolvedor(nome, salario));
                        break;
                    case "Gerente":
                        adicionarFuncionario(new model.Gerente(nome, salario));
                        break;
                    case "Treinador":
                        adicionarFuncionario(new model.Treinador(nome, salario));
                        break;
                    case "GerenteDesenvolvedor":
                        adicionarFuncionario(new model.GerenteDesenvolvedor(nome, salario));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }
}
