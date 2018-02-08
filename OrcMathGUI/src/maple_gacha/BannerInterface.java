package maple_gacha;

import java.util.ArrayList;

public interface BannerInterface {
	void summonBanner(int idx);
	ArrayList<Hero> setPotentialChars();
	int bannerType();
}
