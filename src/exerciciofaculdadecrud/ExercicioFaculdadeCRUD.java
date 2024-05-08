package exerciciofaculdadecrud;
import database.DataBaseManage;
import java.sql.SQLException;
import java.util.Scanner;

public class ExercicioFaculdadeCRUD {
    public static void main(String[] args) throws SQLException{
        DataBaseManage dbm = new DataBaseManage();
        Scanner sc = new Scanner(System.in);
        System.out.println("Comando: [1] Inserir \n[2] Pesquisar \n[3] Deletar");
        char escolha = sc.nextLine().charAt(0);
        switch (escolha) {
            case '1' ->{
                    System.out.println("Inserir Valores: ");
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    String date = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    System.out.print("Número de celular: ");
                    String phoneNumber = sc.nextLine();
                    dbm.insertValues(name, date, email, phoneNumber);
                }
            case '2' ->{
                    System.out.println("Selecionar: ");
                    System.out.print("E-mail: ");
                    String email = sc.nextLine();
                    dbm.selectValue(email);
                }
            case '3' ->{
                    System.out.println("Deletar: ");
                    System.out.print("Nome: ");
                    String name = sc.nextLine();
                    System.out.println("E-mail: ");
                    String email = sc.nextLine();
                    dbm.deleteValues(name, email);
                }
            default -> System.out.println("Opção inválida!!");
        }
        
    }
    
}
