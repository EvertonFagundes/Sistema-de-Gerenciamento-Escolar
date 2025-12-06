package dao;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import modelo.AnoEscolar;

public class AnoEscolarDAO {
    public static void criarAnoEscolar(AnoEscolar anoEscolar){
        File diretorio = new File("banco/AnosEscolares/");
        if(!diretorio.isDirectory()){
            diretorio.mkdirs();
        }
        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + anoEscolar.getCodigo()+ ".txt");
        if(arquivo.isFile()){
            JOptionPane.showMessageDialog(null, "Ano escolar já existente!", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
        }else{
            try(FileWriter escritor = new FileWriter(arquivo.getPath(), false)){
            escritor.write("AnoEscolar :{\n");
            escritor.write("    ano: " + anoEscolar.getAno() + ",\n");
            escritor.write("    periodoLetivo: [");

            for(int i=0; i<anoEscolar.getPeriodoLetivo().size(); i++){
                if(i == 0){
                    escritor.write(anoEscolar.getPeriodoLetivo().get(i).getNome());
                }else{
                    escritor.write(", " + anoEscolar.getPeriodoLetivo().get(i).getNome());
                }
            }
            escritor.write("]\n");
            escritor.write("    codigo: " + anoEscolar.getCodigo() + "\n");
            escritor.write("}");
            escritor.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exceção ao tentar criar Ano Escolar", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static boolean verificaAnoEscolar(String codigo){
        File arquivo = new File("banco/AnosEscolares/ANOESCOLAR" + codigo + ".txt");
        if(arquivo.isFile()){
            return true;
        }else{
            return false;
        }
    }

    
}
