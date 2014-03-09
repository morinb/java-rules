package org.bm.rules;

/**
 * The Result is what he rules engine produces after applying a rule to its input.
 *
 * @author Baptiste Morin
 */
public interface Result {

    Status getStatus();

    void setStatus(Status status);

    KeyPair<Entry, Rule> getEntryRuleKeyPair();

    void setEntryRuleKeyPair(KeyPair<Entry, Rule> entryRuleKeyPair);

}
