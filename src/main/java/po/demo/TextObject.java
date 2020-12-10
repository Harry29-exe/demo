package po.demo;

public class TextObject {
    private int id;
    private String text;
    private int hexColor;

    public TextObject() {
    }

    public TextObject(int id, String text, int hexColor) {
        this.id = id;
        this.text = text;
        this.hexColor = hexColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getHexColor() {
        return hexColor;
    }

    public void setHexColor(int hexColor) {
        this.hexColor = hexColor;
    }
}
