package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Objects.EObject;
import Objects.Line;
import Objects.Project;
import Objects.Source;
import Objects.Switcher;
import Objects.Transformer;
import Relays.DistanceProtection;
import Threads.ConnectionThread;
import Threads.MainThread;
import Threads.MovingObject;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

import MovableObjects.EMovableObject;
import MovableObjects.KzSigh;
import java.awt.Choice;
import java.awt.Button;

public class Screen3 extends JPanel {

//	private BufferedImage image;
	
	public MovingObject mo;
	public MainThread a2;
	private Screen3 thisScreen;
	
	private JFrame a;
	
	public boolean isRunning = true;
	
	private EMovableObject ChoosenObject;
	
	
	private JButton deleteButton;
	
	private JTextField InCoord;
	private JTextField OutCoord;
	private JLabel InCoordLabel;
	private JLabel OutCoordLabel;
	private JButton setCoordButton;
	
	private JTextField Rud;
	private JTextField Xud;
	private JLabel RudLabel;
	private JLabel XudLabel;
	private JLabel LudLabel;
	private JTextField Lud;
	private JButton setResButton;
	private JTextField Xmax;
	private JTextField Xmin;
	private JLabel XmaxLabel;
	private JLabel XminLabel;
	private JButton newSourceButton;
	private JButton btnNewButton;
	private JCheckBox isRegimeMin;
	private JCheckBox switchOnOff;
	private JButton switchButton;
	private JButton btnNewButton_1;
	private JButton downloadBtn;
	private JButton saveButton;
	private JButton NewDZButton;
	private JToggleButton ReleButton;
	private JTextField E;
	private JLabel ELabel;
	private JButton setKZ;
	private Choice KzChoice;
	private JButton btnKzChoice;
	private JTextField highTransf;
	private JTextField lowTransf;
	private JLabel highTransfLabel;
	private JLabel lowTransfLabel;
	private JButton btnNewButton_2;
	private JButton newTransf;
	
