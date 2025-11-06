package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Administrador;
import modelo.Disciplina;
import modelo.Turma;

public class AdministradorDAO {

    private ArrayList<Administrador> listaAdministradores = new ArrayList<>();

    public ArrayList<Administrador> getAdministradores() {
    listaAdministradores.clear();
    try (BufferedReader leitor = new BufferedReader(new FileReader("adiministradores.txt"))) {
        String linha;
        while ((linha = leitor.readLine()) != null) {
            String[] dados = linha.split(";");

            Administrador administrador = new Administrador(
                dados[0], // nome
                dados[1], // cpf
                dados[2], // rg
                dados[3], // matricula
                dados[4], // email
                Integer.parseInt(dados[5]), // dia nasc
                Integer.parseInt(dados[6]), // mes nasc
                Integer.parseInt(dados[7]), // ano nasc
                dados[8], // rua
                dados[9], // bairro
                dados[10], // cidade
                Integer.parseInt(dados[11]), // número casa
                dados[12], // complemento
                dados[13], // telefone
                dados[14] // senha
            );

            listaAdministradores.add(administrador);
        }
    } catch (IOException e) {
        System.err.println("Erro ao ler arquivo: " + e.getMessage());
    }

    return listaAdministradores;
}
}
