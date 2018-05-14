package spring.galery.exercise.data;

public class Picture {

    public Picture(){

    }
    public Picture(int index,String name,String resolution,long size, String created)
    {
        super();
        this.index=index;
        this.name=name;
        this.resolution=resolution;
        this.created=created;
        this.size=size;



    }

    private int index;
    private String name;
    private String resolution;
    private long size;
    private String created;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }


}
