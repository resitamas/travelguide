package sap.com.travelguide.ui;

/**
 * Created by I344065 on 2018. 01. 18..
 */

public class ListItem {

    private int index;
    private int type;

    public ListItem(int index, int type) {
        this.index = index;
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
