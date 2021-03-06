package rules

import org.bm.rules.Entry
import org.bm.rules.Result
import org.bm.rules.Rule
import org.bm.rules.Status
import org.bm.rules.impl.DefaultResult
import org.bm.rules.impl.KeyPairImpl
import org.springframework.beans.BeansException
import org.springframework.context.ApplicationContext

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

            @Override
            boolean isErrorStatus() {
                return false
            }
        }, new KeyPairImpl<Entry, Rule>(entry, this))


        return result
    }

    @Override
    String getDescription() {
        return "Rule that does nothing"
    }

    @Override
    long getPriority() {
        return 0
    }

    @Override
    public String toString() {
        return getClass().getName();
    }

    @Override
    int compareTo(Rule o) {
        // something is always greater than null.
        if (o == null) {
            return 1
        }

        if (this == o) {
            return 0
        }

        return this.priority.compareTo(o.priority);
    }

    private ApplicationContext applicationContext
    @Override
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext
    }
}