package temp;

/**
 * Created by student on 10/21/2014.
 */
public class Item {
    public Item(String na0me, String link) {
        this.na0me = na0me;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Item{" +
                "na0me='" + na0me + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public void setNa0me(String na0me) {
        this.na0me = na0me;
    }

    public void setLink(String link) {
        this.link = link;
    }

    private String na0me;
    private String link;
}
