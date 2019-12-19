package sample;

public class Evidence {

    private String gender;
    private String tool;
    private String place;
    private String time;
    private String picture;


    public Evidence(String gender, String tool, String place, String time, String picture) {
        this.gender = gender;
        this.tool = tool;
        this.place = place;
        this.time = time;
        this.picture = picture;
    }

    public String getGender() {
        return gender;
    }

    public String getTool() {
        return tool;
    }

    public String getPlace() {
        return place;
    }

    public String getTime() {
        return time;
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "gender='" + gender + '\'' +
                ", tool='" + tool + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evidence evidence = (Evidence) o;

        if (!gender.equals(evidence.gender)) return false;
        if (!tool.equals(evidence.tool)) return false;
        if (!place.equals(evidence.place)) return false;
        if (!time.equals(evidence.time)) return false;
        return picture.equals(evidence.picture);
    }

    @Override
    public int hashCode() {
        int result = gender.hashCode();
        result = 31 * result + tool.hashCode();
        result = 31 * result + place.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + picture.hashCode();
        return result;
    }
}

