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
                return "No problemo rule"
            }

            @Override
            String getPossibleResolution() {
                return null
            }
        }, new KeyPair<Entry, Rule>(entry, this))
        return result
    }

    @Override
    String getDescription() {
        return "Rule that does nothing"
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}