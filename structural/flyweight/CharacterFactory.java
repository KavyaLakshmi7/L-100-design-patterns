import java.util.*;

public class CharacterFactory {
    private static final Map<String, CharacterType> cache = new HashMap<>();

    public static CharacterType getCharacterType(String name, String sprite, int basePower) {
        String key = name + "|" + sprite + "|" + basePower;
        CharacterType type = cache.get(key);
        if (type == null) {
            type = new CharacterType(name, sprite, basePower);
            cache.put(key, type);
            System.out.println("[Factory] Created CharacterType -> " + key);
        } else {
            System.out.println("[Factory] Reused existing CharacterType -> " + key);
        }
        return type;
    }

    public static List<CharacterType> listTypes() {
        return new ArrayList<>(cache.values());
    }

    public static int uniqueCount() {
        return cache.size();
    }
}
