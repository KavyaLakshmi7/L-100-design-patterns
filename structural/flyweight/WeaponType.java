public final class WeaponType {
    private final String name;
    private final String sprite;
    private final int damage;

    public WeaponType(String name, String sprite, int damage) {
        this.name = name;
        this.sprite = sprite;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getSprite() {
        return sprite;
    }

    public int getDamage() {
        return damage;
    }
}
