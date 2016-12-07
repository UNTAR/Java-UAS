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
		
		frmAbout.setBounds(100, 100, 559, 286);
		frmAbout.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel label = new JLabel("");
		label.setBounds(21, 0, 204, 247);
		Image img= new ImageIcon(this.getClass().getResource("/lol.jpg")).getImage();
		
		frmAbout.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img));
		frmAbout.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Tentang Kelompok :");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(235, 11, 251, 37);
		frmAbout.getContentPane().add(lblNewLabel);
		frmAbout.setVisible(true);
	}

}
