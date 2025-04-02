package Player;
import java.util.Objects;

public record Item(String name) {

    @Override
    public String toString() {
        return "Item" +
                " name= " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

}
