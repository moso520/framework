package util.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PageObjectElement {
    public List<HashMap<String, List<String>>> getElements() {
        return elements;
    }

    public void setElements(List<HashMap<String, List<String>>> steps) {
        this.elements = steps;
    }

    public List<HashMap<String,List<String>>> elements = new ArrayList<>();
}
