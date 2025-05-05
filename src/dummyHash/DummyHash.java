package dummyHash;

import java.util.LinkedList;

public class DummyHash {
    LinkedList<String>[] data = new LinkedList[30];

    public DummyHash() {

    }

    public int dumbHash(String key) {
        StringBuilder str = new StringBuilder(key);
        return str.length();
    }

    public boolean contains(String key) {
        //check if key is contained within array
        for (LinkedList<String> datum : data) {
            if (datum.contains(key)) {
                return true;
            }
        }
        return false;
    }

    //creates new array double the specified size
    public void resize(int size) {
        LinkedList<String>[] newData = new LinkedList[size*2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
    }
}
