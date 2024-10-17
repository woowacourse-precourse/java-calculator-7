package calculator.service;

class CharacterSequenceSeparator implements NumberSeparator {

    private final String separateCharacterSequence;

    public CharacterSequenceSeparator(final String separateCharacterSequence) {
        this.separateCharacterSequence = separateCharacterSequence;
    }


    @Override
    public boolean available(final String numberMessage) {
        if (numberMessage.startsWith(this.separateCharacterSequence)) {
            return true;
        }
        return false;
    }

    @Override
    public int getLength() {
        return separateCharacterSequence.length();
    }

    @Override
    public String extract(final String numberMessage) {
        if (this.available(numberMessage)) {
            return numberMessage.substring(this.separateCharacterSequence.length());
        } else {
            throw new IllegalArgumentException("잘못된 numberMessage : " + numberMessage);
        }
    }
}
