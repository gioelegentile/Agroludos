/*
 * 
 */
package ui;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JList;

import business.BusinessDelegate;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.FrontController;

import java.awt.Color;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminManagers.
 */
public class AdminManagers extends JPanel {

	/** The combo box. */
	private JComboBox comboBox;

	/** The lbl new label. */
	private JLabel lblNewLabel;

	/** The panel. */
	private JPanel panel;

	/** The Constant DELETE_OPTIONAL. */
	private static final String DELETE_MANAGER = "Elimina Manager";

	/** The Constant CREATE_OPTIONAL. */
	private static final String ADD_MANAGER = "Aggiungi un nuovo Manager";

	/** The choice. */
	private String[] choice = { ADD_MANAGER, DELETE_MANAGER };

	/** The business. */
	private BusinessDelegate business;

	/** The front controller. */
	private FrontController frontController;

	/** The list. */
	private JList list;

	/** The list model. */
	private DefaultListModel listModel;

	/** The optional name. */
	private JTextField optionalName;

	/** The optional price. */
	private JTextField optionalPrice;

	/** The lbl inserisci i dati. */
	private JLabel lblInserisciIDati;

	/** The btn new button_2. */
	private JButton btnNewButton_2;
	
	/** The lbl seleziona dalla lista. */
	private JLabel lblSelezionaDallaLista;
	
	/** The scroll pane_1. */
	private JScrollPane scrollPane_1;
	
	/** The btn elimina. */
	private JButton btnElimina;
	
	/** The btn aggiungi manager. */
	private JButton btnAggiungiManager;
	
	/** The list_2. */
	private JList list_2;

