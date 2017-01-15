/**
 * Created by 33558 on 13.01.2017.
 */
@SaveTo(path = "c:\\dbFile.txt")
public class TextContainer {

    private String stringTextContainer = "String Text Container`s";

    public TextContainer() {}

    public TextContainer(String stringTextContainer) {
        this.stringTextContainer = stringTextContainer;
    }

    public String getStringTextContainer() {
        return stringTextContainer;
    }

    public void setStringTextContainer(String stringTextContainer) {
        this.stringTextContainer = stringTextContainer;
    }
}