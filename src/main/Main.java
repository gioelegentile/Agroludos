/*
 * 
 */
package main;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.UIManager;

import presentation.FrontController;
import utility.CompetitionsCheck;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws SQLException {
		
		JFrame frame = new JFrame();
		frame.setSize(700,680);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Agroludos");
		
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch(Exception e) {
	    }
		
		MyThread competitionDisposer = new MyThread();
		competitionDisposer.start();
		
		FrontController frontController = new FrontController();
		try {
			frontController.processRequest("login", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}

	}
	
}

class MyThread extends Thread {

	@Override
	public void run() {
		try {
			CompetitionsCheck.check();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
