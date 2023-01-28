package SpotiJy;

public class Song{
    private String title;
    private int releaseYear, duration, likes;

    public Song(String title, int releaseYear, int duration, int likes) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = likes;
    }

    public Song(String title, int releaseYear, int duration){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.likes = 0;
    }

    public Song(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = 60;
        this.likes = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public int getDuration() {
        return duration;
    }

    public int getLikes() {
        return likes;
    }

    public boolean changeDuration(int duration){
        if(duration < 0 || duration > 720 || this.duration == duration) return false;
        else this.duration = duration; return true;
    }

    public void like(){
        this.likes++;
    }

    public void unlike(){
        if(likes > 0) likes--;
    }

    public boolean isEqual(Song other){
        return (this.title.equals(other.title) && this.releaseYear == other.releaseYear && this.duration == other.duration);
    }

    public String toString() {
        return "Title:" + title + ",Duration:" + (double)duration/60 + " minutes,Release year:" + releaseYear + ",Likes:" + likes;
    }

//    public static void main(String[] args) {
//        Song countryRoads = new Song("Country Roads", 1991, 60, 2);
//        System.out.println(countryRoads.toString());
//    }
}