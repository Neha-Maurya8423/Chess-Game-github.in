import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TicTacToe extends JFrame {
	JLabel img =new JLabel(new ImageIcon(getClass().getResource("Image/t2.jpg")));
	JPanel[]pa=new JPanel[3];
	JLabel msg=new JLabel("First player turn.....");
	JButton[]bt=new JButton[9];
	JButton reset=new JButton("RESET");
	ImageIcon icon1 =new ImageIcon(getClass().getResource("Image/user1.png"));
    ImageIcon icon2 =new ImageIcon(getClass().getResource("Image/user2.png"));
    int user=1;
    boolean winnerFound=false;
	public  TicTacToe()
	{
		super(" TicTacToe");
		setSize(500,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		add(img);
		addPanels();
		setVisible(true);
	}
	private void addPanels() {
		img.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			img.add(pa[i]);
		}
		pa[0].setBounds(50,30,400,40);
		pa[1].setBounds(50,100,400,400);
		pa[2].setBounds(50,530,400,40);
	  addInfo();
	}
	private void addInfo()
	{
		pa[0].add(msg);
		msg.setFont(new Font("elephent",Font.PLAIN,25));
		msg.setForeground(Color.blue);
		pa[2].add(reset);
		pa[2].setOpaque(false);
		reset.setFont(new Font("arial",0,20));
		addButtons();
	}
	private void addButtons() {
		pa[1].setLayout(new GridLayout(3,3));
		Border border=BorderFactory.createLineBorder(Color.red,2);
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].addActionListener(listener);
			bt[i].setBackground(Color.yellow);
			bt[i].setBorder(border);
			pa[1].add(bt[i]);
		}
		
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			
			JButton bb=(JButton)evt.getSource();
			if(bb.getIcon()!=null||winnerFound)//if click button has image
			{
				return;
			}
			if(user==1)//for first user
			{
			  bb.setIcon(icon1);
			  msg.setText("Second player turn...");
			  user=2;
			  findWinner(icon1);
			}
			else if(user==2)
			{
				bb.setIcon(icon2); //for second user
				 msg.setText("First player turn...");
				user=1;
				findWinner(icon2);
			}
		}
    private void findWinner(ImageIcon icon)
    {
    	if(bt[0].getIcon()==icon && bt[1].getIcon()==icon && bt[2].getIcon()==icon)   	
    		announceWinner(icon,0,1,2);
    	if(bt[3].getIcon()==icon && bt[4].getIcon()==icon && bt[5].getIcon()==icon)   	
    		announceWinner(icon,3,4,5);
    	if(bt[6].getIcon()==icon && bt[7].getIcon()==icon && bt[8].getIcon()==icon)   	
    		announceWinner(icon,6,7,8);
    	if(bt[0].getIcon()==icon && bt[3].getIcon()==icon && bt[6].getIcon()==icon)   	
    		announceWinner(icon,0,3,6);
    	if(bt[1].getIcon()==icon && bt[4].getIcon()==icon && bt[7].getIcon()==icon)   	
    		announceWinner(icon,1,4,7);
    	if(bt[2].getIcon()==icon && bt[5].getIcon()==icon && bt[8].getIcon()==icon)   	
    		announceWinner(icon,2,5,8);
    	if(bt[0].getIcon()==icon && bt[4].getIcon()==icon && bt[8].getIcon()==icon)   	
    		announceWinner(icon,0,4,8);
    	if(bt[2].getIcon()==icon && bt[4].getIcon()==icon && bt[6].getIcon()==icon)   	
    		announceWinner(icon,2,4,6);
    }
		private void announceWinner(ImageIcon icon,int i,int j,int k)
		{
			if(icon==icon1)
			msg.setText("First player won..");
			if(icon==icon2)
				msg.setText("Second player won..");
			msg.setForeground(Color.green);
			winnerFound=true;
			bt[i].setBackground(Color.red);
			bt[j].setBackground(Color.red);
			bt[k].setBackground(Color.red);
		}
	}
	public static void main(String args[])
	{
		new TicTacToe();
	}
	

}
