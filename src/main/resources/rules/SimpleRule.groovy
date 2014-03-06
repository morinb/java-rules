package rules

import org.bm.rules.*
import org.bm.rules.impl.DefaultResult

/**
 *
 * @author Baptiste Morin
 */
class SimpleRule implements Rule {

    @Override
    Result apply(Entry entry) {
        DefaultResult result = new DefaultResult(new Status() {
            @Override
            int getSeverity() {
                return 0
            }

            @Override
            String getDescription() {
                return "No problemo"
            }

            @Override
            String getPossibleResolution() {
                return null
            }
        }, new KeyPair<Entry, Rule>(entry, this))
        return null
    }

    @Override
    String getDescription() {
        return "Rule that does nothing"
    }
}