	// create screen
	public Screen3() {
	//	new ConnectionThread(this).start();
		
		thisScreen = this;
		
		Graphics g2 = this.getGraphics();
	
		//init JFrame and JPanel
		a = new JFrame();
		a.setMinimumSize(new Dimension (700,400));
		a.setVisible(true);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.getContentPane().add(this);
		a.setLocationRelativeTo(null);
		
		
		
		Screen3 thisScreen = this;
		
		
		// create listener for JFrame
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}


			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				
			}


			@Override
			public void mouseExited(MouseEvent arg0) {
			
				
			}


			@Override
			public void mousePressed(MouseEvent arg0) {
			
				
				int dx;
				int dy;
				for (int i = 0; i < Project.getMovableList().size(); i++)
				{
					
					if  (
							Project.getMovableList().get(i).getX() + EObject.HEIGHT > arg0.getX()
							&&
							Project.getMovableList().get(i).getY() + EObject.WIDTH > arg0.getY() 
							&&
							Project.getMovableList().get(i).getX() < arg0.getX()
							&&
							Project.getMovableList().get(i).getY() < arg0.getY()
						)
						{
						
						if (ChoosenObject != null)
						  if (ChoosenObject.getClass() == DistanceProtection.class && Project.getMovableList().get(i).getClass() == Switcher.class)
						  {
							  
							  Switcher tempSw = (Switcher) Project.getMovableList().get(i);
							  DistanceProtection temp = (DistanceProtection) ChoosenObject;
							  temp.setSwitcher(tempSw);
							  
						  }
						
						
						
						ChoosenObject = Project.getMovableList().get(i);
						
						if (ChoosenObject.getClass() == Line.class)
						{
							Line l = (Line) ChoosenObject;
							
							setKZ.setVisible(true);
							
							Xmax.setVisible(false);
							Xmin.setVisible(false);
							XminLabel.setVisible(false);
							XmaxLabel.setVisible(false);
							btnNewButton.setVisible(false);
							isRegimeMin.setVisible(false);
							E.setVisible(false);
							ELabel.setVisible(false);
							
							switchOnOff.setVisible(false);
							switchButton.setVisible(false);
							
							Rud.setVisible(true);
							Xud.setVisible(true);
							Lud.setVisible(true);
							RudLabel.setVisible(true);
							XudLabel.setVisible(true);
							LudLabel.setVisible(true);
							setResButton.setVisible(true);
							
							Rud.setText(l.getRud()  + "");
							Xud.setText(l.getX1ud() + "");
							Lud.setText(l.getL()    + "");
							
							ReleButton.setVisible(false);
							
							KzChoice.setVisible(false);
							btnKzChoice.setVisible(false);
							
							
							highTransfLabel.setVisible(false);
							highTransf.setVisible(false);
							lowTransfLabel.setVisible(false);
							lowTransf.setVisible(false);
							
						}
							
						
						if (ChoosenObject.getClass() == Source.class)
						{
							
							setKZ.setVisible(false);
							
							Source s = (Source) ChoosenObject;
							
							Xmax.setVisible(true);
							Xmin.setVisible(true);
							XminLabel.setVisible(true);
							XmaxLabel.setVisible(true);
							isRegimeMin.setVisible(true);
							btnNewButton.setVisible(true);
							E.setVisible(true);
							ELabel.setVisible(true);
							
							switchOnOff.setVisible(false);
							switchButton.setVisible(false);
							
							Rud.setVisible(false);
							Xud.setVisible(false);
							Lud.setVisible(false);
							RudLabel.setVisible(false);
							XudLabel.setVisible(false);
							LudLabel.setVisible(false);
							setResButton.setVisible(false);
							
							Xmax.setText(s.getXcmax() + "");
							Xmin.setText(s.getXcmin() + "");
							
							ReleButton.setVisible(false);
							
							KzChoice.setVisible(false);
							btnKzChoice.setVisible(false);
							
							if (s.getIsMin())
								isRegimeMin.setSelected(true);
							else
								isRegimeMin.setSelected(false);
							
							
							highTransfLabel.setVisible(false);
							highTransf.setVisible(false);
							lowTransfLabel.setVisible(false);
							lowTransf.setVisible(false);
							
						}
						
						
						if (ChoosenObject.getClass() == KzSigh.class)
						{
							
							setKZ.setVisible(false);
							
							KzSigh sigh = (KzSigh) ChoosenObject;
							
							Xmax.setVisible(false);
							Xmin.setVisible(false);
							XminLabel.setVisible(false);
							XmaxLabel.setVisible(false);
							isRegimeMin.setVisible(false);
							btnNewButton.setVisible(false);
							E.setVisible(false);
							ELabel.setVisible(false);
							
							switchOnOff.setVisible(false);
							switchButton.setVisible(false);
							
							Rud.setVisible(false);
							Xud.setVisible(false);
							Lud.setVisible(false);
							RudLabel.setVisible(false);
							XudLabel.setVisible(false);
							LudLabel.setVisible(false);
							setResButton.setVisible(false);
							
							
							
							ReleButton.setVisible(false);
							
							KzChoice.setVisible(true);
							btnKzChoice.setVisible(true);
							
							KzChoice.select(sigh.getKzType());
							
							System.out.println(KzChoice.getSelectedIndex());
							
							highTransfLabel.setVisible(false);
							highTransf.setVisible(false);
							lowTransfLabel.setVisible(false);
							lowTransf.setVisible(false);
						
						
							
						}
						
						
						
						if (ChoosenObject.getClass() == Switcher.class)
						{
							Switcher s = (Switcher) ChoosenObject;
							
							setKZ.setVisible(false);
							
							Xmax.setVisible(false);
							Xmin.setVisible(false);
							XminLabel.setVisible(false);
							XmaxLabel.setVisible(false);
							isRegimeMin.setVisible(false);
							btnNewButton.setVisible(false);
							E.setVisible(false);
							ELabel.setVisible(false);
							
							switchOnOff.setVisible(true);
							switchButton.setVisible(true);
							
							Rud.setVisible(false);
							Xud.setVisible(false);
							Lud.setVisible(false);
							RudLabel.setVisible(false);
							XudLabel.setVisible(false);
							LudLabel.setVisible(false);
							setResButton.setVisible(false);
							
							switchOnOff.setSelected(s.getSwitchPosition());
							
							ReleButton.setVisible(false);
							
							KzChoice.setVisible(false);
							btnKzChoice.setVisible(false);
							
							highTransfLabel.setVisible(false);
							highTransf.setVisible(false);
							lowTransfLabel.setVisible(false);
							lowTransf.setVisible(false);
						}
						
						
						if (ChoosenObject.getClass() == DistanceProtection.class)
						{
							DistanceProtection s = (DistanceProtection) ChoosenObject;
							
							setKZ.setVisible(false);
							
							Xmax.setVisible(false);
							Xmin.setVisible(false);
							XminLabel.setVisible(false);
							XmaxLabel.setVisible(false);
							isRegimeMin.setVisible(false);
							btnNewButton.setVisible(false);
							E.setVisible(false);
							ELabel.setVisible(false);
							
							switchOnOff.setVisible(false);
							switchButton.setVisible(false);
							
							Rud.setVisible(false);
							Xud.setVisible(false);
							Lud.setVisible(false);
							RudLabel.setVisible(false);
							XudLabel.setVisible(false);
							LudLabel.setVisible(false);
							setResButton.setVisible(false);
							
							KzChoice.setVisible(false);
							
							ReleButton.setVisible(true);
							
							highTransfLabel.setVisible(false);
							highTransf.setVisible(false);
							lowTransfLabel.setVisible(false);
							lowTransf.setVisible(false);
							
							
							if (s.getSwitcher() != null && s.getSwitcher().getSwitchPosition())
							{
								ReleButton.setEnabled(true);
								ReleButton.setSelected(!s.getSwitcher().getSwitchPosition());
							}
							else
							{
								ReleButton.setEnabled(false);
								btnKzChoice.setVisible(false);
							}
							
		
						}
						
						
						
						if (ChoosenObject.getClass() == Transformer.class)
						{
							Transformer tr = (Transformer) ChoosenObject;
							
							setKZ.setVisible(false);
							
							
							
							Xmax.setVisible(false);
							Xmin.setVisible(false);
							XminLabel.setVisible(false);
							XmaxLabel.setVisible(false);
							isRegimeMin.setVisible(false);
							btnNewButton.setVisible(false);
							E.setVisible(false);
							ELabel.setVisible(false);
							
							switchOnOff.setVisible(false);
							switchButton.setVisible(false);
							
							Rud.setVisible(false);
							Xud.setVisible(false);
							Lud.setVisible(false);
							RudLabel.setVisible(false);
							XudLabel.setVisible(false);
							LudLabel.setVisible(false);
							setResButton.setVisible(false);
							
							KzChoice.setVisible(false);
							
							ReleButton.setVisible(false);
							
							
							highTransfLabel.setVisible(true);
							highTransf.setVisible(true);
							lowTransfLabel.setVisible(true);
							lowTransf.setVisible(true);
							
							
							highTransf.setText(tr.getHigh_wind()+"");
							lowTransf.setText(tr.getLow_wind()+"");
							
							ReleButton.setEnabled(false);
							btnKzChoice.setVisible(false);
						
		
						}
						
						
						
						
						
						
						
						
						
						
							
						
						dx = Project.getMovableList().get(i).getX()  - arg0.getX();
						dy = Project.getMovableList().get(i).getY()  - arg0.getY();
						
						
						Package Objects = EObject.class.getPackage();
						if (Project.getMovableList().get(i).getClass().getPackage() == Objects)
						{
							EObject temp = (EObject) Project.getMovableList().get(i);
							
							InCoord.setText(temp.getIn()+"");
							OutCoord.setText(temp.getOut()+"");
							
						}
						
						
						
						
						if (-dx < 5 && -dy > 10 && -dy < 25 && Project.getMovableList().get(i).getClass() != DistanceProtection.class && Project.getMovableList().get(i).getClass() != KzSigh.class)
						{
							EObject temp = (EObject) ChoosenObject;
							temp.setChoosingLeft();
						}
							
						else if (-dx > EObject.WIDTH - 5 && -dy > 10 && -dy < 25 && Project.getMovableList().get(i).getClass() != DistanceProtection.class && Project.getMovableList().get(i).getClass() != KzSigh.class)
						{
							EObject temp = (EObject) ChoosenObject;
							temp.setChoosingRight();
						}
							
							
						new MovingObject(ChoosenObject, thisScreen, dx-32 , dy-9).start();
						break;
						}
						
				}
			
			}


			@Override
			public void mouseReleased(MouseEvent arg0) {
			
				MovingObject.stopMoving();
			}
			
			
		});
		
		