	/**
	 * Create the panel.
	 */
	public AdminManagers() {

		frontController = new FrontController();
		business = new BusinessDelegate();

		lblNewLabel = new JLabel("GESTISCI MANAGERS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));

		comboBox = new JComboBox(choice);
		comboBox.setEditable(false);
		comboBox.setSelectedIndex(-1);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (ADD_MANAGER.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();

					listModel = new DefaultListModel();
					list = new JList();
					ArrayList<ArrayList<String>> usersNotManager = new ArrayList<ArrayList<String>>();

					try {
						usersNotManager = (ArrayList<ArrayList<String>>) business
								.execute("getUsersNotManager", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (ArrayList<String> arr : usersNotManager) {
						listModel.addElement(arr.get(0));
					}

					list.setModel(listModel);
					JScrollPane scrollPane = new JScrollPane(list);

					btnAggiungiManager = new JButton("Aggiungi Manager");
					btnAggiungiManager.setFont(new Font("Tahoma", Font.PLAIN,
							11));
					btnAggiungiManager.setEnabled(false);

					JLabel lblSelezionaIlManager = new JLabel(
							"Seleziona il manager che vuoi aggiungere dalla lista utenti");
					lblSelezionaIlManager
							.setHorizontalAlignment(SwingConstants.CENTER);
					lblSelezionaIlManager.setFont(new Font("Tahoma",
							Font.PLAIN, 14));
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(gl_panel
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panel.createSequentialGroup()
											.addGroup(
													gl_panel.createParallelGroup(
															Alignment.TRAILING)
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(94)
																			.addComponent(
																					scrollPane,
																					GroupLayout.PREFERRED_SIZE,
																					168,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED,
																					107,
																					Short.MAX_VALUE)
																			.addComponent(
																					btnAggiungiManager))
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addContainerGap(
																					102,
																					Short.MAX_VALUE)
																			.addComponent(
																					lblSelezionaIlManager,
																					GroupLayout.PREFERRED_SIZE,
																					386,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(101)));
					gl_panel.setVerticalGroup(gl_panel
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panel.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblSelezionaIlManager)
											.addGroup(
													gl_panel.createParallelGroup(
															Alignment.LEADING)
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(18)
																			.addComponent(
																					scrollPane,
																					GroupLayout.PREFERRED_SIZE,
																					198,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(83)
																			.addComponent(
																					btnAggiungiManager,
																					GroupLayout.PREFERRED_SIZE,
																					38,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(16)));

					list.addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent arg0) {
							btnAggiungiManager.setEnabled(true);
						}

					});

					btnAggiungiManager.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {

							boolean done = false;

							try {
								done = (boolean) business.execute("addManager",
										list.getSelectedValue());
							} catch (SecurityException | NoSuchMethodException
									| ClassNotFoundException
									| InstantiationException
									| IllegalAccessException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							if (done) {

								JOptionPane.showMessageDialog(null,
										"Manager aggiunto correttamente!",
										"Successo", 1);
								listModel.removeElement(list.getSelectedValue());
								list.setModel(listModel);
							
							} else {
								JOptionPane.showMessageDialog(null,
										"ERRORE!",
										"Attenzione", 0);
							}
							
						}

					});

					scrollPane.setViewportView(list);
					panel.setLayout(gl_panel);
					panel.revalidate();

				} else if (DELETE_MANAGER.equals(comboBox.getSelectedItem())) {
					panel.setLayout(null);
					panel.removeAll();

					lblSelezionaDallaLista = new JLabel(
							"Seleziona dalla lista il manager che vuoi eliminare");
					lblSelezionaDallaLista.setFont(new Font("Tahoma",
							Font.PLAIN, 14));
					lblSelezionaDallaLista
							.setHorizontalAlignment(SwingConstants.CENTER);

					scrollPane_1 = new JScrollPane();

					btnElimina = new JButton("Elimina Manager");
					btnElimina.setFont(new Font("Tahoma", Font.PLAIN, 11));
					btnElimina.setEnabled(false);
					
					GroupLayout gl_panel = new GroupLayout(panel);
					gl_panel.setHorizontalGroup(gl_panel
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panel.createSequentialGroup()
											.addGroup(
													gl_panel.createParallelGroup(
															Alignment.TRAILING)
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(94)
																			.addComponent(
																					scrollPane_1,
																					GroupLayout.PREFERRED_SIZE,
																					168,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED,
																					107,
																					Short.MAX_VALUE)
																			.addComponent(
																					btnElimina))
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addContainerGap(
																					102,
																					Short.MAX_VALUE)
																			.addComponent(
																					lblSelezionaDallaLista,
																					GroupLayout.PREFERRED_SIZE,
																					386,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(101)));
					gl_panel.setVerticalGroup(gl_panel
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									Alignment.TRAILING,
									gl_panel.createSequentialGroup()
											.addContainerGap()
											.addComponent(
													lblSelezionaDallaLista)
											.addGroup(
													gl_panel.createParallelGroup(
															Alignment.LEADING)
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(18)
																			.addComponent(
																					scrollPane_1,
																					GroupLayout.PREFERRED_SIZE,
																					198,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel.createSequentialGroup()
																			.addGap(83)
																			.addComponent(
																					btnElimina,
																					GroupLayout.PREFERRED_SIZE,
																					38,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(16)));

					list_2 = new JList();
					listModel = new DefaultListModel();
					
					ArrayList<String> managers = new ArrayList<String>();
					
					try {
						managers = (ArrayList<String>) business.execute("getManagers", null);
					} catch (SecurityException | NoSuchMethodException
							| ClassNotFoundException | InstantiationException
							| IllegalAccessException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					for (String str : managers) {
						listModel.addElement(str);
					}
					
					list_2.setModel(listModel);

					list_2.addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent arg0) {
							btnElimina.setEnabled(true);
						}

					});
					
					btnElimina.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							boolean done = false;
							
							try {
								done = (boolean) business.execute("deleteManager", list_2.getSelectedValue());
							} catch (SecurityException | NoSuchMethodException
									| ClassNotFoundException
									| InstantiationException
									| IllegalAccessException | SQLException e) {
								JOptionPane.showMessageDialog(null,
										"Errore. Il manager \""+list_2.getSelectedValue()+"\" non può essere eliminato perchè al momento gestisce delle competizioni.",
										"Attenzione", 0);
							}
							
							if (done) {

								JOptionPane.showMessageDialog(null,
										"Manager eliminato correttamente!",
										"Successo", 1);
								
								listModel.removeElement(list_2.getSelectedValue());
								list_2.setModel(listModel);
							
							}
							
						}
						
					});
					
					scrollPane_1.setViewportView(list_2);
					panel.setLayout(gl_panel);

					panel.revalidate();

				}

			}

		});

		JLabel lblNewLabel_1 = new JLabel("Seleziona Operazione da effettuare:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadAdminFrame();
			}

		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(127)
																		.addComponent(
																				lblNewLabel,
																				GroupLayout.PREFERRED_SIZE,
																				446,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(179)
																		.addComponent(
																				lblNewLabel_1,
																				GroupLayout.PREFERRED_SIZE,
																				342,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(56, Short.MAX_VALUE))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap(270, Short.MAX_VALUE)
										.addComponent(comboBox,
												GroupLayout.PREFERRED_SIZE,
												167, GroupLayout.PREFERRED_SIZE)
										.addGap(263))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(307)
										.addComponent(btnNewButton_1,
												GroupLayout.PREFERRED_SIZE, 86,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(307, Short.MAX_VALUE))
						.addGroup(
								Alignment.LEADING,
								groupLayout
										.createSequentialGroup()
										.addGap(55)
										.addComponent(panel,
												GroupLayout.PREFERRED_SIZE,
												591, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(54, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGap(98)
						.addComponent(lblNewLabel)
						.addGap(47)
						.addComponent(lblNewLabel_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(72)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262,
								GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(btnNewButton_1,
								GroupLayout.PREFERRED_SIZE, 39,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(24, Short.MAX_VALUE)));

		setLayout(groupLayout);

	}

	/**
	 * Load login frame.
	 */
	private void loadAdminFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("adminHome", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Reload frame.
	 */
	private void reloadFrame() {

		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		try {
			frontController.processRequest("adminManagers", frame, null);
		} catch (SecurityException | NoSuchMethodException
				| ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
