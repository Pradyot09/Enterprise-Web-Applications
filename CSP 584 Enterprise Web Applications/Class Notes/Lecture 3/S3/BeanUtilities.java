

import java.util.*;
import javax.servlet.http.*;
import org.apache.commons.beanutils.BeanUtils;

/** Some utilities to populate beans, usually based on
 *  incoming request parameters. Requires three packages
 *  from the Apache Commons library: beanutils, collections,
 *  and logging. To obtain these packages, see
 *  http://jakarta.apache.org/commons/. Also, the book's
 *  source code archive (see http://www.coreservlets.com/)
 *  contains links to all URLs mentioned in the book, including
 *  to the specific sections of the Jakarta Commons package.
 *  <P>
 *  Note that this class is in the coreservlets.beans package,
 *  so must be installed in .../coreservlets/beans/.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class BeanUtilities {
  /** Examines all of the request parameters to see if
   *  any match a bean property (i.e., a setXxx method)
   *  in the object. If so, the request parameter value
   *  is passed to that method. If the method expects
   *  an int, Integer, double, Double, or any of the other
   *  primitive or wrapper types, parsing and conversion
   *  is done automatically. If the request parameter value
   *  is malformed (cannot be converted into the expected
   *  type), numeric properties are assigned zero and boolean
   *  properties are assigned false: no exception is thrown.
   */
  
  public static void populateBean(Object formBean,
                                  HttpServletRequest request) {
    populateBean(formBean, request.getParameterMap());
  }

  /** Populates a bean based on a Map: Map keys are the
   *  bean property names; Map values are the bean property
   *  values. Type conversion is performed automatically as
   *  described above.
   */
  
  public static void populateBean(Object bean,
                                  Map propertyMap) {
    try {
      BeanUtils.populate(bean, propertyMap);
    } catch(Exception e) {
      // Empty catch. The two possible exceptions are
      // java.lang.IllegalAccessException and
      // java.lang.reflect.InvocationTargetException.
      // In both cases, just skip the bean operation.
    }
  }
}
