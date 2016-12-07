import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class DataBase {
	
	private static Connection conn;
//========================================================================================================================================================
	public DataBase() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://192.168.0.110:3306/tokokom","KELVIN","dJYrPCE7wMmJeeUS");
	}
//========================================================================================================================================================
	public boolean isConnected(){
		return (conn!=null);
	}
//========================================================================================================================================================
	
	public void insertData(String string,String string2,String string3,String string4 ,String string5 )throws SQLException{
		String query="INSERT INTO barang_toko(Kode_Barang,Nama_Barang,Banyak_Barang,Tipe_Barang,Harga_Barang) VALUES(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, string);
		stmt.setString(2, string2);
		stmt.setString(3,string3);
		stmt.setString(4, string4);
		stmt.setString(5, string5);
		stmt.execute();
		stmt.close();
	}
	
//========================================================================================================================================================
	
	public Vector<Vector<Object>> selectData()throws SQLException{
		String query = "SELECT * FROM barang_toko";
		Statement stmt= conn.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while(rs.next()){
			Vector<Object> e = new Vector<Object>();
			e.add(rs.getString("Kode_Barang"));
			e.add(rs.getString("Nama_Barang"));
			e.add(rs.getInt("Banyak_Barang"));
			e.add(rs.getString("Tipe_Barang"));
			e.add(rs.getInt("Harga_Barang"));
			data.add(e);
		}
		stmt.close();
		return data;
	}
	
//========================================================================================================================================================
	
	public void updateData(String string,String string2,String string3,String string4 ,String string5)throws SQLException{
		String query = "UPDATE barang_toko SET Nama_Barang = ? , Banyak_Barang = ? , Tipe_Barang = ? , Harga_Barang = ? WHERE Kode_Barang = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, string);
		stmt.setString(2, string2);
		stmt.setString(3,string3);
		stmt.setString(4, string4);
		stmt.setString(5, string5);
		stmt.execute();
		stmt.close();
	}
//========================================================================================================================================================
	public void updateBanyak(String banyak,String kode)throws SQLException{
		
		String query = "UPDATE barang_toko SET  Banyak_Barang =? WHERE Kode_Barang = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, banyak);
		stmt.setString(2, kode);
		stmt.execute();
		stmt.close();
	}
//========================================================================================================================================================
	public void DeleteData(String nama)throws SQLException{
		String query = "DELETE FROM barang_toko Where Kode_Barang = ? ";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, nama);
		stmt.execute();
		stmt.close();
	}
	
//========================================================================================================================================================
	
	public void insertDataPembeli(String string,String string2,String string3,String string4 ,String string5,String string6,String string7,String string8 ,String string9)throws SQLException{
		String query="INSERT INTO costumer(Kode_Barang,Nama,Alamat,Kode_Pos,Email,Telp,Nama_Barang,Banyak_Barang,Harga) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, string);
		stmt.setString(2, string2);
		stmt.setString(3,string3);
		stmt.setString(4, string4);
		stmt.setString(5, string5);
		stmt.setString(6, string6);
		stmt.setString(7, string7);
		stmt.setString(8, string8);
		stmt.setString(9, string9);
		stmt.execute();
		stmt.close();
	}
	

//========================================================================================================================================================
@SuppressWarnings("deprecation")

public boolean login(JTextField textField_1,JPasswordField passwordField) throws SQLException {
   try{            
       PreparedStatement pst = conn.prepareStatement("Select * from admin where admin_id=? and pass=?");
       pst.setString(1, textField_1.getText()); 
       pst.setString(2, passwordField.getText());
       ResultSet rs = pst.executeQuery();                        
       if(rs.next()) {  
    	   pst.close();
    	   JOptionPane.showMessageDialog(null, " Selamat datang ");
           return true; }   
       else{
    	   pst.close();
    	   JOptionPane.showMessageDialog(null, "User name atau password salah");
           return false;
           }
      
   }
   catch(Exception e){
       e.printStackTrace();
       return false;
   }       
}

//========================================================================================================================================================
public Vector<Vector<Object>> selectDataPembeli()throws SQLException{
	String query = "SELECT * FROM costumer";
	Statement stmt= conn.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	while(rs.next()){
		Vector<Object> e = new Vector<Object>();
		e.add(rs.getInt("Nomor"));
		e.add(rs.getString("Kode_Barang"));
		e.add(rs.getString("Nama"));
		e.add(rs.getString("Alamat"));
		e.add(rs.getInt("Kode_Pos"));
		e.add(rs.getString("Email"));
		e.add(rs.getString("Telp"));
		e.add(rs.getString("Nama_Barang"));
		e.add(rs.getInt("Banyak_Barang"));
		e.add(rs.getInt("Harga"));
		data.add(e);
	}
	stmt.close();
	return data;
}
//======================================HARGA BARANG======================================================================================================
public String selectHarga(String string)throws SQLException{
	String Harga=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Harga_Barang FROM barang_toko Where Kode_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  Harga = rs.getString("Harga_Barang");
		 
		}
	stmt.close();
	return Harga;
}
//========================================================================================================================================================
public String selectType(String text) throws SQLException{
	// TODO Auto-generated method stub
	String Nama=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Tipe_Barang FROM barang_toko Where Kode_Barang = ?");
	stmt.setString(1, text);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		
		  Nama = rs.getString("Tipe_Barang");
		 
		}
	stmt.close();
	return Nama;
	
}
//==========================NAMA BARANG===================================================================================================================
public String selectNama(String text) throws SQLException{
	// TODO Auto-generated method stub
	String Nama=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Nama_Barang FROM barang_toko Where Kode_Barang = ?");
	stmt.setString(1, text);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		
		  Nama = rs.getString("Nama_Barang");
		 
		}
	stmt.close();
	return Nama;
	
}
//================BANYAK BARANG ==========================================================================================================================
public String selectBanyak(String string)throws SQLException{
	String banyak=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Banyak_Barang FROM barang_toko Where Kode_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  banyak = rs.getString("Banyak_Barang");
		 
		}
	stmt.close();
	return banyak;
}

