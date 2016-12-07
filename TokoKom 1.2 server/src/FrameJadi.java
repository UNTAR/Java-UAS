
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameJadi {
Datapembeli frm ;
	private JFrame frame;
	protected Object txtNama;

	
	public FrameJadi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 328);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPesananAdaKana = new JLabel("Pesanan ada kana di vertivikasi ke Account Email anda.");
		lblPesananAdaKana.setBounds(24, 55, 314, 114);
		frame.getContentPane().add(lblPesananAdaKana);
		
		JLabel lblBilaAdaKesalahan = new JLabel("Bila ada kesalahan pemesanan atau Bantuan ");
		lblBilaAdaKesalahan.setBounds(24, 93, 314, 114);
		frame.getContentPane().add(lblBilaAdaKesalahan);
		
		JLabel lblSilakanHubungiNomor = new JLabel("Silakan Hubungi Nomor kami yang tertera di Help");
		lblSilakanHubungiNomor.setBounds(24, 118, 314, 114);
		frame.getContentPane().add(lblSilakanHubungiNomor);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnOk.setBounds(270, 255, 89, 23);
		frame.getContentPane().add(btnOk);
		frame.setVisible(true);
	}
}
