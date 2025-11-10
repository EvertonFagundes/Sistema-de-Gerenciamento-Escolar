package modelo;

import dao.*;

public class Administrador extends Usuario {

    ProfessorDAO pDao = new ProfessorDAO();

    // Construtor da classe Administrador, chamando o construtor da superclasse
    // Usuario
    public Administrador(String nome, String cpf, String rg, String matricula, String email,
            int diaNasc, int mesNasc, int anoNasc, String nomeRua, String nomeBairro,
            String nomeCidade, int numeroCasa, String complemento, String numeroTelefone,
            String senha) {
        super(nome, cpf, rg, matricula, email, diaNasc, mesNasc, anoNasc, nomeRua, nomeBairro, nomeCidade, numeroCasa, complemento, numeroTelefone, senha);
        setPerfil("ADMIN");
    }

    // Métodos em relação ao Professor
    public void cadastrarProfessor(Professor p) {
        pDao.cadastrarProfessor(p);
    }

    public void editarProfessor(Professor p){
        pDao.editarProfessor(p, p.getMatricula());
    }

    public void getProfessores(){
        pDao.getProfessores();
    }

    public boolean buscarPorNome(String nome){
        if(pDao.buscarPorNome(nome)){
            return true;
        }else{
            return false;
        }
    }

    public boolean buscarPorCpf(String cpf){
        if(pDao.buscarPorCpf(cpf)){
            return true;
        }else{
            return false;
        }
    }

    public boolean buscarPorDisciplina(String nomeDisciplina, String matricula){
        if(pDao.buscarPorDisciplina(nomeDisciplina, matricula)){
            return true;
        }else{
            return false;
        }
    }

    public void adicionarDisciplinaAoProfessor(Disciplina disciplina, String matriculaProfessor){
        pDao.adicionarDisciplinaAoProfessor(disciplina, matriculaProfessor);
    }

    public void removerProfessor(Professor p){
        pDao.removerProfessor(p.getMatricula());
    }

    public void adicionarTurmasAoProfessor(Turma turma, String matriculaProfessor){
        pDao.adicionarTurmasAoProfessor(turma, matriculaProfessor);
    }

    public int calcularCargaHorariaPorDisciplinas(String matriculaProfessor){
        return pDao.calcularCargaHorariaPorDisciplinas(matriculaProfessor);
    }

    public int calcularCargaHorariaPorTurmas(String matriculaProfessor){
        return pDao.calcularCargaHorariaPorTurmas(matriculaProfessor);
    }

    // Métodos em relação ao Aluno
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
