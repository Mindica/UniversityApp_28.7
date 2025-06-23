public enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    ECONOMICS("Экономика"),
    LAW("Юриспруденция"),
    IT("Информационные технологии");

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

    @Override
    public String toString() {
        return profileName;
    }
}