// Interface itself
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{95, 97, 0, 0, 0, 67, 155, 89, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		// create JPanel and Listener
		JButton newLine = new JButton("\u041D\u043E\u0432\u0430\u044F \u043B\u0438\u043D\u0438\u044F");	
		newLine.setLayout(null);
		newLine.setBounds(10, 10, 10, 10);
		
		newLine.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  Line L2 = new Line(1, 0.1, 1.47, 0.84, 10);
		
		
			  
			  
			  
			  
			  thisScreen.repaint();
			  
		  }
		});
		GridBagConstraints gbc_newLine = new GridBagConstraints();
		gbc_newLine.anchor = GridBagConstraints.NORTHWEST;
		gbc_newLine.insets = new Insets(0, 0, 5, 5);
		gbc_newLine.gridx = 0;
		gbc_newLine.gridy = 0;
		add(newLine, gbc_newLine);
		
		newSourceButton = new JButton("\u041D\u043E\u0432\u044B\u0439 \u0438\u0441\u0442\u043E\u0447\u043D\u0438\u043A");
		newSourceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Source(7,1, 132.8, 10,15);
				thisScreen.repaint();
			}
		});
		GridBagConstraints gbc_newSourceButton = new GridBagConstraints();
		gbc_newSourceButton.insets = new Insets(0, 0, 5, 5);
		gbc_newSourceButton.gridx = 1;
		gbc_newSourceButton.gridy = 0;
		add(newSourceButton, gbc_newSourceButton);
		
		btnNewButton_1 = new JButton("\u041D\u043E\u0432\u044B\u0439 \u0432\u044B\u043A\u043B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new Switcher();
				thisScreen.repaint();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		// Button to delete element
		deleteButton = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Размер перед удалением - "+ Project.getMovableList().size());
				System.out.println("Размер перед удалением - "+ Project.getList().size());
				
				if (ChoosenObject.getClass() == Transformer.class)
				{
					Transformer tr = (Transformer) ChoosenObject;
					tr.setWindings(1, 1);
				}
				
				
				
				
				Project.getMovableList().remove(ChoosenObject);
				Project.getList().remove(ChoosenObject);
				
				if (ChoosenObject.getClass() == KzSigh.class)
				{
					KzSigh temp = (KzSigh) ChoosenObject;
					
					temp.getLine().getPointVout().setCoord(temp.getLine().getBoundedLine().getPointVout().getCoord());
					temp.getLine().setR(temp.getLine().getRmax());;
					
					
					Project.getMovableList().remove(temp.getLine().getBoundedLine());
					Project.getList().remove(temp.getLine().getBoundedLine());
					
					temp.getLine().setShortCircued(false);
					
					
					
					System.out.println("hi there!");
				}
				
				
				System.out.println("Размер  после удаления - "+ Project.getMovableList().size());
				System.out.println("Размер после удаления - "+ Project.getList().size());
				thisScreen.repaint();
				
				
			
			}
		});
		
		JButton CalculateButton = new JButton("Рассчитать");
		CalculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				
				Project.Action();
				thisScreen.repaint();
				
				
				System.out.println("Количество элементов  "+Project.getList().size());

				for (int i = 0; i <Project.getList().size(); i++)
				{
					System.out.println("Сопротивление "+Project.getList().get(i).getR() + " Ток -" + Project.getList().get(i).getI() );
				}
				
				
			}
		});
		
		NewDZButton = new JButton("\u041D\u043E\u0432\u0430\u044F \u0414\u0417");
		NewDZButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new DistanceProtection();
				thisScreen.repaint();
				
			}
		});
		GridBagConstraints gbc_NewDZButton = new GridBagConstraints();
		gbc_NewDZButton.insets = new Insets(0, 0, 5, 5);
		gbc_NewDZButton.gridx = 3;
		gbc_NewDZButton.gridy = 0;
		add(NewDZButton, gbc_NewDZButton);
		GridBagConstraints gbc_CalculateButton = new GridBagConstraints();
		gbc_CalculateButton.insets = new Insets(0, 0, 5, 5);
		gbc_CalculateButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_CalculateButton.gridx = 4;
		gbc_CalculateButton.gridy = 0;
		add(CalculateButton, gbc_CalculateButton);
		
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.insets = new Insets(0, 0, 5, 5);
		gbc_deleteButton.gridx = 5;
		gbc_deleteButton.gridy = 0;
		add(deleteButton, gbc_deleteButton);
		
		InCoordLabel = new JLabel("In coord");
		GridBagConstraints gbc_InCoordLabel = new GridBagConstraints();
		gbc_InCoordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_InCoordLabel.anchor = GridBagConstraints.EAST;
		gbc_InCoordLabel.gridx = 6;
		gbc_InCoordLabel.gridy = 0;
		add(InCoordLabel, gbc_InCoordLabel);
		
		InCoord = new JTextField();
		GridBagConstraints gbc_Xmax = new GridBagConstraints();
		gbc_Xmax.anchor = GridBagConstraints.EAST;
		gbc_Xmax.insets = new Insets(0, 0, 5, 0);
		gbc_Xmax.gridx = 7;
		gbc_Xmax.gridy = 0;
		add(InCoord, gbc_Xmax);
		InCoord.setColumns(10);
		
		downloadBtn = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		downloadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Project.LoadData();
				thisScreen.repaint();
				
			}
		});
		GridBagConstraints gbc_downloadBtn = new GridBagConstraints();
		gbc_downloadBtn.insets = new Insets(0, 0, 5, 5);
		gbc_downloadBtn.gridx = 0;
		gbc_downloadBtn.gridy = 1;
		add(downloadBtn, gbc_downloadBtn);
		
		saveButton = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Project.SaveData();
				
			}
		});
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 5, 5);
		gbc_saveButton.gridx = 1;
		gbc_saveButton.gridy = 1;
		add(saveButton, gbc_saveButton);
		
		setKZ = new JButton("\u0423\u0441\u0442. \u041A\u0417 ");
		setKZ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Line temp = (Line) ChoosenObject;
				
			//	new KzSigh(ChoosenObject.getX()-7, ChoosenObject.getX()+ChoosenObject.getImage().getHeight()+7, ChoosenObject.getY()+ ChoosenObject.getImage().getWidth()  );
				temp.setKz();
				thisScreen.repaint();
			}
		});
		GridBagConstraints gbc_setKZ = new GridBagConstraints();
		gbc_setKZ.insets = new Insets(0, 0, 5, 5);
		gbc_setKZ.gridx = 2;
		gbc_setKZ.gridy = 1;
		add(setKZ, gbc_setKZ);
		
		newTransf = new JButton("\u041D\u043E\u0432\u044B\u0439 \u0442\u0440\u0430\u043D\u0441\u0444.");
		newTransf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Transformer();
				thisScreen.repaint();
				
				
			}
		});
		GridBagConstraints gbc_newTransf = new GridBagConstraints();
		gbc_newTransf.insets = new Insets(0, 0, 5, 5);
		gbc_newTransf.gridx = 3;
		gbc_newTransf.gridy = 1;
		add(newTransf, gbc_newTransf);
		
		OutCoordLabel = new JLabel("Out coord");
		GridBagConstraints gbc_OutCoordLabel = new GridBagConstraints();
		gbc_OutCoordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_OutCoordLabel.anchor = GridBagConstraints.EAST;
		gbc_OutCoordLabel.gridx = 6;
		gbc_OutCoordLabel.gridy = 1;
		add(OutCoordLabel, gbc_OutCoordLabel);
		
		OutCoord = new JTextField();
		GridBagConstraints gbc_OutCoord = new GridBagConstraints();
		gbc_OutCoord.insets = new Insets(0, 0, 5, 0);
		gbc_OutCoord.anchor = GridBagConstraints.EAST;
		gbc_OutCoord.gridx = 7;
		gbc_OutCoord.gridy = 1;
		add(OutCoord, gbc_OutCoord);
		OutCoord.setColumns(10);
		
		setCoordButton = new JButton("Установить координаты");
		setCoordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int in = Integer.parseInt(InCoord.getText());
				int out = Integer.parseInt(OutCoord.getText());
				
				if (ChoosenObject.getClass() != DistanceProtection.class)
				{
					EObject temp = (EObject) ChoosenObject;
					temp.setCoord(in, out);
				}
				
				thisScreen.repaint();
				
				
			}
		});
		GridBagConstraints gbc_setCoordButton = new GridBagConstraints();
		gbc_setCoordButton.insets = new Insets(0, 0, 5, 0);
		gbc_setCoordButton.gridx = 7;
		gbc_setCoordButton.gridy = 2;
		add(setCoordButton, gbc_setCoordButton);
		
		RudLabel = new JLabel("R\u0443\u0434");
		GridBagConstraints gbc_RudLabel = new GridBagConstraints();
		gbc_RudLabel.anchor = GridBagConstraints.EAST;
		gbc_RudLabel.insets = new Insets(0, 0, 5, 5);
		gbc_RudLabel.gridx = 6;
		gbc_RudLabel.gridy = 3;
		add(RudLabel, gbc_RudLabel);
		
		Rud = new JTextField();
		GridBagConstraints gbc_Rud = new GridBagConstraints();
		gbc_Rud.anchor = GridBagConstraints.EAST;
		gbc_Rud.insets = new Insets(0, 0, 5, 0);
		gbc_Rud.gridx = 7;
		gbc_Rud.gridy = 3;
		add(Rud, gbc_Rud);
		Rud.setColumns(10);
		
		XudLabel = new JLabel("X\u0443\u0434");
		GridBagConstraints gbc_XudLabel = new GridBagConstraints();
		gbc_XudLabel.insets = new Insets(0, 0, 5, 5);
		gbc_XudLabel.anchor = GridBagConstraints.EAST;
		gbc_XudLabel.gridx = 6;
		gbc_XudLabel.gridy = 4;
		add(XudLabel, gbc_XudLabel);
		
		Xud = new JTextField();
		GridBagConstraints gbc_Xud = new GridBagConstraints();
		gbc_Xud.insets = new Insets(0, 0, 5, 0);
		gbc_Xud.anchor = GridBagConstraints.EAST;
		gbc_Xud.gridx = 7;
		gbc_Xud.gridy = 4;
		add(Xud, gbc_Xud);
		Xud.setColumns(10);
		
		LudLabel = new JLabel("L");
		GridBagConstraints gbc_LudLabel = new GridBagConstraints();
		gbc_LudLabel.anchor = GridBagConstraints.EAST;
		gbc_LudLabel.insets = new Insets(0, 0, 5, 5);
		gbc_LudLabel.gridx = 6;
		gbc_LudLabel.gridy = 5;
		add(LudLabel, gbc_LudLabel);
		
		Lud = new JTextField();
		GridBagConstraints gbc_Lud = new GridBagConstraints();
		gbc_Lud.insets = new Insets(0, 0, 5, 0);
		gbc_Lud.anchor = GridBagConstraints.EAST;
		gbc_Lud.gridx = 7;
		gbc_Lud.gridy = 5;
		add(Lud, gbc_Lud);
		Lud.setColumns(10);
		
		setResButton = new JButton("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C \u0441\u043E\u043F\u0440\u043E\u0442\u0438\u0432\u043B\u0435\u043D\u0438\u0435");
		setResButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Line a = (Line) ChoosenObject;
				double Xud2 = Double.parseDouble(Xud.getText());
				double Rud2 = Double.parseDouble(Rud.getText());
				double L = Double.parseDouble(Lud.getText());
				
				a.setL(L);
				a.setR(Rud2*L);
				a.setX1ud(Xud2);
				a.setRud(Rud2);
				
				thisScreen.repaint();
			}
		});
		GridBagConstraints gbc_setResButton = new GridBagConstraints();
		gbc_setResButton.insets = new Insets(0, 0, 5, 0);
		gbc_setResButton.gridx = 7;
		gbc_setResButton.gridy = 6;
		add(setResButton, gbc_setResButton);
		
		XmaxLabel = new JLabel("Xmax");
		GridBagConstraints gbc_XmaxLabel = new GridBagConstraints();
		gbc_XmaxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_XmaxLabel.anchor = GridBagConstraints.EAST;
		gbc_XmaxLabel.gridx = 6;
		gbc_XmaxLabel.gridy = 7;
		add(XmaxLabel, gbc_XmaxLabel);
		
		Xmax = new JTextField();
		GridBagConstraints gbc_Xmax1 = new GridBagConstraints();
		gbc_Xmax1.anchor = GridBagConstraints.EAST;
		gbc_Xmax1.insets = new Insets(0, 0, 5, 0);
		gbc_Xmax1.gridx = 7;
		gbc_Xmax1.gridy = 7;
		add(Xmax, gbc_Xmax1);
		Xmax.setColumns(10);
		
		XminLabel = new JLabel("Xmin");
		GridBagConstraints gbc_XminLabel = new GridBagConstraints();
		gbc_XminLabel.insets = new Insets(0, 0, 5, 5);
		gbc_XminLabel.anchor = GridBagConstraints.EAST;
		gbc_XminLabel.gridx = 6;
		gbc_XminLabel.gridy = 8;
		add(XminLabel, gbc_XminLabel);
		
		Xmin = new JTextField();
		GridBagConstraints gbc_Xmin = new GridBagConstraints();
		gbc_Xmin.insets = new Insets(0, 0, 5, 0);
		gbc_Xmin.anchor = GridBagConstraints.EAST;
		gbc_Xmin.gridx = 7;
		gbc_Xmin.gridy = 8;
		add(Xmin, gbc_Xmin);
		Xmin.setColumns(10);
		
		switchButton = new JButton("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C \u043F\u043E\u043B\u043E\u0436\u0435\u043D\u0438\u0435 \u0432\u044B\u043A\u043B");
		switchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Switcher a = (Switcher) ChoosenObject;
				a.setSwitch(switchOnOff.isSelected());
				thisScreen.repaint();
			}
		});
		
		btnNewButton = new JButton("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C \u0441\u043E\u043F\u0440\u043E\u0442.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Source a = (Source) ChoosenObject;
				
				double a1 = Double.parseDouble(Xmax.getText());
				double a2 = Double.parseDouble(Xmin.getText());
				
				a.setXcmax(a1);
				a.setXcmin(a2);
				
			if	( isRegimeMin.isSelected() )
				 a.setR(a2); 
			else
				a.setR(a1);
			
			a.setIsMin(isRegimeMin.isSelected());
				
			thisScreen.repaint();
				
			}
		});
		
		ELabel = new JLabel("E");
		GridBagConstraints gbc_ELabel = new GridBagConstraints();
		gbc_ELabel.insets = new Insets(0, 0, 5, 5);
		gbc_ELabel.anchor = GridBagConstraints.EAST;
		gbc_ELabel.gridx = 6;
		gbc_ELabel.gridy = 9;
		add(ELabel, gbc_ELabel);
		
		E = new JTextField();
		GridBagConstraints gbc_E = new GridBagConstraints();
		gbc_E.anchor = GridBagConstraints.EAST;
		gbc_E.insets = new Insets(0, 0, 5, 0);
		gbc_E.gridx = 7;
		gbc_E.gridy = 9;
		add(E, gbc_E);
		E.setColumns(10);
		
		isRegimeMin = new JCheckBox("\u041C\u0438\u043D\u0438\u043C\u0430\u043B\u044C\u043D\u044B\u0439");
		GridBagConstraints gbc_isRegimeMin = new GridBagConstraints();
		gbc_isRegimeMin.insets = new Insets(0, 0, 5, 0);
		gbc_isRegimeMin.gridx = 7;
		gbc_isRegimeMin.gridy = 10;
		add(isRegimeMin, gbc_isRegimeMin);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 11;
		add(btnNewButton, gbc_btnNewButton);
		
		switchOnOff = new JCheckBox("\u0412\u043A\u043B\u044E\u0447\u0435\u043D");
		GridBagConstraints gbc_switchOnOff = new GridBagConstraints();
		gbc_switchOnOff.insets = new Insets(0, 0, 5, 0);
		gbc_switchOnOff.gridx = 7;
		gbc_switchOnOff.gridy = 12;
		add(switchOnOff, gbc_switchOnOff);
		GridBagConstraints gbc_switchButton = new GridBagConstraints();
		gbc_switchButton.insets = new Insets(0, 0, 5, 0);
		gbc_switchButton.gridx = 7;
		gbc_switchButton.gridy = 13;
		add(switchButton, gbc_switchButton);
		
		ReleButton = new JToggleButton("\u0412\u043A\u043B\u044E\u0447\u0438\u0442\u044C");
		GridBagConstraints gbc_ReleButton = new GridBagConstraints();
		gbc_ReleButton.insets = new Insets(0, 0, 5, 0);
		gbc_ReleButton.gridx = 7;
		gbc_ReleButton.gridy = 14;
		add(ReleButton, gbc_ReleButton);
		
		KzChoice = new Choice();
		GridBagConstraints gbc_KzChoice = new GridBagConstraints();
		gbc_KzChoice.insets = new Insets(0, 0, 5, 0);
		gbc_KzChoice.gridx = 7;
		gbc_KzChoice.gridy = 15;
		add(KzChoice, gbc_KzChoice);
		
		btnKzChoice = new JButton("\u0423\u0441\u0442. \u0432\u0438\u0434 \u041A\u0417");
		btnKzChoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				KzSigh temp = (KzSigh) ChoosenObject;
				temp.setKzType(KzChoice.getSelectedIndex());
				
					
				
				
			}
		});
		GridBagConstraints gbc_btnKzChoice = new GridBagConstraints();
		gbc_btnKzChoice.insets = new Insets(0, 0, 5, 0);
		gbc_btnKzChoice.gridx = 7;
		gbc_btnKzChoice.gridy = 16;
		add(btnKzChoice, gbc_btnKzChoice);
		
		highTransfLabel = new JLabel("\u0412\u0438\u0442\u043A\u0438 \u043D\u0430 \u0432\u044B\u0441\u0448\u0435\u0439");
		GridBagConstraints gbc_highTransfLabel = new GridBagConstraints();
		gbc_highTransfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_highTransfLabel.anchor = GridBagConstraints.EAST;
		gbc_highTransfLabel.gridx = 6;
		gbc_highTransfLabel.gridy = 17;
		add(highTransfLabel, gbc_highTransfLabel);
		
		highTransf = new JTextField();
		GridBagConstraints gbc_highTransf = new GridBagConstraints();
		gbc_highTransf.anchor = GridBagConstraints.EAST;
		gbc_highTransf.insets = new Insets(0, 0, 5, 0);
		gbc_highTransf.gridx = 7;
		gbc_highTransf.gridy = 17;
		add(highTransf, gbc_highTransf);
		highTransf.setColumns(10);
		
		lowTransfLabel = new JLabel("\u0412\u0438\u0442\u043A\u0438 \u043D\u0430 \u043D\u0438\u0437\u0448\u0435\u0439");
		GridBagConstraints gbc_lowTransfLabel = new GridBagConstraints();
		gbc_lowTransfLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lowTransfLabel.anchor = GridBagConstraints.EAST;
		gbc_lowTransfLabel.gridx = 6;
		gbc_lowTransfLabel.gridy = 18;
		add(lowTransfLabel, gbc_lowTransfLabel);
		
		lowTransf = new JTextField();
		GridBagConstraints gbc_lowTransf = new GridBagConstraints();
		gbc_lowTransf.anchor = GridBagConstraints.EAST;
		gbc_lowTransf.insets = new Insets(0, 0, 5, 0);
		gbc_lowTransf.gridx = 7;
		gbc_lowTransf.gridy = 18;
		add(lowTransf, gbc_lowTransf);
		lowTransf.setColumns(10);
		
		btnNewButton_2 = new JButton("\u0423\u0441\u0442\u0430\u043D\u043E\u0432\u0438\u0442\u044C \u0432\u0438\u0442\u043A\u0438");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Transformer tr = (Transformer) ChoosenObject;
				
		

				
				
				tr.setWindings(Double.parseDouble(highTransf.getText())  ,Double.parseDouble(lowTransf.getText()));
				

				
				
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 7;
		gbc_btnNewButton_2.gridy = 19;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		KzChoice.add("2-ф КЗ без земли");
		KzChoice.add("3-ф КЗ");
		
		
		ReleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DistanceProtection a = (DistanceProtection) ChoosenObject;
				
				
			
				a.getSwitcher().setSwitch(false);

				thisScreen.repaint();
			}
		});
		
		
		// pack everything to the JFrame
		a.pack();
	}
