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
    *
    * @param rule the <code>Rule</code> that could be applied to this entry if the method returns <code>true</code>.
    * @return <code>true</code> if the rule is allowed for this entry.
    */
   boolean supports(Rule rule);
}
