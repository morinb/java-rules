package org.bm.rules;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * An entry associate two objects to create aKey with them.
 *
 * @author Baptiste Morin
 */
public final class KeyPair<First, Second> {
   private final First first;
   private final Second second;

   private final Logger LOG = Logger.getLogger(KeyPair.class);

   public KeyPair(First first, Second second) {
      checkNull(first, second);
      this.first = first;
      this.second = second;
   }

   public First getFirst() {
      return first;
   }

   public Second getSecond() {
      return second;
   }

   private void checkNull(Object... os) {
      for (Object o : os) {
         if (o == null) {
            String message = "Argument must not be null";
            if (LOG.isEnabledFor(Level.ERROR)) {
               LOG.error(message);
            }
            throw new IllegalArgumentException(message);
         }
      }
   }

}
