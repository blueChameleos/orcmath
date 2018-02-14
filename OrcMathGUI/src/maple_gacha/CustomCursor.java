package maple_gacha;

import guiTeacher.userInterfaces.Screen;

import java.awt.*;

public class CustomCursor {
  
  public CustomCursor(Screen screen) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Image cursorImage = toolkit.getImage("resources/cursor.png");
    Point cursorHotSpot = new Point(0,0);
    Cursor customCursor = toolkit.createCustomCursor(cursorImage, cursorHotSpot, "Cursor");
    screen.setCursor(customCursor);
    
  }
  
  
}