

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Datapembeli {

	private JFrame frame;
	JTextField textNama;
	private JTextField TxtAlamat;
	private JTextField textKodePos;
	private JTextField textEmail;
	private JTextField textTelp;
	private JTextField textKodeBarang;
	private JTextField textBanyak;


	public Datapembeli() throws Exception {
		initialize();
	}

	
	private void initialize() throws Exception {
		DataBase db = new DataBase();
		frame = new JFrame();
		frame.setBounds(100, 100, 390, 455);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAndaDiMinta = new JLabel("Silakan isi untuk tahap pemesanan dan pembayaran");
		lblAndaDiMinta.setForeground(Color.LIGHT_GRAY);
		lblAndaDiMinta.setBounds(10, 11, 299, 14);
		frame.getContentPane().add(lblAndaDiMinta);	
		
		JLabel lblNamaLengkap = new JLabel("Nama Lengkap :");
		lblNamaLengkap.setBounds(10, 36, 91, 14);
		frame.getContentPane().add(lblNamaLengkap);
		
		textNama = new JTextField();
		textNama.setBounds(146, 36, 188, 20);
		frame.getContentPane().add(textNama);
		textNama.setColumns(10);
		
		JLabel lblAlamat = new JLabel("Alamat             :");
		lblAlamat.setBounds(10, 106, 91, 14);
		frame.getContentPane().add(lblAlamat);
		
		TxtAlamat = new JTextField();
		TxtAlamat.setBounds(146, 97, 188, 20);
		frame.getContentPane().add(TxtAlamat);
		TxtAlamat.setColumns(10);
		
		JLabel lblKodepos = new JLabel("Kode-Pos         :");
		lblKodepos.setBounds(10, 141, 91, 14);
		frame.getContentPane().add(lblKodepos);
		
		textKodePos = new JTextField();
		textKodePos.setBounds(146, 138, 86, 20);
		frame.getContentPane().add(textKodePos);
		textKodePos.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email                :");
		lblEmail.setBounds(10, 178, 91, 14);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(146, 175, 182, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblTelp = new JLabel("Telp                 :");
		lblTelp.setBounds(10, 214, 91, 14);
		frame.getContentPane().add(lblTelp);
		
		textTelp = new JTextField();
		textTelp.setBounds(146, 211, 163, 20);
		frame.getContentPane().add(textTelp);
		textTelp.setColumns(10);
		
		JLabel lblNamaBarang = new JLabel("Kode Barang   :");
		lblNamaBarang.setBounds(10, 250, 91, 14);
		frame.getContentPane().add(lblNamaBarang);
		
		textKodeBarang = new JTextField();
		textKodeBarang.setBounds(146, 247, 163, 20);
		frame.getContentPane().add(textKodeBarang);
		textKodeBarang.setColumns(10);
		
		JLabel lblBanyak = new JLabel("Banyak             :");
		lblBanyak.setBounds(10, 289, 91, 14);
		frame.getContentPane().add(lblBanyak);
		
		textBanyak = new JTextField();
		textBanyak.setBounds(146, 289, 65, 20);
		frame.getContentPane().add(textBanyak);
		textBanyak.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
					DataPesanan frm = new DataPesanan();
				try {
					frm.getPass(textNama.getText(),
							TxtAlamat.getText(),
							textKodePos.getText(),
							textEmail.getText(),
							textTelp.getText(),
							textKodeBarang.getText(),
							textBanyak.getText(),
							db.selectHarga(textKodeBarang.getText()),
							db.selectNama(textKodeBarang.getText()),
							db.selectBanyak(textKodeBarang.getText())
							);                         
					frm.setVisibel(true);
					frame.hide();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Data Kosong atau Salah memasukan");
				}
		}
		});
		btnNewButton.setBounds(275, 382, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(176, 382, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}


	public void Dispose() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

}
