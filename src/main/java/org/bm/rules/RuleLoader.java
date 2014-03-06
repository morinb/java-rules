package org.bm.rules;

import java.io.IOException;
import java.util.Collection;

/**
 * Interface that describe how to load a set of rules.
 *
 * @author Baptiste Morin
 *
 */
public interface RuleLoader {
   Collection<Rule> load() throws IOException, IllegalAccessException, InstantiationException;
}
