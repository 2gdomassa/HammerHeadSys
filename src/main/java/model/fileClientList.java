
package model;
 /* Esta classe serve para lidar diretamente com o arquivo CSV. Ela fornece os metodos que serão utilizados no controlador */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class fileClientList {
            
    //Cria e verifica se o arquivo foi criado com sucesso
    static public boolean createFile(String nameFile){
        File ClientList = new File(nameFile);
     return ClientList.exists();
}
    
    //Cria o cabeçalho do arquivo utilizando a classe PrintWriter pra escrever no arquivo
    static public void createHeader(String nameFile){
        try (PrintWriter dataFileWriter = new PrintWriter(nameFile))
        { 
       dataFileWriter.println("Name;Number;Address;CompletedServices;ActiveServices");
        }
        catch(IOException e){    
            JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
        }
    }

    /* Método pra escrever uma linha recebendo as variaveis do objeto Costumer para cada celula
    Usa-se também FileWriter para que o arquivo não seja sobreescrito toda vez que o método é chamado */
    static public void insertLine(String nameFile,client Costumer){
        try(PrintWriter lineWriter = new PrintWriter(new FileWriter(nameFile,true)))
        {
        lineWriter.println(Costumer.getName()+";"+Costumer.getNumber()+";"+Costumer.getAdress()+";"+Costumer.getNumberServices()+";"+Costumer.getActiveServices());    
        }
        catch(Exception E){
        JOptionPane.showMessageDialog(null,"Erro: "+ E);
        }
    } 
    
    /* Metodo pra ler todas as linhas do arquivo Excel, recebendo o Array 
    contido no Controller como parametro e passando as linhas do .CSV como objetos para este Array */
    static public void readAllLines(String nameFile, ArrayList<client> listOfClientsss){
     if(!createFile(nameFile)){
         createFile(nameFile);
         createHeader(nameFile);
     }
        listOfClientsss.clear();
       int count=0;
        try(BufferedReader lineReader = new BufferedReader(new FileReader(nameFile))){      
            String line;
         
            while((line=lineReader.readLine())!=null){
            if(count>0){
                String[] varForObjLine = line.split(";");
            client objClient = new client(varForObjLine[0],varForObjLine[1],varForObjLine[2],varForObjLine[3],varForObjLine[4]);
            listOfClientsss.add(objClient); 
            } count++;
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro no método readAllLines: "+e.getMessage());   
        }
    }
}
   