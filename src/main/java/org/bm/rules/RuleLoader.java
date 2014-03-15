package org.bm.rules;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Interface that describe how to load a set of rules.
 *
 * @author Baptiste Morin
 *
 */
public interface RuleLoader {
   List<Rule> load() throws IOException, IllegalAccessException, InstantiationException;
}
