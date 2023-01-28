package SpotiJy;

public class Artist{
    private String firstName, lastName;
    private int birthYear;
    private Album[] albums;
    private Song[] singles;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Album[] getAlbums() {
        return albums;
    }

    public Song[] getSingles() {
        return singles;
    }

    public Song mostLikedSong(){
        Song res = this.getAlbums()[0].getSongs()[0];
        for(int i = 0; i < this.getAlbums().length; i++)
            for(int k = 0; k < this.getAlbums()[i].getSongs().length; k++)
                if(this.getAlbums()[i].getSongs()[k].getLikes() > res.getLikes()) res = this.getAlbums()[i].getSongs()[k];
        for(int j = 0; j < this.getSingles().length; j++)
            if(this.getSingles()[j].getLikes() > res.getLikes()) res = this.getSingles()[j];
        return res;
    }

    public Song leastLikedSong(){
        Song res = this.getAlbums()[0].getSongs()[0];
        for(int i = 0; i < this.getAlbums().length; i++)
            for(int k = 0; k < this.getAlbums()[i].getSongs().length; k++)
                if(this.getAlbums()[i].getSongs()[k].getLikes() < res.getLikes()) res = this.getAlbums()[i].getSongs()[k];
        for(int j = 0; j < this.getSingles().length; j++)
            if(this.getSingles()[j].getLikes() < res.getLikes()) res = this.getSingles()[j];
        return res;
    }

    public int totalLikes(){
        int sum = 0;
        for(int i = 0; i < this.getAlbums().length; i++){
            for(int k = 0; k < this.getAlbums()[i].getSongs().length; k++){
                sum += this.getAlbums()[i].getSongs()[k].getLikes();
            }
        }
        return sum;
    }

    public boolean isEqual(Artist other){
        return (this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName()) && this.getLastName() == other.getLastName());
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Name: " + this.getFirstName() + " " + this.getLastName() + ",Birth year:" + this.getBirthYear() + ",Total likes" + this.totalLikes());
        return builder.toString();
    }
}
