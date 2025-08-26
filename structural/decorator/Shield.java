public class Shield extends PowerUpDecorator {
    public Shield(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " + Shield";
    }

    @Override
    public int getPower() {
        return character.getPower() + 8;
    }
}
