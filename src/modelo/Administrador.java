package modelo;

import dao.*;

public class Administrador extends Usuario {

    // Construtor da classe Administrador, chamando o construtor da superclasse
    // Usuario
    public Administrador(String nome, String cpf, String rg, String matricula, String email,
            int diaNasc, int mesNasc, int anoNasc, String nomeRua, String nomeBairro,
            String nomeCidade, int numeroCasa, String complemento, String numeroTelefone,
            String senha) {
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc,
                nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
    }

    // Métodos específicos do Administrador
    public void cadastrarProfessor(Professor p, ProfessorDAO pDAO) {
        pDAO.cadastrarProfessor(p);
        System.out.println("Professor " + p.getNome() + " cadastrado com sucesso!");
    }

    public void cadastrarAluno(Aluno a, AlunoDAO aDAO) {
        // aDAO.cadastrarAluno(a);
        System.out.println("Aluno " + a.getNome() + " cadastrado com sucesso!");
    }

    /*public void cadastrarDisciplina(Disciplina d, DisciplinaDAO dDAO) {
        dDAO.cadastrarDisciplina(d);
        System.out.println("Disciplina " + d.getNome() + " cadastrada com sucesso!");
    }*/

    // Você pode adicionar outros métodos de gerenciamento, como remover ou editar
    // registros
}
