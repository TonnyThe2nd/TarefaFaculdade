package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseManage {
    private Connection connect; 
    
    public DataBaseManage() throws SQLException{
        connection();
    }
    
    public Connection connection()throws SQLException{
        connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/CRUD?user=postgres&password=postgres");
        return connect;
        
    }
    
    public void insertValues(String name, String date, String email, String phoneNumber){
        try{
            String var = "SELECT * FROM Clientes WHERE nome = ? AND email = ?";
            PreparedStatement ps = connect.prepareStatement(var);
            ps.setString(1, name);
            ps.setString(2, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Usuário já cadastrado!!");
            }else{
                String script = "INSERT INTO Clientes(nome, data_nascimento, email, celular) VALUES(?,?,?,?);";
                PreparedStatement psInsert = connect.prepareStatement(script);
                System.out.println("Inserindo");
                psInsert.setString(1,name);
                psInsert.setString(2,date);
                psInsert.setString(3,email);
                psInsert.setString(4,phoneNumber);
                psInsert.execute();
                psInsert.close();
            }
        }catch(SQLException e){
            System.out.println("Erro no comando SQL!");
        }               
    }
    
    public void selectValue(String email){
        try{
            String var = "Select * from Clientes where email = '"+email+"';";
            PreparedStatement ps = connect.prepareStatement(var);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("ID: " + rs.getInt("id_cliente"));
                System.out.println("Cliente: " + rs.getString("nome"));
                System.out.println("E-mail: " + rs.getString("email"));
                System.out.println("Número: " + rs.getString("celular"));
                System.out.println("Data de nascimento: " + rs.getString("data_nascimento"));
            }
            else{
                System.out.println("Usuário não encontrado!");
            }
        }catch(SQLException e){
            System.out.println("Erro no comando SQL!");
        }    
    }
    
    public void deleteValues(String name, String email){
        try{
            String var = "Select * from Clientes where nome = '"+name+"' and email = '"+email+"';";
            PreparedStatement ps = connect.prepareStatement(var);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                System.out.println("Usuário Não encontrado!!");
            }else{
                String script = "INSERT FROM Clientes WHERE nome = (?) and email = (?)";
                ps = connect.prepareStatement(script);
                ps.setString(1,name);
                ps.setString(2, email);
                ps.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println("Erro no comando SQL!");
        }               
    }
    
}
