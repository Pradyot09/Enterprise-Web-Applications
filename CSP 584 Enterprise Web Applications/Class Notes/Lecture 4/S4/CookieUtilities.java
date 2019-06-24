

import javax.servlet.*;
import javax.servlet.http.*;

/** Two static methods for use in cookie handling.
 *  Updated to Java 5.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class CookieUtilities {

  /** Given the request object, a name, and a default value,
   *  this method tries to find the value of the cookie with
   *  the given name. If no cookie matches the name,
   *  the default value is returned.
   */

  public static String getCookieValue
                           (HttpServletRequest request,
                            String cookieName,
                            String defaultValue) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for(Cookie cookie: cookies) {
        if (cookieName.equals(cookie.getName())) {
          return(cookie.getValue());
        }
      }
    }
    return(defaultValue);
  }

  /** Given the request object and a name, this method tries
   *  to find and return the cookie that has the given name.
   *  If no cookie matches the name, null is returned.
   */

  public static Cookie getCookie(HttpServletRequest request,
                                 String cookieName) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for(Cookie cookie: cookies) {
        if (cookieName.equals(cookie.getName())) {
          return(cookie);
        }
      }
    }
    return(null);
  }
}
