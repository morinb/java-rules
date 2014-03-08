package org.bm.rules.impl;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.bm.rules.KeyPair;

/**
 * An entry associate two objects to create aKey with them.
 *
 * @author Baptiste Morin
 */
public final class KeyPairImpl<First, Second> implements KeyPair<First, Second> {
   private final First first;
   private final Second second;

   private final Logger LOG = Logger.getLogger(KeyPairImpl.class);

   public KeyPairImpl(First first, Second second) {
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

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      KeyPair keyPair = (KeyPairImpl) o;

      if (!first.equals(keyPair.getFirst())) return false;
      if (!second.equals(keyPair.getSecond())) return false;

      return true;
   }

   @Override
   public int hashCode() {
      int result = first.hashCode();
      result = 31 * result + second.hashCode();
      return result;
   }
}
