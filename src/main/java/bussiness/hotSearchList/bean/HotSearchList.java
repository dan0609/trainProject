package bussiness.hotSearchList.bean;

public class HotSearchList {
    private int type;
    private String hotSearchName;

    public int getType() {
        return type;
    }

    public String getHotSearchName() {
        return hotSearchName;
    }
    public static class hotSearchList{
        private long albumId;
        private String albumType;
        private int labelType;
        private String albumCover;
        private String albumTitle;
        private String albumIntro;
        private String tag;

        public long getAlbumId() {
            return albumId;
        }

        public String getAlbumType() {
            return albumType;
        }

        public int getLabelType() {
            return labelType;
        }

        public String getAlbumCover() {
            return albumCover;
        }

        public String getAlbumTitle() {
            return albumTitle;
        }

        public String getAlbumIntro() {
            return albumIntro;
        }

        public String getTag() {
            return tag;
        }
    }
}
