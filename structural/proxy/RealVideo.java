public class RealVideo implements Video {
    private String userName;

    public RealVideo(String userName) {
        this.userName = userName;
    }

    @Override
    public void play(String videoName) {
        System.out.println("Streaming video: " + videoName + " for user: " + userName);
    }
}
