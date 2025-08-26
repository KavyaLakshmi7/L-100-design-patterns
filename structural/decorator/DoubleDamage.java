public class DoubleDamage extends PowerUpDecorator {
    public DoubleDamage(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " + Double Damage";
    }

    @Override
    public int getPower() {
        return character.getPower() + 15;
    }
}
