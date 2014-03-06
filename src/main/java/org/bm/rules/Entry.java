package org.bm.rules;

import org.apache.log4j.Logger;

/**
 * The Entry interface, represents the object on which the Rule will be applied.
 *
 * @author Baptiste Morin
 */
public interface Entry {
   Logger LOG = Logger.getLogger(Entry.class);

   /**
    * Gets the Entry's content that will be checked by the Rule.
    * @return the Entry's content.
    */
   String getContent();

}
