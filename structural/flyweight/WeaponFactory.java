import java.util.*;

public class WeaponFactory {
    private static final Map<String, WeaponType> cache = new HashMap<>();

    public static WeaponType getWeaponType(String name, String sprite, int damage) {
        String key = name + "|" + sprite + "|" + damage;
        WeaponType wt = cache.get(key);
        if (wt == null) {
            wt = new WeaponType(name, sprite, damage);
            cache.put(key, wt);
            System.out.println("[Factory] Created WeaponType -> " + key);
        } else {
            System.out.println("[Factory] Reused existing WeaponType -> " + key);
        }
        return wt;
    }

    public static List<WeaponType> listTypes() {
        return new ArrayList<>(cache.values());
    }

    public static int uniqueCount() {
        return cache.size();
    }
}