//========================================================================================================================================================

//========================================================================================================================================================
//=======================TIPE BARANG 1 ===================================================================================================================
public String selectTipe(String string)throws SQLException{
	String tipe=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Tipe_Barang FROM barang_toko Where Nama_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  tipe = rs.getString("Tipe_Barang");
		 
		}
	stmt.close();
	return tipe;
}
//==================================KODE BARANG 1 ========================================================================================================
public String selectKODE(String string)throws SQLException{
	String kode=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Kode_Barang FROM barang_toko Where Nama_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  kode = rs.getString("Kode_Barang");
		 
		}
	stmt.close();
	return kode;
}
//======================================HARGA BARANG 1====================================================================================================
public String selectHargaFrame(String string)throws SQLException{
	String Harga=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Harga_Barang FROM barang_toko Where Nama_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  Harga = rs.getString("Harga_Barang");
		 
		}
	stmt.close();
	return Harga;
}

//================BANYAK BARANG 1 ========================================================================================================================
public String selectBanyakFrame(String string)throws SQLException{
	String banyak=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Banyak_Barang FROM barang_toko Where Nama_Barang = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  banyak = rs.getString("Banyak_Barang");
		 
		}
	stmt.close();
	return banyak;
}
//===========================================================QURY BUAT PELANGAN===========================================================================
//========================================================================================================================================================
//========================================================================================================================================================
public String CariKodeBar(String string)throws SQLException{
	String banyak=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Kode_Barang FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  banyak = rs.getString("Kode_Barang");
		 
		}
	stmt.close();
	return banyak;
}

//========================================================================================================================================================
public String CariNama(String string)throws SQLException{
	String banyak=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Nama FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  banyak = rs.getString("Nama");
		 
		}
	stmt.close();
	return banyak;
}
//========================================================================================================================================================
public String CariAlamat(String string)throws SQLException{
	String banyak=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Alamat FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  banyak = rs.getString("Alamat");
		 
		}
	stmt.close();
	return banyak;
}
//========================================================================================================================================================
public String CariKodePos(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Kode_Pos FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Kode_Pos");
		 
		}
	stmt.close();
	return a;
}
//========================================================================================================================================================
public String CariEmail(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Email FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Email");
		 
		}
	stmt.close();
	return a;
}
//========================================================================================================================================================
public String CariTelp(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Telp FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Telp");
		 
		}
	stmt.close();
	return a;
}
//========================================================================================================================================================
public String CariNamaBarang(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Nama_Barang FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Nama_Barang");
		 
		}
	stmt.close();
	return a;
}
//========================================================================================================================================================
public String CariBanyakBarang(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Banyak_Barang FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Banyak_Barang");
		 
		}
	stmt.close();
	return a;
}
//========================================================================================================================================================
public String CariBiaya(String string)throws SQLException{
	String a=null ;
	PreparedStatement stmt = conn.prepareStatement("SELECT Harga FROM costumer Where Nomor = ?");
	stmt.setString(1, string);  
	ResultSet rs=stmt.executeQuery();
	
	while (rs.next()) {
		  a = rs.getString("Harga");
		 
		}
	stmt.close();
	return a;
}
//==================================UPDATE PEMBELI========================================================================================================
public void updatePembeli(String string,String string2,String string3,String string4 ,String string5,String string6,String string7,String string8,String string9,String string10)throws SQLException{
	String query = "UPDATE costumer SET Kode_Barang=?,Nama=?,Alamat=?,Kode_Pos=?,Email=?,Telp=?,Nama_Barang=?,Banyak_Barang=?,Harga=? WHERE Nomor = ?";
	PreparedStatement stmt = conn.prepareStatement(query);
	stmt.setString(1, string);
	stmt.setString(2, string2);
	stmt.setString(3,string3);
	stmt.setString(4, string4);
	stmt.setString(5, string5);
	stmt.setString(6, string6);
	stmt.setString(7, string7);
	stmt.setString(8, string8);
	stmt.setString(9, string9);
	stmt.setString(10, string10);
	
	stmt.execute();
	stmt.close();
}
//==============================Delete Pembeli============================================================================================================
public void DeletePembeli(String a)throws SQLException{
	String query = "DELETE FROM costumer Where Nomor = ? ";
	PreparedStatement stmt = conn.prepareStatement(query);
	stmt.setString(1, a);
	stmt.execute();
	stmt.close();
}
//========================================================================================================================================================


}