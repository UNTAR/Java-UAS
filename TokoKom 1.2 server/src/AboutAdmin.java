import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class AboutAdmin {

	private JFrame frmAbout;

	public AboutAdmin() {
		initialize();
	}

	
	private void initialize() {
		frmAbout = new JFrame();
		frmAbout.setTitle("About");
		frmAbout.getContentPane().setBackground(Color.WHITE);
		
		frmAbout.setBounds(100, 100, 624, 359);
		frmAbout.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 41, 204, 247);
		Image img= new ImageIcon(this.getClass().getResource("/lol.jpg")).getImage();
		
		frmAbout.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img));
		frmAbout.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Tentang Kelompok :");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(235, 11, 251, 37);
		frmAbout.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pertama-tama kami mengucapkan Terima kasih pada Tuhan yang");
		lblNewLabel_1.setBounds(214, 48, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("maha esa karena berkat rahmatnya kami dapat menyelesaikan");
		lblNewLabel_2.setBounds(214, 73, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("projek kami ini,Pada proyek kami kali ini kami membuat program");
		lblNewLabel_3.setBounds(214, 98, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mengenai Toko komputer.Diharapkan dengan kemunculan aplikasi");
		lblNewLabel_4.setBounds(214, 123, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("ini dapat memudahkan pembeli dalam membeli peralatan komputer");
		lblNewLabel_5.setBounds(214, 156, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("yang mereka inginkan sesuai keinginan mereka.Kami Menyadari");
		lblNewLabel_6.setBounds(214, 181, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Bahwa aplikasi kam ini jauh dari kata sempurna,oleh karna itu ");
		lblNewLabel_7.setBounds(214, 213, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Kami mohon maaf apabila program kami ini tidak sesuai");
		lblNewLabel_8.setBounds(214, 238, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("dengan keinginan user.");
		lblNewLabel_9.setBounds(214, 263, 384, 14);
		frmAbout.getContentPane().add(lblNewLabel_9);
		frmAbout.setVisible(true);
	}
}
