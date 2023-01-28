public class instanceOf {
    public static void instanceChecker(){
        AbstractFile abstractFile = new MusicFile();
        useInstanceOf(abstractFile);
    }

    public static void useInstanceOf(AbstractFile abstractFile){
        if(abstractFile instanceof MusicFile musicFile){
            musicFile.playMusic();
        } else System.out.println("NOT an instance of MusicFile");
    }
}