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
            escritor.write("    periodoLetivo: " + anoEscolar.getPeriodoLetivo() + ",\n");
            escritor.write("    codigo: " + anoEscolar.getCodigo() + "\n");
            escritor.write("}");
            escritor.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Exceção ao tentar criar Ano Escolar", "Erro ao criar Ano escolar", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
}
