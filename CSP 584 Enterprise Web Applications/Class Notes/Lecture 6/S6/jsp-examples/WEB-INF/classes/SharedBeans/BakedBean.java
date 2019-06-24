package SharedBeans;

/** Small bean to illustrate various bean-sharing mechanisms.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class BakedBean {
  private String level = "half-baked";
  private String goesWith = "hot dogs";

  public String getLevel() {
    return(level);
  }
  
  public void setLevel(String newLevel) {
    level = newLevel;
  }

  public String getGoesWith() {
    return(goesWith);
  }
  
  public void setGoesWith(String dish) {
    goesWith = dish;
  }
}
