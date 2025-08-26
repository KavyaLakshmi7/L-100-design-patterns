public final class CharacterType {
    private final String name;
    private final String sprite;
    private final int basePower;

    public CharacterType(String name, String sprite, int basePower) {
        this.name = name;
        this.sprite = sprite;
        this.basePower = basePower;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    public int getBasePower() {
        return basePower;
    }

    public void render(int x, int y, WeaponType weapon) {
        System.out.printf("%s %s (power:%d) at (%d,%d) wielding %s %s (dmg:%d)%n",
            name, sprite, basePower, x, y,
            weapon.getName(), weapon.getSprite(), weapon.getDamage());
    }
}
