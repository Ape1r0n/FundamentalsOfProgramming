package SpotiJy;

public final class SpotiJy{
    private Artist[] artists;

    public SpotiJy() {
        this.artists = null;
    }

    public Artist[] getArtists() {
        return artists;
    }

    public void addArtists(Artist[] artists) {
        if(artists != null && this.artists != null) {
            Artist[] temporary = new Artist[this.artists.length + artists.length];

            for(int i=0; i<this.artists.length; i++){
                temporary[i] = this.artists[i];
            }

            int tempIndex = 0;
            for(int i=this.artists.length; i< temporary.length; i++){
                temporary[i] = artists[tempIndex];
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

            Artist[] finalArray = new Artist[temporary.length - nullCounter];
            tempIndex = 0;
            for (int i = 0; i < temporary.length; i++) {
                if (temporary[i] != null) {
                    finalArray[tempIndex] = temporary[i];
                    tempIndex++;
                }
            }

            this.artists = finalArray;
        }else{
            System.out.println("Either, this.songs or songs(maybe both) is null");
        }
    }

    public String[] getTopTrendingArtist(){
        Artist temp = artists[0];
        for(int i = 1; i < artists.length; ++i){
            if(artists[i].totalLikes() > temp.totalLikes()) temp = artists[i];
        }
        return new String[]{temp.getFirstName(),temp.getLastName()};
    }

    public Album getTopTrendingAlbum(){
        int[][] likes = new int[artists.length][];
        for(int i=0; i<artists.length; ++i){
            for(int j=0; j<artists[i].getAlbums().length; ++j){
                likes[i] = new int[artists[i].getAlbums().length];
            }
        }

        for(int i=0; i<artists.length; i++){
            for(int j=0; j<artists[i].getAlbums().length; j++){
                for(int k=0; k<artists[i].getAlbums()[j].getSongs().length; k++){
                    likes[i][j] += artists[i].getAlbums()[j].getSongs()[k].getLikes();
                }
            }
        }

        int[] maximumIndex = {0,0};
        for(int i=0; i<artists.length; ++i){
            for(int j=0; j<artists[i].getAlbums().length; ++j){
                if(likes[i][j] > likes[maximumIndex[0]][maximumIndex[1]]){
                    maximumIndex[0] = i;
                    maximumIndex[1] = j;
                }
            }
        }

        return artists[maximumIndex[0]].getAlbums()[maximumIndex[1]];
    }

    public Song getTopTrendingSong(){
        Song result = artists[0].mostLikedSong();
        for(int i=1; i<artists.length; i++){
            if(result.getLikes() < artists[i].mostLikedSong().getLikes())
                result = artists[i].mostLikedSong();
        }
        return result;
    }

}