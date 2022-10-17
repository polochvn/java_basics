public class Track {
    private String nameTrack;
    private int durationTrack;
    private String authorTrack;
    private boolean affiliationAlbumTrack;

    public Track(String nameTrack, String authorTrack) {
        this.nameTrack = nameTrack;
        this.authorTrack = authorTrack;
    }

    public String getNameTrack() {
        return nameTrack;
    }

    public void setNameTrack(String nameTrack) {
        this.nameTrack = nameTrack;
    }

    public int getDurationTrack() {
        return durationTrack;
    }

    public void setDurationTrack(int durationTrack) {
        this.durationTrack = durationTrack;
    }

    public String getAuthorTrack() {
        return authorTrack;
    }

    public void setAuthorTrack(String authorTrack) {
        this.authorTrack = authorTrack;
    }

    public boolean getAffiliationAlbumTrack() {
        return affiliationAlbumTrack;
    }

    public void setAffiliationAlbumTrack(boolean affiliationAlbumTrack) {
        this.affiliationAlbumTrack = affiliationAlbumTrack;
    }
}
