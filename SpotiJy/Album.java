package SpotiJy;

import java.util.Random;

public class Album{
    private String title;
    private int releaseYear;
    private Song[] songs;

    public Album(String title, int releaseYear, Song[] s){
        this.title = title;
        this.releaseYear = releaseYear;
        this.songs = s;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void print(Song[] arr){
        for(Song element : arr)
            System.out.println(element);
    }

    public int addSongs(Song[] songs) {
        if(songs != null && this.songs != null) {
            Song[] temporary = new Song[this.songs.length + songs.length];

            for(int i=0; i<this.songs.length; i++){
                temporary[i] = this.songs[i];
            }

            int tempIndex = 0;
            for(int i=this.songs.length; i< temporary.length; i++){
                temporary[i] = songs[tempIndex];
                tempIndex++;
            }

            for(int i=0; i < temporary.length; i++){
                for(int j=i+1; j < temporary.length; j++){
                    if(temporary[i] != null && temporary[j] != null && temporary[i].isEqual(temporary[j])){
                        temporary[j] = null;
                    }
                }
            }

            int nullCounter = 0;
            for(int i=0; i<temporary.length; i++){
                if(temporary[i] == null){
                    nullCounter++;
                }
            }

            Song[] finalArray = new Song[temporary.length - nullCounter];
            tempIndex = 0;
            for (int i = 0; i < temporary.length; i++) {
                if (temporary[i] != null) {
                    finalArray[tempIndex] = temporary[i];
                    tempIndex++;
                }
            }

            this.songs = finalArray;
            return nullCounter;
        }else if(songs != null && this.songs == null){
            this.songs = songs;
            return songs.length;
        }else{
            return 0;
        }
    }

    public Song[] shuffle(){
        Song[] result = new Song[this.songs.length];
        for(int i = 0; i < result.length; ++i){
            result[i] = this.songs[i];
        }

        Random generator = new Random();

        for(int i = 0; i < this.songs.length; ++i){
            int rand = generator.nextInt(this.songs.length);
            Song temp = result[rand];
            result[rand] = result[i];
            result[i] = temp;
        }

        return result;
    }

    public static Song[] reverse(Song[] songs){
        Song[] rev = new Song[songs.length];
        int revIndex = songs.length - 1;
        for(int i = 0; i < songs.length; ++i){
            rev[i] = songs[revIndex];
            revIndex--;
        }
        return rev;
    }

    public Song[] sortByTitle(boolean isAscending){
        Song[] sortedByTitle = new Song[this.songs.length];
        for(int i = 0; i < sortedByTitle.length; i++)
            sortedByTitle[i] = this.songs[i];


        for (int i = 0; i < this.songs.length - 1; i++) {
            for (int j = i + 1; j < sortedByTitle.length; j++) {
                if(sortedByTitle[i].getTitle().compareTo(sortedByTitle[j].getTitle()) > 0) {
                    Song temp = sortedByTitle[i];
                    sortedByTitle[i] = sortedByTitle[j];
                    sortedByTitle[j] = temp;
                }
            }
        }

        if(isAscending) return sortedByTitle;
        else return reverse(sortedByTitle);
    }

    public Song[] sortByDuration(boolean isAscending){
        Song[] sortedByDuration = new Song[this.songs.length];
        for(int i = 0; i < sortedByDuration.length; i++)
            sortedByDuration[i] = this.songs[i];

        for (int i = 0; i < sortedByDuration.length; i++) {
            for (int j = i + 1; j < sortedByDuration.length; j++) {
                if(sortedByDuration[i].getDuration() > sortedByDuration[j].getDuration()){
                    Song tmp = sortedByDuration[i];
                    sortedByDuration[i] = sortedByDuration[j];
                    sortedByDuration[j] = tmp;
                }
            }
        }

        if(isAscending) return sortedByDuration;
        else return reverse(sortedByDuration);
    }

    public Song[] sortByReleaseYear(boolean isAscending){
        Song[] sortedByReleaseYear = new Song[this.songs.length];
        for(int i = 0; i < sortedByReleaseYear.length; i++)
            sortedByReleaseYear[i] = this.songs[i];

        for (int i = 0; i < sortedByReleaseYear.length; i++) {
            for (int j = i + 1; j < sortedByReleaseYear.length; j++) {
                if(sortedByReleaseYear[i].getReleaseYear() > sortedByReleaseYear[j].getReleaseYear()){
                    Song tmp = sortedByReleaseYear[i];
                    sortedByReleaseYear[i] = sortedByReleaseYear[j];
                    sortedByReleaseYear[j] = tmp;
                }
            }
        }

        if(isAscending) return sortedByReleaseYear;
        else return reverse(sortedByReleaseYear);
    }

    public Song[] sortByPopularity(boolean isAscending){
        Song[] sortedByPopularity = new Song[this.songs.length];
        for(int i = 0; i < sortedByPopularity.length; i++)
            sortedByPopularity[i] = this.songs[i];

        for (int i = 0; i < sortedByPopularity.length; i++) {
            for (int j = i + 1; j < sortedByPopularity.length; j++) {
                if(sortedByPopularity[i].getLikes() > sortedByPopularity[j].getLikes()){
                    Song tmp = sortedByPopularity[i];
                    sortedByPopularity[i] = sortedByPopularity[j];
                    sortedByPopularity[j] = tmp;
                }
            }
        }

        if(isAscending) return sortedByPopularity;
        else return reverse(sortedByPopularity);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Title:" + this.getTitle() + ",Release Year:" + this.getReleaseYear() + ",songs:{");
        for(int i = 0; i < this.songs.length; i++){
            if(i != this.songs.length - 1) builder.append(this.songs[i].toString() + "|");
            else builder.append(this.songs[i].toString() + "}");
        }
        return builder.toString();
    }
}