package maple_gacha;

import java.util.ArrayList;

public interface BannerInterface {
	void summonBanner(int idx);
	void updateNX(int nx);
	void getNX(int nx);
	void setNX(int nx);
	void setPotentialChars(ArrayList<Hero> chars);
}
