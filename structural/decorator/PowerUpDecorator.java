public abstract class PowerUpDecorator implements Character {
    protected Character character;

    public PowerUpDecorator(Character character) {
        this.character = character;
    }

    @Override
    public String getDescription() {
        return character.getDescription();
    }

    @Override
    public int getPower() {
        return character.getPower();
    }
}
