public class ProxyVideo implements Video {
    private RealVideo realVideo;
    private String userName;
    private boolean isPremiumUser;

    public ProxyVideo(String userName, boolean isPremiumUser) {
        this.userName = userName;
        this.isPremiumUser = isPremiumUser;
    }

    @Override
    public void play(String videoName) {
        if (isPremiumUser) {
            if (realVideo == null) {
                realVideo = new RealVideo(userName);
            }
            realVideo.play(videoName);
        } else {
            System.out.println("Access Denied. Upgrade to premium to watch " + videoName);
        }
    }
}
