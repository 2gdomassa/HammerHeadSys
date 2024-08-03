
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.client;
import model.fileClientList;

public class controllerClientListTable {
    
    
    private static ArrayList<client> listOfClients = new ArrayList();    
   
    /* Metodo que recebe os dados do cliente, converte em objeto e 
    adiciona na lista posteriormente adicionando na tabela e recarregando o array
    Tambem recebe o metodo implementado na clientBase, utilizando a interface add_client_base */
        public static void convertClienteToObject(String name,String number,String address, add_client_table interfaceTable){
        client prototipe = new client(name,number,address,"0","0");
        addClient("teste.csv",prototipe);
        fileClientList.readAllLines("teste.csv",listOfClients);
        if(interfaceTable != null){
          interfaceTable.updateTable();
        }
        }
        
        /* Metodo que recebe o nome de um cliente e retorna o cliente especifico do array 
        Retorna null caso nao encontre */
        public static client searchClient(String nameClient){
             fileClientList.readAllLines("teste.csv",listOfClients);
             for (client c : listOfClients){
                 if(c.getName().equals(nameClient)){
                  return c;   
                 }
                }
             return null;
        }
       
        //Metodo pra adicionar uma linha na tabela Excel, usando os dados do cliente capturados com o metodo acima
        public static void addClient(String nameFile,client Costumer){
        fileClientList.insertLine(nameFile, Costumer);
        }
       
        /*
        Metodo pra atualizar a tabela, chamando a logica de leitura de arquivos contida no fileClientList pra popular o Array. 
        Sera chamada no front tambem, para atualizar a jTable 
         */    
    public static void updateJTable(JTable tableJpane){
            fileClientList.readAllLines("teste.csv", listOfClients);
            DefaultTableModel model =(DefaultTableModel)tableJpane.getModel();
            model.setRowCount(0); 
            for(client customer: listOfClients){
            Object[] row ={
            customer.getName(),
            customer.getNumber(),
            customer.getAdress(),
            customer.getNumberServices(),
            customer.getActiveServices()
                };
                model.addRow(row);
            }
            tableJpane.setModel(model);
        }
    
}
