import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.*;
public class ChessBoard extends JFrame {
	JButton [][]bt=new JButton[8][8];
	public ChessBoard()
	{
		super("Chess Board");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		addButtons();
		setVisible(true);	
	}
	private void addButtons()
	{
		setLayout(new GridLayout(8,8));
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				bt[i][j]=new JButton();
				if((i+j)%2==0)
				{
					bt[i][j].setBackground(Color.white);
				}
				else
				{
					bt[i][j].setBackground(Color.black);
				}
				add(bt[i][j]);
			}
		}
		setImage();
	}
	private void setImage()
	{
	     ImageIcon iconbp =new ImageIcon(getClass().getResource("image/bp.gif"));
		 ImageIcon iconwp =new ImageIcon(getClass().getResource("image/wp.gif"));
		for(int i=0;i<8;i++)
		{
			ImageIcon icon1 =new ImageIcon(getClass().getResource("image/b"+i+".gif"));
			bt[0][i].setIcon(icon1);
			bt[1][i].setIcon(iconbp);
			ImageIcon icon2 =new ImageIcon(getClass().getResource("image/w"+i+".gif"));
			bt[7][i].setIcon(icon2);
			bt[6][i].setIcon(iconwp);
		}
	}
	
	
    public static void main(String []args)
		{
			new ChessBoard();
		}
	}
	
	


