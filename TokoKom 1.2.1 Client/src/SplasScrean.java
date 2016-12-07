import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class SplasScrean extends JWindow {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static boolean isRegistered;
    private static JProgressBar progressBar = new JProgressBar();
    private static int count;
    private static Timer timer1;
//------------------------------------------------------------------------------------------------------
    public SplasScrean() throws IOException {
    	getContentPane().setBackground(Color.GRAY);

        Container container = getContentPane();
        container.setLayout(null);
      
    	
        JPanel panel = new JPanel();
        panel.setBorder(new javax.swing.border.EtchedBorder());
        panel.setBackground(Color.BLACK);
        panel.setBounds(10, 10, 348, 150);
        panel.setLayout(null);
        container.add(panel);
        
        JLabel lblTokoKomputerKarya = new JLabel("Toko Komputer Karya Megah");
        lblTokoKomputerKarya.setForeground(Color.LIGHT_GRAY);
        lblTokoKomputerKarya.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 15));
        lblTokoKomputerKarya.setBounds(0, 0, 282, 28);
        panel.add(lblTokoKomputerKarya);
        
        JLabel lblKelompok = new JLabel("Kelompok :");
        lblKelompok.setForeground(Color.LIGHT_GRAY);
        lblKelompok.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 13));
        lblKelompok.setBounds(20, 27, 106, 28);
        panel.add(lblKelompok);
        
        JLabel lblFeerye = new JLabel("Feery.E (535140065)");
        lblFeerye.setForeground(Color.LIGHT_GRAY);
        lblFeerye.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 13));
        lblFeerye.setBounds(156, 55, 182, 28);
        panel.add(lblFeerye);
        
        JLabel lblKennedy = new JLabel("Kennedy (535140061)");
        lblKennedy.setForeground(Color.LIGHT_GRAY);
        lblKennedy.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 13));
        lblKennedy.setBounds(156, 79, 182, 28);
        panel.add(lblKennedy);
        
        JLabel lblBilly = new JLabel("Billy (535140060)");
        lblBilly.setForeground(Color.LIGHT_GRAY);
        lblBilly.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 13));
        lblBilly.setBounds(156, 111, 182, 28);
        panel.add(lblBilly);
        Image img= new ImageIcon(this.getClass().getResource("/kok.png")).getImage();
        JLabel label = new JLabel("");
        label.setBounds(10, -26, 253, 250);
        label.setIcon(new ImageIcon(img));;
        panel.add(label);
     
        progressBar.setForeground(Color.DARK_GRAY);
        progressBar.setBackground(Color.WHITE);
    	
       //----------------------------------------------------------------------------------------------
       //panel.add(picLabel);
        progressBar.setMaximum(50);
        progressBar.setBounds(55, 180, 250, 15);
        container.add(progressBar);
        loadProgressBar();
        setSize(370, 215);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
 
//-----------------------------------------------------------------------------------------------------------------------------
    private void loadProgressBar() {
    	
    	
        ActionListener al = new ActionListener() {
//===============================================================================================
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count++;

                progressBar.setValue(count);

                

                if (count == 50) {

                    try {
						new FramePilihan();
                    	
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                    //swapped this around with timer1.stop()

                   timer1.stop();
                   setVisible(false);
                }

            }
            //=================================================================================================
           
                 //================================================================================================= 
        };
        timer1 = new Timer(50, al);
        timer1.start();
    }
  }