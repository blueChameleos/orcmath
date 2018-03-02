package maple_gacha;

public interface Summoning {
	void changeBanner(String position);
	boolean canSummon(int type);
	void cantSummon();
}
