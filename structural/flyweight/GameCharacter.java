public class GameCharacter {
    private static int NEXT_ID = 1;

    private final int id;
    private int x;
    private int y;
    private CharacterType characterType; 
    private WeaponType weaponType;       

    public GameCharacter(CharacterType characterType, WeaponType weaponType, int x, int y) {
        this.id = NEXT_ID++;
        this.characterType = characterType;
        this.weaponType = weaponType;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public void render() {
        System.out.print("#" + id + " -> ");
        characterType.render(x, y, weaponType);
    }
}
