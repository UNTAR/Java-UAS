import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class frameOpen {

	private JFrame frmLoginForAdmin;
	private JTextField textField_1;
	private JPasswordField passwordField;


	public frameOpen() {
		try {
			initialize(null);
		} catch (Exception e) {
			// TODO Auto-generated catch blockd
			e.printStackTrace();
		}
	}

	
	private void initialize(JLabel lblNewLabel) throws Exception {
		DataBase db =new DataBase();
		frmLoginForAdmin = new JFrame();
		frmLoginForAdmin.setTitle("Login for Admin");
		frmLoginForAdmin.getContentPane().setBackground(Color.WHITE);
		
		frmLoginForAdmin.setBounds(100, 100, 714, 352);
		frmLoginForAdmin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
		frmLoginForAdmin.getContentPane().setLayout(null);
		
		 lblNewLabel = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("/images.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(35, 59, 204, 204);
		frmLoginForAdmin.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(426, 131, 149, 27);
		frmLoginForAdmin.getContentPane().add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(426, 170, 149, 27);
		frmLoginForAdmin.getContentPane().add(passwordField);
		
		
		JLabel lblAdminId = new JLabel("Admin ID  :");
		lblAdminId.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblAdminId.setBounds(293, 131, 123, 27);
		frmLoginForAdmin.getContentPane().add(lblAdminId);
		
		JLabel lblPassword = new JLabel("Password   :");
		lblPassword.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPassword.setBounds(293, 176, 123, 27);
		frmLoginForAdmin.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(db.login(textField_1,passwordField)){
						
						frmLoginForAdmin.dispose();
						new DataAdmin();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(489, 208, 89, 23);
		frmLoginForAdmin.getContentPane().add(btnLogin);
		
		JLabel lblHanyaAdminYang = new JLabel("Toko Komputer Karya Megah");
		lblHanyaAdminYang.setForeground(Color.ORANGE);
		lblHanyaAdminYang.setFont(new Font("Centaur", Font.BOLD, 30));
		lblHanyaAdminYang.setBackground(Color.GRAY);
		lblHanyaAdminYang.setBounds(150, 11, 406, 63);
		frmLoginForAdmin.getContentPane().add(lblHanyaAdminYang);
		
		JLabel lblLoginHanyaDiperbolehkan = new JLabel("Login hanya diperbolehkan untuk admin yang bertugas");
		lblLoginHanyaDiperbolehkan.setForeground(Color.RED);
		lblLoginHanyaDiperbolehkan.setBounds(10, 288, 367, 14);
		frmLoginForAdmin.getContentPane().add(lblLoginHanyaDiperbolehkan);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLoginForAdmin.dispose();
				new FramePilihan();
				
				
			}
		});
		btnCancel.setBounds(390, 208, 89, 23);
		frmLoginForAdmin.getContentPane().add(btnCancel);
		frmLoginForAdmin.setVisible(true);
	}
}
