package bg.tu_varna.sit.a1.f23621650;

import java.io.IOException;

public class UnsavedState implements State {
    @Override
    public void checkState() throws IOException {
        throw new IOException("Your work hasn't been saved! Loading a new file now will overwrite it!");
    }
}
