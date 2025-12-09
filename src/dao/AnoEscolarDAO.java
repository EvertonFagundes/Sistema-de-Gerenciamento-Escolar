package dao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;
import modelo.AnoEscolar;
import modelo.PeriodoLetivo;
import modelo.Professor;

public class AnoEscolarDAO {
    public static void criarAnoEscolar(AnoEscolar anoEscolar){
        File diretorio = new File("banco/AnosEscolares/");
        if(!diretorio.isDirectory()){
            diretorio.mkdirs();
        }

        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + anoEscolar.getAno() + ".txt");

        if(arquivo.isFile()){
            JOptionPane.showMessageDialog(null, "Ano escolar já existente!", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
        } else {
            try(FileWriter escritor = new FileWriter(arquivo.getPath(), false)){

                escritor.write("AnoEscolar :{\n");
                escritor.write("    ano: " + anoEscolar.getAno() + ",\n");

                escritor.write("    periodoLetivo: [");
                for(int i=0; i<anoEscolar.getPeriodoLetivo().size(); i++){
                    if(i == 0){
                        escritor.write(anoEscolar.getPeriodoLetivo().get(i).getNome());
                    } else {
                        escritor.write(", " + anoEscolar.getPeriodoLetivo().get(i).getNome());
                    }
                }
                escritor.write("],\n");

                escritor.write("    codigo: " + anoEscolar.getCodigo() + ",\n");
                escritor.write("    situacao: " + anoEscolar.getSituacao() + "\n");
                escritor.write("}");

                JOptionPane.showMessageDialog(null, "Ano Escolar criado com sucesso!","Sucesso", JOptionPane.INFORMATION_MESSAGE);

            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exceção ao tentar criar Ano Escolar", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    public static AnoEscolar getAnoEscolar(String ano){
        AnoEscolar anoEscolar = new AnoEscolar();
        String periodoLetivoTxt;
        ArrayList<PeriodoLetivo> periodosLetivos = new ArrayList<>();

        try{
            Map<String, String> dados = Services.lerDados("banco/AnosEscolares/ANOESCOLAR" + ano + ".txt");

            anoEscolar.setAno(Integer.parseInt(dados.get("ano")));

            periodoLetivoTxt = dados.get("periodoLetivo").replace("[", "").replace("]", "");

            String[] periodoLetivoPartes = periodoLetivoTxt.split(",");

            for (String periodoLetivo : periodoLetivoPartes) {
                PeriodoLetivo p = new PeriodoLetivo();
                p.setNome(periodoLetivo.trim());
                periodosLetivos.add(p);
            }

            String codigo = dados.get("codigo");

            anoEscolar.setPeriodoLetivo(periodosLetivos);
            anoEscolar.setCodigo(codigo);
            anoEscolar.setSituacao(Boolean.parseBoolean(dados.get("situacao")));

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao ler professor", "Erro ao ler professor", JOptionPane.WARNING_MESSAGE);
        }

        return anoEscolar;
    }


    public static boolean verificaAnoEscolar(String ano){
        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + ano + ".txt");
        if(arquivo.isFile()){
            return true;
        }else{
            return false;
        }
    }

    public static AnoEscolar buscarPorCodigo(String codigo){
        ArrayList<AnoEscolar> anosEscolares = listarTodos();
        AnoEscolar anoEscolar = new AnoEscolar();
        for(AnoEscolar a : anosEscolares){
            if(a.getCodigo().equals(codigo)){
                anoEscolar = a;
            }
        }
        return anoEscolar;
    }
    public static void atualizarAnoEscolar(AnoEscolar anoEscolar){
        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + anoEscolar.getAno() + ".txt");
        try(FileWriter escritor = new FileWriter(arquivo.getPath(), false)){
            escritor.write("AnoEscolar :{\n");
            escritor.write("    ano: " + anoEscolar.getAno() + ",\n");

            escritor.write("    periodoLetivo: [");
            for(int i=0; i<anoEscolar.getPeriodoLetivo().size(); i++){
                if(i == 0){
                    escritor.write(anoEscolar.getPeriodoLetivo().get(i).getNome());
                } else {
                    escritor.write(", " + anoEscolar.getPeriodoLetivo().get(i).getNome());
                }
            }
            escritor.write("],\n");

            escritor.write("    codigo: " + anoEscolar.getCodigo() + ",\n");
            escritor.write("    situacao: " + anoEscolar.getSituacao() + "\n");
            escritor.write("}");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Exceção ao tentar atualizar Ano Escolar", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean excluirAnoEscolar(int ano) {
        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + ano + ".txt");
        if (arquivo.exists() && arquivo.isFile()) {
            return arquivo.delete();
        }
        return false;
    }



    public static ArrayList<AnoEscolar> listarTodos(){
        ArrayList<AnoEscolar> lista = new ArrayList<>();

        File pasta = new File("banco/AnosEscolares/");
        File[] arquivos = pasta.listFiles();

        if (arquivos == null) return lista;

        for (File f : arquivos) {
            if (f.getName().startsWith("ANOESCOLAR") && f.getName().endsWith(".txt")) {

                String nomeArq = f.getName();
                String ano = nomeArq.replace("ANOESCOLAR", "").replace(".txt", "");

                //System.out.println("ano listar(): " + ano);
                
                AnoEscolar anoEscolar = getAnoEscolar(ano);
                System.out.println("objeto getAnoEscolar(): " + anoEscolar.getAno());

                lista.add(anoEscolar);
            }
        }

        return lista;
    }

}
