import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DataAdmin extends JFrame {
	
   	private static final long serialVersionUID = 1L;
// create table=======================================================================================
   	
   		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
   		String ids,places = new String();
   		String a = new String();
   		String b = new String();
   		String c = new String();
   		JTextField txtKode,txtNama,txtBanyak,txtTipe,txtnom;
   		private JMenuBar menuBar;
   		private JMenu mnNewMenu;
   		private JMenuItem mntmCustomer;
   		private JMenuItem mntmClose;
   		private JTextField txtHarga;
//==================================================================================================
    DataAdmin() {
    	getContentPane().setBackground(Color.WHITE);
    	setBackground(Color.WHITE);
        try {
            DataBase db = new DataBase();
            data = db.selectData();
        	}
        catch (Exception e) {
        	e.printStackTrace();
        	}
        //---------------------------------------------------------------------------------------------------------------
        setTitle("Welcome to TokoKom Karya Megah");
        setSize(600, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 196, 584, 155);
        
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("Produk");
        columnNames.add("Kode barang");
        columnNames.add("Tipe");
        columnNames.add("Banyak");
        columnNames.add("harga");
      
        JTable table = new JTable(data, columnNames);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(0, 0, 584, 196);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                ids=((table.getValueAt(table.getSelectedRow(), 0).toString()));
                a=((table.getValueAt(table.getSelectedRow(), 1).toString()));
                b=((table.getValueAt(table.getSelectedRow(), 2).toString()));
                c=((table.getValueAt(table.getSelectedRow(), 3).toString()));
                places=((table.getValueAt(table.getSelectedRow(), 4).toString()));
            }
        });
		
		JLabel lbl_kode = new JLabel("Kode Barang");
		lbl_kode.setBounds(6, 17, 286, 25);
		JLabel lbl_Nama = new JLabel("Nama Barang");
		lbl_Nama.setBounds(6, 42, 286, 25);
		JLabel lbl_Banyak = new JLabel("Banyak");
		lbl_Banyak.setBounds(6, 67, 286, 25);
		JLabel lbl_Tipe = new JLabel("Tipe");
		lbl_Tipe.setBounds(6, 92, 286, 25);
		JLabel lbl_Harga = new JLabel("Harga");
		lbl_Harga.setBounds(6, 114, 286, 25);
		
		txtKode = new JTextField();
		txtKode.setBounds(292, 17, 286, 25);
		txtNama = new JTextField();
		txtNama.setBounds(292, 42, 286, 25);
		txtBanyak = new JTextField();
		txtBanyak.setBounds(292, 67, 286, 25);
		txtTipe = new JTextField();
		txtTipe.setBounds(292, 92, 286, 25);
		panel1.setLayout(null);
		
		panel1.add(lbl_kode);
		panel1.add(txtKode);
		panel1.add(lbl_Nama);
		panel1.add(txtNama);
		panel1.add(lbl_Banyak); 
		panel1.add(txtBanyak);
		panel1.add(lbl_Tipe);
		panel1.add(txtTipe);
		panel1.add(lbl_Harga);
        getContentPane().setLayout(null);
        // Create JTable and fill it with data
        getContentPane().add(jsp);
		Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title = BorderFactory.createTitledBorder(lowerEtched,  " Pengubahan ");
		panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel1.setBorder(title);
    	getContentPane().add(panel1);
    	
    	txtHarga = new JTextField();
    	txtHarga.setBounds(292, 116, 286, 25);
    	panel1.add(txtHarga);
    	
    	JButton btnUpdate = new JButton("Update");
    	btnUpdate.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			
    			
				try {
					UpdateFrame c= new UpdateFrame();
	 				   Thread t = new Thread(c);
	 	                t.start();
					
		    		
					
	        		
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	   	
    			
    		}
    	});
    	btnUpdate.setBounds(184, 386, 89, 23);
    	getContentPane().add(btnUpdate);
    	
    	JButton btnInset = new JButton("Insert");
    	btnInset.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			try{
    				InsertFrame b= new InsertFrame();
 				   Thread t = new Thread(b);
 	                t.start();
 	                
    				
    			}
    			catch(Exception e){
    				
    			}
    		}
    	});
    	btnInset.setBounds(85, 386, 89, 23);
    	getContentPane().add(btnInset);
    	
		
    	
    			
    	JButton btnDelete = new JButton("Delete");
    	btnDelete.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			try{
    				
    				DeleteFrame a= new DeleteFrame();
    				   Thread t = new Thread(a);
    	                t.start();
    	              
    			}
    			catch(Exception e){
    				
    			}
    			
    			
    		}
    	});
    	
    	
    	btnDelete.setBounds(283, 386, 89, 23);
    	getContentPane().add(btnDelete);
    	
    	JButton btnNewButton = new JButton("Search");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			try {
					DataBase db= new DataBase();
				
					txtNama.setText(db.selectNama(txtKode.getText()));
					txtBanyak.setText(db.selectBanyak(txtKode.getText()));
					txtTipe.setText(db.selectType(txtKode.getText()));
					txtHarga.setText(db.selectHarga(txtKode.getText()));
								
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    		}
    	});
    	btnNewButton.setBounds(382, 386, 89, 23);
    	getContentPane().add(btnNewButton);
        setVisible(true);
        
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        setJMenuBar(menuBar);
        
        mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        
        mntmCustomer = new JMenuItem("Data Pembeli");
        mntmCustomer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new FramePelangan();
        	}
        });
        mnNewMenu.add(mntmCustomer);
        
        mntmClose = new JMenuItem("Home");
        mntmClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		dispose();
        		new FramePilihan();
        	}
        });
        mnNewMenu.add(mntmClose);
        
        JMenuItem mntmOut = new JMenuItem("Out");
        mntmOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        mnNewMenu.add(mntmOut);
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		new AboutAdmin();
        	}
        });
        mnHelp.add(mntmAbout);

    }
    class DeleteFrame implements Runnable
    {
    
    public void run() {
        try {
        	  DataBase db = new DataBase();
      	   	db.DeleteData(txtKode.getText());
      	   	dispose();
      		new DataAdmin();
      		JOptionPane.showMessageDialog(null, txtKode.getText() + " Delete Berhasil");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null, "Data belum di masukan");
		}
    }
}
    class UpdateFrame implements Runnable
    {
    
    public void run() {
        try {
        	DataBase db = new DataBase();
        	
			db.updateData(txtNama.getText(),txtBanyak.getText(),txtTipe.getText(),txtHarga.getText(),txtKode.getText());
			dispose();
			new DataAdmin();
			JOptionPane.showMessageDialog(null, "Update Berhasil");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	JOptionPane.showMessageDialog(null, "Data belum di masukan");
		}
    }
}
    class InsertFrame implements Runnable
    {
    
    public void run() {
        try {
        	DataBase db = new DataBase();
    	   	db.insertData(txtKode.getText(),txtNama.getText(),txtBanyak.getText(),txtTipe.getText(),txtHarga.getText());
    	   	dispose();
    		new DataAdmin();
    		JOptionPane.showMessageDialog(null, "Insert Berhasil");
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
        	
		}
    }
}

}