// finish interface	
	
	// draw picture
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        
        
        
    for (int i = 0; i < Project.getMovableList().size(); i++)
    {
    	
    	Package Objects = EObject.class.getPackage();
    	boolean isEObject = (Project.getMovableList().get(i).getClass().getPackage() == Objects);	
    	
        	EMovableObject a = Project.getMovableList().get(i);
        	
        	if (Project.getMovableList().get(i).getClass() == Line.class || Project.getMovableList().get(i).getClass() == Source.class ||
        			Project.getMovableList().get(i).getClass() == Switcher.class || Project.getMovableList().get(i).getClass() == Transformer.class )
        		a = (EObject) Project.getMovableList().get(i);
        	
        	// Проверка, является ли элемент частью электросети
       if(isEObject)
        {
    	   
    	    EObject temp = (EObject) Project.getMovableList().get(i);
    	    double temp_I = new BigDecimal(temp.getI()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    	    double temp_R = new BigDecimal(temp.getR()).setScale(2, RoundingMode.HALF_UP).doubleValue();
    	    
    	    
        	String Current = "I = "+ temp_I + "";
        	if (  a.getClass() != Source.class  )
            	g.drawString(  Current , a.getX(), a.getY()-10  );
        	
        	
        	String R = "R = "+ temp_R + "";
        	g.drawString(  R , a.getX(), a.getY()-20  );
        	
    
        	
        	try
      		{
          	 String InOutCoord =  temp.getIn() + "  " + temp.getOut();
         	g.drawString(  InOutCoord , a.getX(), a.getY()  ); 
         	g.drawString(  a.getX()+"  "+a.getY()  , a.getX(), a.getY()+80  ); 
         	
      		}
      		catch(Exception e)
      		{}
        	
        
        	
        
    	  
    	  
      
        	
        	
        	try
        	{
        		 double temp_Vin = new BigDecimal(temp.getVin()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        		 double temp_Vout = new BigDecimal(temp.getVout()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        		
        		  String fi =  "fi_in = "+ temp_Vin +" || fi_out = "+ temp_Vout;
              	  g.drawString(  fi , a.getX(), a.getY()-30  );
        	}
        	catch(Exception e)
        	{}
        	
        }
       else
       {
    	   
    	   try
    	   {
    		   KzSigh temp = (KzSigh) Project.getMovableList().get(i);
    		   g.drawString(  temp.getLine().getPercentage()+" %", temp.getX(), temp.getY()+temp.getImage().getHeight()+25  );
    	   }
    	   catch(Exception e)
    	   {}
    	 
    	   
    	  
    	   try
    	   {
    		   DistanceProtection DP = (DistanceProtection) Project.getMovableList().get(i);
    			 double temp_imp = new BigDecimal(DP.getImpedance()).setScale(3, RoundingMode.HALF_UP).doubleValue();
    		   
    	g.drawString( "II stage = "+ DP.getSecondStage()+"" , DP.getX(), DP.getY()-20  );
    	g.drawString( "I stage = "+ DP.getFirstStage()+"" , DP.getX(), DP.getY()-30  );
    		   g.drawString(  temp_imp+"" , DP.getX(), DP.getY()-40  );
    	   }
    	   catch(Exception e)
    	   {}
    	   
    	  
    	   
    	   
       }
        	
       
       
       
//      		
        		if (a == ChoosenObject)
        			g.drawImage(a.getImageChoosen(), a.getX(), a.getY(), this);
        		else
            		{ g.drawImage(a.getImage(), a.getX(), a.getY(), this);  }
        		
        	//finish pictures of objects
        }
        
    
    
        

    }
	

	  
	  
	  public void DrawSomeLine(int x1, int y1, int x2, int y2, Graphics g)
	  {
		  	int Xpr = x2;
		  	int Ypr = y1;

		  
		  	int xWidth = x2-x1-8;
		  	int yWidth = 1;
		  	
		  g.fillRect(x1, y1, xWidth, yWidth);
		  
		  int xx = x1 + xWidth;
		  int yy = y1 ;
		  
		  int xWidth2 = 1;
		  int yWidth2 = y2-y1-30;
		  
		  g.fillRect(xx, yy, xWidth2, yWidth2);

		  
		  	int width = 1;
		  	
		  
	  }



	  
	

}
