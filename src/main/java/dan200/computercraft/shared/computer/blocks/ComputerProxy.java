package dan200.computercraft.shared.computer.blocks;

import dan200.computercraft.shared.computer.core.IComputer;
import dan200.computercraft.shared.computer.core.ServerComputer;

/**
 * A proxy object for computer objects, delegating to {@link IComputer} or {@link TileComputer} where appropriate.
 */
public abstract class ComputerProxy
{
    protected abstract TileComputerBase getTile();

    public void turnOn()
    {
        TileComputerBase tile = getTile();
        ServerComputer computer = tile.getServerComputer();
        if( computer == null )
        {
            tile.m_startOn = true;
        }
        else
        {
            computer.turnOn();
        }
    }

    public void shutdown()
    {
        TileComputerBase tile = getTile();
        ServerComputer computer = tile.getServerComputer();
        if( computer == null )
        {
            tile.m_startOn = false;
        }
        else
        {
            computer.shutdown();
        }
    }

    public void reboot()
    {
        TileComputerBase tile = getTile();
        ServerComputer computer = tile.getServerComputer();
        if( computer == null )
        {
            tile.m_startOn = true;
        }
        else
        {
            computer.reboot();
        }
    }

    public int assignID()
    {
        TileComputerBase tile = getTile();
        ServerComputer computer = tile.getServerComputer();
        if( computer == null )
        {
            return tile.m_computerID;
        }
        else
        {
            return computer.getID();
        }
    }

    public boolean isOn()
    {
        ServerComputer computer = getTile().getServerComputer();
        return computer != null && computer.isOn();
    }

    public String getLabel()
    {
        TileComputerBase tile = getTile();
        ServerComputer computer = tile.getServerComputer();
        return computer == null ? tile.m_label : computer.getLabel();
    }
}
