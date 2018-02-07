package maple_gacha;

import java.util.ArrayList;

public interface BannerInterface {
	void summonBanner(int idx);
	void setPotentialChars(ArrayList<Hero> chars, int type);
	void bannerType(int idx);
}
