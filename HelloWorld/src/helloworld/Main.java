package helloworld;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;


public class Main extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public Main(){
	    super("My First Window");
	    setBounds(100, 100, 200, 200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    JButton btnNewButton = new JButton("New button");
	    getContentPane().add(btnNewButton, BorderLayout.CENTER);
	  }
	
	public static void main(String[] args) { 
	    Main app = new Main(); 
	    app.setVisible(true); 
	  }

}
