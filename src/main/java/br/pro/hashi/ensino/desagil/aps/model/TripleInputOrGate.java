package br.pro.hashi.ensino.desagil.aps.model;

public class TripleInputOrGate extends Gate {
    private final NandGate nand0;
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand5;


    public TripleInputOrGate() {
        super("TripleInputOR", 3);

        nand0 = new NandGate();
        nand1 = new NandGate();
        nand2 = new NandGate();
        NandGate nand3 = new NandGate();
        NandGate nand4 = new NandGate();
        nand5 = new NandGate();

        nand3.connect(0, nand0);
        nand3.connect(1, nand1);
        nand4.connect(0, nand3);
        nand4.connect(1, nand3);


        nand5.connect(0, nand4);
        nand5.connect(1, nand2);
    }


    @Override
    public boolean read(int outputPin) {
        if (outputPin != 0) {
            throw new IndexOutOfBoundsException(outputPin);
        }
        return nand5.read();
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                nand0.connect(0, emitter);
                nand0.connect(1, emitter);

                break;
            case 1:
                nand1.connect(0, emitter);
                nand1.connect(1, emitter);
                break;
            case 2:
                nand2.connect(0, emitter);
                nand2.connect(1, emitter);
                break;

            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
    }
}