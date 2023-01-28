public sealed abstract class VideoFile permits MP4{ // sealed class uses keyword permits to specify which classes can inherit from it
    public void playVideo(){
        System.out.println("loading video...");
    }
}
