import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FramePilihan extends JFrame{
	
   	private static final long serialVersionUID = 1L;
   	// create table========================================================================================
   	
   		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
   		String ids,places = new String();
   		String a = new String();
   		String b = new String();
   		String c = new String();
   		JTextField txtNama,txtnom;
   		private JMenuBar menuBar;
   		private JMenu mnNewMenu;
   		private JMenuItem mntmCustomer;
   		private JMenuItem mntmClose;
   		
    FramePilihan() {
    	getContentPane().setBackground(Color.WHITE);
    	setBackground(Color.WHITE);
        try {
            DataBase db = new DataBase();
            data = db.selectData();
        	}
        catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Data Base Belom On");
        	}
        
        setTitle("Welcome to TokoKom Karya Megah");
        setSize(600, 452);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 196, 584, 153);
        
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("Kode Barang");
        columnNames.add("Nama Barang");
        columnNames.add("Banyak");
        columnNames.add("Tipe");
        columnNames.add("Harga");
       
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
		
		JLabel lbl_id = new JLabel("Nama Barang                                                     :");
		lbl_id.setBounds(6, 17, 286, 25);
		JLabel lbl_title = new JLabel("Kode barang                                                      :");
		lbl_title.setBounds(6, 42, 286, 25);
		JLabel lbl_creator = new JLabel("Tipe                                                                    :");
		lbl_creator.setBounds(6, 67, 286, 25);
		JLabel lbl_build = new JLabel("Banyak                                                               :");
		lbl_build.setBounds(6, 92, 286, 25);
		JLabel lbl_place = new JLabel("Harga                                                                 :");
		lbl_place.setBounds(6, 114, 286, 25);
		txtNama = new JTextField();
		txtNama.setBounds(292, 17, 286, 25);
		panel1.setLayout(null);
		
		panel1.add(lbl_id);
		panel1.add(lbl_title);
		panel1.add(txtNama);
		panel1.add(lbl_creator);
		panel1.add(lbl_build);
		panel1.add(lbl_place);
        getContentPane().setLayout(null);
        // Create JTable and fill it with data
        getContentPane().add(jsp);
		Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Pencarian ");
		panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel1.setBorder(title);
    	getContentPane().add(panel1);
    	
    	JLabel tulisanKode = new JLabel("-");
    	tulisanKode.setBounds(292, 47, 286, 14);
    	panel1.add(tulisanKode);
    	
    	JLabel tulisanTipe = new JLabel("-");
    	tulisanTipe.setBounds(292, 72, 286, 14);
    	panel1.add(tulisanTipe);
    	
    	JLabel tulisanBanyak = new JLabel("-");
    	tulisanBanyak.setBounds(292, 97, 286, 14);
    	panel1.add(tulisanBanyak);
    	
    	JLabel tulisanHarga = new JLabel("-");
    	tulisanHarga.setBounds(292, 119, 286, 14);
    	panel1.add(tulisanHarga);
    	
    	JButton btnBeli = new JButton("Beli");
    	btnBeli.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					new Datapembeli();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}
    	});
    	btnBeli.setBounds(477, 360, 89, 23);
    	getContentPane().add(btnBeli);
    	
    	JButton btnCari = new JButton("Cari");
    	btnCari.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			try{
    				DataBase db =new DataBase();
    				tulisanKode.setText(db.selectKODE(txtNama.getText()));
    				tulisanTipe.setText(db.selectTipe(txtNama.getText()));
    				tulisanBanyak.setText(db.selectBanyakFrame(txtNama.getText()));
    				tulisanHarga.setText(db.selectHargaFrame(txtNama.getText()));
    			}
    			catch(Exception e){
    				
    			}
    		}
    	});
    	btnCari.setBounds(378, 360, 89, 23);
    	getContentPane().add(btnCari);
        setVisible(true);
        
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        setJMenuBar(menuBar);
        
        mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        
        mntmCustomer = new JMenuItem("Admin Acount");
        mntmCustomer.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
        		
        		new frameOpen();
        		hide();
        	}
        });
        mnNewMenu.add(mntmCustomer);
        
        mntmClose = new JMenuItem("Close");
        mntmClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        	}
        });
        mnNewMenu.add(mntmClose);
        
        JMenu mnHelp = new JMenu("Help");
        menuBar.add(mnHelp);
        
        JMenuItem mntmAbout = new JMenuItem("About");
        mntmAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		new AboutAdmin();
        	}
        });
        mnHelp.add(mntmAbout);

    }

	public void Dispose() {
		// TODO Auto-generated method stub
		
	}
}