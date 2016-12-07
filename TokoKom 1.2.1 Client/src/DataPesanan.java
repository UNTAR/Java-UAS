

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DataPesanan {

	private JFrame frame;
	private final JLabel lblNama=new JLabel(""); 
	private final JLabel lblAlamat = new JLabel("");
	private final JLabel lblNama_1 = new JLabel("Nama                   :");
	private final JLabel lblNewLabel = new JLabel("Alamat                 :");
	private final JLabel lblKodePos = new JLabel("Kode Pos             :");
	private final JLabel lblEmail = new JLabel("Email                   :");
	private final JLabel lblTelp = new JLabel("Telp                    :");
	private final JLabel lblNamaBarang = new JLabel("Kode Barang      :");
	private final JLabel lblBayak = new JLabel("Bayak                  :");
	private final JLabel lblHarga = new JLabel("Harga                  :");
	private final JButton btnOk = new JButton("Ok");
	private final JLabel lblKODEPOS = new JLabel("");
	private final JLabel lblEMAIL = new JLabel("");
	private final JLabel lblTELP = new JLabel("");
	private final JLabel lblKodeBar = new JLabel("");
	private final JLabel lblBANYAK = new JLabel("");
	private final JLabel lblHARAGA = new JLabel("");
	private final JLabel lblNamaBarang_1 = new JLabel("Nama Barang     :");
	private final JLabel lblBarang = new JLabel("");
	private final JButton btnCancel = new JButton("Cancel");
	
	public DataPesanan() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 298, 390);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblNama.setBounds(142, 25, 130, 14);
		frame.getContentPane().add(lblNama);
		lblAlamat.setBounds(141, 50, 131, 14);
		frame.getContentPane().add(lblAlamat);
		lblNama_1.setBounds(21, 25, 111, 14);
		
		frame.getContentPane().add(lblNama_1);
		lblNewLabel.setBounds(21, 50, 110, 14);
		
		frame.getContentPane().add(lblNewLabel);
		lblKodePos.setBounds(21, 75, 111, 14);
		
		frame.getContentPane().add(lblKodePos);
		lblEmail.setBounds(21, 100, 100, 14);
		
		frame.getContentPane().add(lblEmail);
		lblTelp.setBounds(21, 125, 111, 14);
		
		frame.getContentPane().add(lblTelp);
		lblNamaBarang.setBounds(21, 150, 111, 14);
		
		frame.getContentPane().add(lblNamaBarang);
		lblBayak.setBounds(21, 198, 100, 14);
		
		frame.getContentPane().add(lblBayak);
		lblHarga.setBounds(21, 223, 100, 14);
		
		frame.getContentPane().add(lblHarga);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					FramePilihan frm = new FramePilihan();
					DataBase db = new DataBase();
					String coba=db.selectBanyak(lblKodeBar.getText());
					String lama=lblBANYAK.getText();
					int pengurangan =Integer.parseInt(coba)-Integer.parseInt(lama);
					
		        	db.insertDataPembeli(lblKodeBar .getText(),lblNama.getText(),lblAlamat.getText(),lblKODEPOS .getText(),lblEMAIL.getText(),lblTELP.getText(),lblBarang.getText(),lblBANYAK.getText(),lblHARAGA.getText());
		        	JOptionPane.showMessageDialog(null, "Pesanan anda telah terkirim");
					db.updateBanyak(String.valueOf(pengurangan),lblKodeBar .getText());
					frame.dispose();
					frm.Dispose();
					
				}
				
				 catch (SQLException e) {
					 e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Data Kosong");
					frame.dispose();
				 }
				
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan Perogram");
					frame.dispose();
				}

			}
		});
		btnOk.setBounds(183, 294, 89, 23);
		
		frame.getContentPane().add(btnOk);
		lblKODEPOS.setBounds(142, 75, 131, 14);
		
		frame.getContentPane().add(lblKODEPOS);
		lblEMAIL.setBounds(141, 100, 131, 14);
		
		frame.getContentPane().add(lblEMAIL);
		lblTELP.setBounds(141, 125, 130, 14);
		
		frame.getContentPane().add(lblTELP);
		lblKodeBar.setBounds(142, 150, 130, 14);
		
		frame.getContentPane().add(lblKodeBar);
		lblBANYAK.setBounds(141, 198, 131, 14);
		
		frame.getContentPane().add(lblBANYAK);
		lblHARAGA.setBounds(141, 223, 131, 14);
		
		frame.getContentPane().add(lblHARAGA);
		lblNamaBarang_1.setBounds(21, 173, 100, 14);
		
		frame.getContentPane().add(lblNamaBarang_1);
		lblBarang.setBounds(142, 173, 130, 14);
		
		frame.getContentPane().add(lblBarang);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(84, 294, 89, 23);
		
		frame.getContentPane().add(btnCancel);
		 
	}

	


	public void setVisibel(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

	public void getPass(
			String nama, String alamat, 
			String kodepos, String email, 
			String telp, String kodebar,
			String string7, String harga,
			String string8,String banyak) 
	{
		try{
		int sum= Integer.parseInt(string7)*Integer.parseInt(harga);
			// TODO Auto-generated method stub
		lblNama.setText(nama);	
		lblAlamat.setText(alamat);
		lblKODEPOS.setText(kodepos);
		lblEMAIL.setText(email);
		lblTELP.setText(telp);
		lblKodeBar.setText(kodebar);
		lblBANYAK.setText(string7);
		lblBarang.setText(string8);
		lblHARAGA.setText(String.valueOf(sum));
		
		
		
		
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null, "Data belum di input");
		}
	}

}
