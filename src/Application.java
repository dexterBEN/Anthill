
public class Application {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] map = new String[24][24];
		
		for(int i = 1; i <= map.length; i++) 
		{
			
			for(int j = 1; j <= map.length; j++) 
			{
				if (i == 1 || i == map.length)
                    System.out.print("* ");
                else if (j == 1 || j == map.length)
                    System.out.print("* ");
                else
                    System.out.print("  ");
			}
			System.out.println();
		}

	}

}
