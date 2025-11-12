package controle;

import dao.ProfessorDAO;
import modelo.Disciplina;
import modelo.Professor;
import modelo.Turma;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProfessor {
    private static final ProfessorDAO professorDAO = new ProfessorDAO();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Buscar Professor");
            System.out.println("4. Adicionar Disciplina ao Professor");
            System.out.println("5. Remover Disciplina do Professor");
            System.out.println("6. Adicionar Turma ao Professor");
            System.out.println("7. Ver Carga Horária Total");
            System.out.println("8. Remover Professor");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");

            opcao = lerInt();

            switch (opcao) {
                case 1 -> cadastrarProfessor();
                case 2 -> listarProfessores();
                case 3 -> buscarProfessor();
                case 4 -> adicionarDisciplina();
                case 5 -> removerDisciplina();
                case 6 -> adicionarTurma();
                case 7 -> verCargaHoraria();
                case 8 -> removerProfessor();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("RG: ");
        String rg = sc.nextLine();
        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();

        Professor professor = new Professor(nome, cpf, rg, matricula, email,
                0, 0, 0, "", "", "", 0, "", "", "", "");

        professor.setDisciplinasLeciona(new ArrayList<>());
        professor.setTurmasLeciona(new ArrayList<>());

        professorDAO.cadastrarProfessor(professor);
    }

    private static void listarProfessores() {
        ArrayList<Professor> professores = professorDAO.getProfessores();
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Professores ---");
        for (Professor p : professores) {
            System.out.println("Nome: " + p.getNome() + " | Matrícula: " + p.getMatricula());
        }
    }

    private static void buscarProfessor() {
        System.out.print("Digite a matrícula: ");
        String matricula = sc.nextLine();

        if (!professorDAO.verificarProfessor(matricula)) {
            System.out.println("Professor não encontrado.");
            return;
        }

        Professor p = professorDAO.getProfessor(matricula);
        System.out.println("\n--- Dados do Professor ---");
        System.out.println("Nome: " + p.getNome());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Email: " + p.getEmail());
        System.out.println("Disciplinas: " + p.getDisciplinasLeciona());
        System.out.println("Turmas: " + p.getTurmasLeciona());
    }

    private static void adicionarDisciplina() {
        System.out.print("Matrícula do professor: ");
        String matricula = sc.nextLine();

        System.out.print("Nome da disciplina: ");
        String nome = sc.nextLine();

        System.out.print("Código da disciplina: ");
        String codigo = sc.nextLine();

        System.out.print("Carga horária: ");
        int carga = lerInt();

        Disciplina d = new Disciplina(nome, codigo, null, carga);
        professorDAO.adicionarDisciplinaAoProfessor(d, matricula);
    }

    private static void removerDisciplina() {
        System.out.print("Matrícula do professor: ");
        String matricula = sc.nextLine();

        System.out.print("Nome ou código da disciplina a remover: ");
        String id = sc.nextLine();

        professorDAO.removerDisciplinaProfessor(matricula, id);
    }

    private static void adicionarTurma() {
        System.out.print("Matrícula do professor: ");
        String matricula = sc.nextLine();

        System.out.print("Ano da turma: ");
        int ano = lerInt();

        System.out.print("Identificador (ex: A, B, C): ");
        String id = sc.nextLine();

        Turma t = new Turma(ano, id);
        professorDAO.adicionarTurmasAoProfessor(t, matricula);
    }

    private static void verCargaHoraria() {
        System.out.print("Matrícula do professor: ");
        String matricula = sc.nextLine();

        int carga = professorDAO.calcularCargaHorariaPorDisciplinas(matricula);
        int cargaTotal = professorDAO.calcularCargaHorariaPorTurmas(matricula);

        System.out.println("Carga Horária por Disciplinas: " + carga);
        System.out.println("Carga Horária Total (disciplinas x turmas): " + cargaTotal);
    }

    private static void removerProfessor() {
        System.out.print("Matrícula do professor: ");
        String matricula = sc.nextLine();
        professorDAO.removerProfessor(matricula);
    }

    private static int lerInt() {
        while (true) {
            try {
                String entrada = sc.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Digite um número válido: ");
            }
        }
    }
}
