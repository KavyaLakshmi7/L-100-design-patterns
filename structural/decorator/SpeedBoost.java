public class SpeedBoost extends PowerUpDecorator {
    public SpeedBoost(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " + Speed Boost";
    }

    @Override
    public int getPower() {
        return character.getPower() + 5;
    }
}
