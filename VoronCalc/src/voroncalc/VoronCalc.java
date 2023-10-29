package voroncalc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VoronCalc extends JFrame {

	private static final long serialVersionUID = 7463735641748444749L;

	private int voron = 0;
	private JLabel countLabel;
	private JButton addCrow;
	private JButton removeCrow;

	public VoronCalc() {
		super("Калькулятор ворон");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Здесь setLocationRelativeTo не будет выводить окно посередине
		//setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\voron.png"));
		/* Подготавливаем компоненты объекта */
		countLabel = new JLabel("Вороны:" + voron);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addCrow = new JButton("Добавить ворону");
		addCrow.setFocusPainted(false);
		removeCrow = new JButton("Удалить ворону");
		removeCrow.setFocusPainted(false);
		/* Подготавливаем временные компоненты */
		JPanel buttonsPanel = new JPanel(new FlowLayout());
		/* Расставляем компоненты по местам */
		getContentPane().add(countLabel, BorderLayout.CENTER); /* О размещении компонент поговорим позже */
		buttonsPanel.add(addCrow);
		buttonsPanel.add(removeCrow);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
		initListeners();
	}

	private void initListeners() {

		addCrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voron = voron + 1; /* Добавляем одну ворону */
				updateCrowCounter(); /* Сообщаем аппликации, что количество ворон изменилось */
			}
		});

		removeCrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (voron > 0) {
					voron = voron - 1;
					updateCrowCounter(); /* Сообщаем аппликации, что количество ворон изменилось */
				}
			}
		});

	}

	private void updateCrowCounter() {
		countLabel.setText("Вороны:" + voron);
	}

	public static void main(String[] args) {

		try {
			// Установка системной темы или тем
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // getSystemLookAndFeelClassName()
																					// getCrossPlatformLookAndFeelClassName()
		} catch (Exception e) {
			
		}

		VoronCalc app = new VoronCalc();
		app.setSize(400, 300);
		// Здесь setLocationRelativeTo будет выводить окно посередине!!!
		app.setLocationRelativeTo(null);
		app.setVisible(true);
		//app.pack(); /* Эта команда подбирает оптимальный размер в зависимости от содержимого окна */
	}

}
