import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class FramePelangan extends JFrame{
	
   	private static final long serialVersionUID = 1L;
   	// create table========================================================================================
   	
   		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
   		String ids,places = new String();
   		String a = new String();
   		String b = new String();
   		String c = new String();
   		JTextField txtNomor,txtKodeBarang,txtNama,txtAlamat,txtnom;
   		private JMenuBar menuBar;
   		private JMenu mnNewMenu;
   		private JMenuItem mntmClose;
   		private JTextField textKodePos;
   		private JTextField textEmali;
   		private JTextField textTelp;
   		private JTextField textNamaBarang;
   		private JTextField textBanyakBarang;
   		private JTextField textBayar;
   		
    FramePelangan() {
    	getContentPane().setBackground(Color.WHITE);
    	setBackground(Color.WHITE);
        try {
            DataBase db = new DataBase();
            data = db.selectDataPembeli();
        	}
        catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Data Base Off");
        	}
        
        setTitle("Welcome to TokoKom Karya Megah");
        setSize(600, 582);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel1 = new JPanel();
        panel1.setBounds(0, 196, 584, 281);
        
        Vector<Object> columnNames = new Vector<Object>();
        columnNames.add("Nomor");
        columnNames.add("Kode Barang");
        columnNames.add("Nama");
        columnNames.add("Alamat");
        columnNames.add("Kode Pos");
        columnNames.add("Email");
        columnNames.add("Telp");
        columnNames.add("Nama Barang");
        columnNames.add("Banyak  Barang");
        columnNames.add("Biaya");
        
		
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
		
		JLabel lbl_id = new JLabel("Nomor");
		lbl_id.setBounds(6, 17, 286, 25);
		JLabel lbl_title = new JLabel("Kode Barang");
		lbl_title.setBounds(6, 42, 286, 25);
		JLabel lbl_creator = new JLabel("Nama");
		lbl_creator.setBounds(6, 67, 286, 25);
		JLabel lbl_build = new JLabel("Alamat");
		lbl_build.setBounds(6, 92, 286, 25);
		JLabel lbl_place = new JLabel("Kode Pos");
		lbl_place.setBounds(6, 114, 286, 25);
		
		txtNomor = new JTextField();
		txtNomor.setBounds(292, 17, 286, 25);
		txtKodeBarang = new JTextField();
		txtKodeBarang.setBounds(292, 42, 286, 25);
		txtNama = new JTextField();
		txtNama.setBounds(292, 67, 286, 25);
		txtAlamat = new JTextField();
		txtAlamat.setBounds(292, 92, 286, 25);
		panel1.setLayout(null);
		
		panel1.add(lbl_id);
		panel1.add(txtNomor);
		panel1.add(lbl_title);
		panel1.add(txtKodeBarang);
		panel1.add(lbl_creator); 
		panel1.add(txtNama);
		panel1.add(lbl_build);
		panel1.add(txtAlamat);
		panel1.add(lbl_place);
        getContentPane().setLayout(null);
        // Create JTable and fill it with data
        getContentPane().add(jsp);
		Border lowerEtched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder title = BorderFactory.createTitledBorder(lowerEtched, "Pencarian ");
		panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel1.setBorder(title);
    	getContentPane().add(panel1);
    	
    	JLabel lblNomorBarang = new JLabel("Email");
    	lblNomorBarang.setBounds(6, 141, 276, 22);
    	panel1.add(lblNomorBarang);
    	
    	textKodePos = new JTextField();
    	textKodePos.setBounds(292, 116, 286, 25);
    	panel1.add(textKodePos);
    	
    	textEmali = new JTextField();
    	textEmali.setBounds(292, 138, 286, 25);
    	panel1.add(textEmali);
    	
    	JLabel lblTelp = new JLabel("Telp");
    	lblTelp.setBounds(6, 163, 276, 22);
    	panel1.add(lblTelp);
    	
    	JLabel lblNamaBarang = new JLabel("Nama Barang");
    	lblNamaBarang.setBounds(6, 187, 276, 22);
    	panel1.add(lblNamaBarang);
    	
    	JLabel lblBanyakBarang = new JLabel("Banyak Barang");
    	lblBanyakBarang.setBounds(6, 213, 276, 22);
    	panel1.add(lblBanyakBarang);
    	
    	JLabel lblTotalBayar = new JLabel("Total Bayar");
    	lblTotalBayar.setBounds(6, 236, 276, 22);
    	panel1.add(lblTotalBayar);
    	
    	textTelp = new JTextField();
    	textTelp.setBounds(292, 164, 286, 25);
    	panel1.add(textTelp);
    	textTelp.setColumns(10);
    	
    	textNamaBarang = new JTextField();
    	textNamaBarang.setColumns(10);
    	textNamaBarang.setBounds(292, 188, 286, 25);
    	panel1.add(textNamaBarang);
    	
    	textBanyakBarang = new JTextField();
    	textBanyakBarang.setColumns(10);
    	textBanyakBarang.setBounds(292, 214, 286, 25);
    	panel1.add(textBanyakBarang);
    	
    	textBayar = new JTextField();
    	textBayar.setColumns(10);
    	textBayar.setBounds(292, 237, 286, 25);
    	panel1.add(textBayar);
    	
    	JButton btnCari = new JButton("Search");
    	btnCari.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    			try{
    				DataBase db= new DataBase();
    				txtKodeBarang.setText(db.CariKodeBar(txtNomor.getText()));
    				txtNama.setText(db.CariNama(txtNomor.getText()));
    				txtAlamat.setText(db.CariAlamat(txtNomor.getText()));
    				textKodePos.setText(db.CariKodePos(txtNomor.getText()));
    				textEmali.setText(db.CariEmail(txtNomor.getText()));
    				textTelp.setText(db.CariTelp(txtNomor.getText()));
    				textNamaBarang.setText(db.CariNamaBarang(txtNomor.getText()));
    				textBanyakBarang.setText(db.CariBanyakBarang(txtNomor.getText()));
    				textBayar.setText(db.CariBiaya(txtNomor.getText()));
    				
    			}
    			catch(Exception e){
    				
    			}
    		}
    	});
    	btnCari.setBounds(406, 488, 89, 23);
    	getContentPane().add(btnCari);
    	
    	JButton btnPerbahrui = new JButton("Update");
    	btnPerbahrui.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent arg0) {
    		try {
				DataBase db=new DataBase();
				db.updatePembeli(txtKodeBarang.getText(), txtNama.getText(), txtAlamat.getText(), textKodePos.getText(),textEmali.getText(), 
						textTelp.getText(),textNamaBarang.getText(), textBanyakBarang.getText(), textBayar.getText(), txtNomor.getText());
				JOptionPane.showMessageDialog(null, "Update Berhasil");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		}
    	});
    	btnPerbahrui.setBounds(286, 488, 89, 23);
    	getContentPane().add(btnPerbahrui);
    	
    	JButton btnNewButton = new JButton("Delete");
    	btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			try {
					DataBase db=new DataBase();
					db.DeletePembeli(txtNomor.getText());
					JOptionPane.showMessageDialog(null, "Nomor " + txtNomor.getText() + " Berhasil di Delete");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    		}
    	});
    	btnNewButton.setBounds(149, 488, 89, 23);
    	getContentPane().add(btnNewButton);
        setVisible(true);
        
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.LIGHT_GRAY);
        setJMenuBar(menuBar);
        
        mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);
        
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
}