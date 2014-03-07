package org.bm.rules.impl;

import org.apache.commons.lang.StringUtils;
import org.bm.rules.Entry;

/**
 * @author Baptiste Morin
 */
public class StringEntry implements Entry {
   private final String entry;

   public StringEntry(final String entry) {
      this.entry = entry;
   }

   @Override
   public String getContent() {
      return entry;
   }

   @Override
   public String toString() {
      return getClass().getName() + "{" + StringUtils.abbreviate(entry, 25) + '}';
   }
}
