package org.bm.rules.impl;

import org.bm.rules.Entry;
import org.bm.rules.KeyPair;
import org.bm.rules.Result;
import org.bm.rules.Rule;
import org.bm.rules.Status;

/**
 * @author Baptiste Morin
 */
public final class DefaultResult implements Result {
   private Status status;
   private KeyPair<Entry, Rule> entryRuleKeyPair;

   public DefaultResult(Status status, KeyPair<Entry, Rule> entryRuleKeyPair) {
      this.status = status;
      this.entryRuleKeyPair = entryRuleKeyPair;
   }

   @Override
   public Status getStatus() {
      return status;
   }

    @Override
    public void setStatus(Status status) {
        throw new UnsupportedOperationException("DefaultResult class is immutable");
    }

    @Override
   public KeyPair<Entry, Rule> getEntryRuleKeyPair() {
      return entryRuleKeyPair;
   }

    @Override
    public void setEntryRuleKeyPair(KeyPair<Entry, Rule> entryRuleKeyPair) {
        throw new UnsupportedOperationException("DefaultResult class is immutable");
    }
}
