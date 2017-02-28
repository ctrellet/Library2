package library.model;


import java.util.Objects;

public class CD {

    protected String title;

    protected int time;

    public CD(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return time == cd.time &&
                Objects.equals(title, cd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, time);
    }
}