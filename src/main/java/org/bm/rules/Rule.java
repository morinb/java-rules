package org.bm.rules;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContextAware;

/**
 * Rule interface.<br/>
 * Describes the contract for each rules.
 *
 * @author Baptiste Morin
 */
public interface Rule extends Comparable<Rule>, ApplicationContextAware {
    Logger LOG = Logger.getLogger(Rule.class);

    /**
     * Apply the rule to the input parameter, and produces a <code>Result</code>
     *
     * @param entry The entry on which the rule will be applied.
     * @return <code>Result</code> that contains the
     */
    Result apply(Entry entry);

    /**
     * @return rule's description.
     */
    String getDescription();


    /**
     * @return the priority to order the rules.
     */
    long getPriority();

}
