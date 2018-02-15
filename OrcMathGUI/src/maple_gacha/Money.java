package maple_gacha;

public class Money {
	
	public int NX;
	
	public Money(){
		NX = 100;	
		
	}

	public void setNx(int NX) {
		this.NX = NX;
		System.out.println(NX);

	}

	
	public void removeNX()
	{
		NX = NX-5;
		System.out.println(NX);

	}
	
	public void addNX() {
		NX = NX+5;
		System.out.println(NX);
	}
	
	
}
