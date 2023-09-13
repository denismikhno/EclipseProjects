import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class GuessingGame extends JFrame {
	
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber)
			message = guess + " меньше загаданного. Попробуй снова.";
		else if (guess > theNumber)
			message = guess + " больше загаданного. Попробуй снова.";
		else 
			message = guess + " угадал! Ты выиграл!!!";
		
		lblOutput.setText(message);					
	}
	
	public void seedingNumber() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
			
		getContentPane().setBackground(UIManager.getColor("OptionPane.background"));
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\ico.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u0418\u0433\u0440\u0430 \u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E");
		getContentPane().setLayout(null);
		
		JLabel lblGameName = new JLabel("Dr. Payne's Hi-Lo Guessing Game");
		lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGameName.setBounds(10, 34, 414, 29);
		getContentPane().add(lblGameName);
		
		JLabel lblGuess = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u043E\u0442 0 \u0434\u043E 100:");
		lblGuess.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuess.setBounds(87, 96, 178, 24);
		getContentPane().add(lblGuess);
		
		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBounds(275, 99, 62, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("\u0423\u0433\u0430\u0434\u0430\u0442\u044C!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		
		btnGuess.setBounds(172, 155, 89, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u0423\u0433\u0430\u0434\u0430\u0442\u044C!");
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 212, 414, 24);
		getContentPane().add(lblOutput);
		
} // GuessingGmae()
	
	public static void main(String[] args) {
		// Подключение системной темы
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		GuessingGame theGame = new GuessingGame();
		
		// для замены фона картинкой
		ImagePanel panel = new ImagePanel(new ImageIcon("back.png").getImage());
		theGame.getContentPane().add(panel);
		
		
		theGame.seedingNumber();
		theGame.setSize(new Dimension(450, 300));
		theGame.getContentPane().add(new JPanel());
		// форма по середине экрана
		theGame.setLocationRelativeTo(null);
		// зафиксировать размер окна
		theGame.setResizable(false);
		theGame.setVisible(true);
	}
} // main

// для замены фона картинкой
class ImagePanel extends JPanel {

	  private Image img;

	  public ImagePanel(String img) {
	    this(new ImageIcon(img).getImage());
	  }

	  public ImagePanel(Image img) {
	    this.img = img;
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }
} // class ImagePanel