package model;

public class Gerente extends Funcionario implements Gerencia {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Gerente: " + getNome() + ", Salário: " + getSalario());
    }
}