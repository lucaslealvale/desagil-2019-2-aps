package br.pro.hashi.ensino.desagil.aps.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripleInputOrGateTest {
    private TripleInputOrGate gate;

    private void build(boolean a, boolean b, boolean c) {
        gate = new TripleInputOrGate();
        gate.connect(0, new MockEmitter(a));
        gate.connect(1, new MockEmitter(b));
        gate.connect(2, new MockEmitter(c));
    }

    @Test
    public void whenReceivingFalseAndFalseAndFalseShouldReturnFalse() {
        build(false, false, false);
        Assertions.assertFalse(gate.read());
    }

    @Test
    public void whenReceivingFalseAndFalseAndTrueShouldReturnTrue() {
        build(false, false, true);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueAndFalseShouldReturnTrue() {
        build(false, true, false);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseAndFalseShouldReturnTrue() {
        build(true, false, false);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueAndFalseShouldReturnTrue() {
        build(true, true, false);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndFalseAndTrueShouldReturnTrue() {
        build(true, false, true);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingFalseAndTrueAndTrueShouldReturnTrue() {
        build(false, true, true);
        Assertions.assertTrue(gate.read());
    }

    @Test
    public void whenReceivingTrueAndTrueAndTrueShouldReturnTrue() {
        build(true, true, true);
        Assertions.assertTrue(gate.read());
    }
}
