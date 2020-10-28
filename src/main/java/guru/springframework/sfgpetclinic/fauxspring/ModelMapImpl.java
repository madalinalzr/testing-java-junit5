package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {
    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public Map<String, Object> addAttribute(Object o) {
        // do nothing...
        return null;
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
