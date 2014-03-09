package rules

import org.bm.rules.Entry
import org.bm.rules.Result
import org.bm.rules.Rule
import org.bm.rules.Status
import org.bm.rules.impl.DefaultResult
import org.bm.rules.impl.KeyPairImpl

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
            String getCode() {
                return "STATUS_OK"
            }

            @Override
            String getDescription() {
                return "No problemo rule"
            }

            @Override
            String getPossibleResolution() {
                return null
            }
        }, new KeyPairImpl<Entry, Rule>(entry, this))
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