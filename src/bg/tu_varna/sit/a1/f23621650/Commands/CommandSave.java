package bg.tu_varna.sit.a1.f23621650.Commands;

import bg.tu_varna.sit.a1.f23621650.StarWarsUniverse;

public class CommandSave implements Command{
    private final StarWarsUniverse universe;

    public CommandSave() {
        this.universe = StarWarsUniverse.getInstance();
    }

    @Override
    public void execute(String[] input) {
        universe.save();
    }
}
