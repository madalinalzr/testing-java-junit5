package guru.springframework.sfgpetclinic.fauxspring;

import java.util.Map;

public interface Model {

    void addAttribute(String key, Object o);

    Map<String, Object> addAttribute(Object o);
}
