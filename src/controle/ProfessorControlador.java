package controle;
import java.util.ArrayList;
import modelo.Professor;
import modelo.Disciplina;

public class ProfessorControlador {
    public Professor criarProfessor(String nome, String cpf, String rg, String matricula,
     String email, int diaNascimento, int mesNascimento, int anoNascimento, String rua,
     String bairro, String cidade, int numeroCasa, String complemento, String telefone,
     String senha, String nivelAcesso, ArrayList<Disciplina> disciplinasLecionadas){
        return new Professor(nome, cpf, rg, matricula, email, diaNascimento,
         mesNascimento, anoNascimento, rua, bairro, cidade, numeroCasa, complemento,
         telefone, senha, nivelAcesso, disciplinasLecionadas);
     }
}
