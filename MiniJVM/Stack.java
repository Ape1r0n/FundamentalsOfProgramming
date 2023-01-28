package MiniJVM;

public final class Stack {

    private int[] buffer;
    private int stackPointer;

    /**
     * Erstellt einen Stack mit der Kapazität {@code size}
     *
     * @param size Die Kapazität des zu erzeugenden Stacks.
     */
    public Stack(int size) {
        buffer = new int[size];
        stackPointer = -1;
    }

    /**
     * Liefert den Wert am Index des Stackpointers zurück und dekrementiert diesen.
     */
    public int pop() {
        return buffer[stackPointer--];
    }

    /**
     * Legt den Wert {@code value} auf den Stack. Der Stackpointer wird dabei inkrementiert.
     *
     * @param value Der auf den Stack zu legende Wert.
     */
    public void push(int value) {
        buffer[++stackPointer] = value;
    }

    /**
     * Addiert zum Stackpointer den Wert {@code count}. Dies entspricht einer Reservierung von Platz
     * im Stack für {@code count} Variablen.
     *
     * @param count Die Anzahl an Variablen für die Platz reserviert werden soll.
     */
    public void alloc(int count) {
        stackPointer += count;
    }

    /**
     * Liefert den Wert am Index {@code index} des Stacks zurück.
     */
    public int getValueAtIndex(int index) {
        return buffer[index];
    }

    /**
     * Setzt den Wert am Index {@code index} des Stacks auf den Wert {@code value}.
     */
    public void setValueAtIndex(int index, int value) {
        buffer[index] = value;
    }

    /**
     * Liefert den stackPointer
     *
     * @return
     */
    public int getStackPointer() {
        return stackPointer;
    }

    /**
     * Setzt den Stackpointer auf den übergebenen Wert,
     */
    public void setStackPointer(int stackPointer) {
        this.stackPointer = stackPointer;
    }

    /**
     * Liefert eine Stringdarstellung des Stacks.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("Stack:\n");

        for (int i = buffer.length - 1; i >= 0; i--) {
            builder.append(buffer[i]);
            builder.append('\n');
        }
        builder.append("Stackpointer: " + stackPointer + "\n");
        return builder.toString();
    }

}