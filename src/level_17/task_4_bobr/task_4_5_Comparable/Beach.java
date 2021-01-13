package level_17.task_4_bobr.task_4_5_Comparable;

/*
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстоние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach b1 = new Beach("1", 500, 5);
        Beach b2 = new Beach("2", 400, 4);
        System.out.println(b1.compareTo(b2));
    }

    @Override
    public int compareTo(Beach o) {
        int dist = (int) (o.distance - this.distance);
        int qlt = this.quality - o.quality;
        return dist + qlt;
    }
}