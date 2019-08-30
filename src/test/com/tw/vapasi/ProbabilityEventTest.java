package com.tw.vapasi;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class ProbabilityEventTest {

    @Nested
    class EqualsTest {
        @Test
        void expectTrueWhenEvent1ProbabilityValueEqualsEvent2ProbabilityValue() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent rainProbabilityEvent = new ProbabilityEvent(0.5);
            assertTrue(coinProbabilityEvent.equals(rainProbabilityEvent));
        }

        @Test
        void expectFalseWhenEvent1ProbabilityNotEqualsEvent2Probability() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent diceProbabilityEvent = new ProbabilityEvent(0.3);
            assertFalse(coinProbabilityEvent.equals(diceProbabilityEvent));
        }

        @Test
        void expectTrueWhenProbabilityEventReferencesAreSame() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent coinProbabilityEventAlias = coinProbabilityEvent;
            assertTrue(coinProbabilityEvent.equals(coinProbabilityEventAlias));
        }

        @Test
        void expectFalseWhenProbabilityEventReferencesAreNotSame() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent diceProbabilityEvent = new ProbabilityEvent(0.4);
            assertFalse(coinProbabilityEvent.equals(diceProbabilityEvent));
        }

        @Test
        void expectFalseWhenTwoReferencesAreofDifferentTypes() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            assertFalse(coinProbabilityEvent.equals(new String()));
        }

        @Test
        void expectFalseWhenOneOfTheReferencesIsNull() {
            ProbabilityEvent coinProbabilityEvent = new ProbabilityEvent(0.5);
            assertFalse(coinProbabilityEvent.equals(null));
        }
    }

    @Nested
    class HashcodeTest {
        @Test
        void expectTrueWhenHashcodeOfReferencesAreEqual() {
            ProbabilityEvent coinHeadProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent coinTailProbabilityEvent = new ProbabilityEvent(0.5);
            assertEquals(coinHeadProbabilityEvent.hashCode(), coinTailProbabilityEvent.hashCode());
        }

        @Test
        void expectFalseWhenHashcodeOfReferencesAreNotEqual() {
            ProbabilityEvent coinHeadProbabilityEvent = new ProbabilityEvent(0.2);
            ProbabilityEvent coinTailProbabilityEvent = new ProbabilityEvent(0.5);
            assertNotEquals(coinHeadProbabilityEvent.hashCode(), coinTailProbabilityEvent.hashCode());
        }
    }

    @Nested
    class ProbabilityOperationsTest {
        @Test
        void expect0_08whenHeadOnCoinEventANDsSixOnDiceEvent() {
            ProbabilityEvent coinHeadProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent diceProbabilityEvent = new ProbabilityEvent(0.16);
            assertEquals(new ProbabilityEvent(0.08), coinHeadProbabilityEvent.and(diceProbabilityEvent));
        }

        @Test
        void expect0_58whenHeadOnCoinEventORsSixOnDiceEvent() {
            ProbabilityEvent coinHeadProbabilityEvent = new ProbabilityEvent(0.5);
            ProbabilityEvent diceProbabilityEvent = new ProbabilityEvent(0.16);
            assertEquals(new ProbabilityEvent(0.58), coinHeadProbabilityEvent.or(diceProbabilityEvent));
        }

        @Test
        void expect0_75ForNOTOfHeadOnCoinEvent() {
            ProbabilityEvent coinHeadProbabilityEvent = new ProbabilityEvent(0.25);
            assertEquals(new ProbabilityEvent(0.75), coinHeadProbabilityEvent.not());
        }
    }
}
