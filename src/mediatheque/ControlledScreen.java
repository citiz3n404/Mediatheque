
package mediatheque;


/**
 * @date    2 nov. 2016
 * @author  Anthony CHAFFOT
 * @author  Benjamin KRAFFT
 */
public abstract class ControlledScreen {
        
    protected Mediatheque       mediatheque;
    protected ScreensManager    sm;
    
    public void setScreenParent(ScreensManager screenPage) {
        this.sm = screenPage;
    }

    public void setDatas(Object o) {
        mediatheque = (Mediatheque) o;
        System.out.println("Mediatheque object loaded");
    }
    
    public abstract void updateAfterLoadingScreen();
}
