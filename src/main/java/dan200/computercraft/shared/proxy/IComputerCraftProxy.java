/*
 * This file is part of ComputerCraft - http://www.computercraft.info
 * Copyright Daniel Ratcliffe, 2011-2017. Do not distribute without permission.
 * Send enquiries to dratcliffe@gmail.com
 */

package dan200.computercraft.shared.proxy;

import dan200.computercraft.shared.command.text.TableBuilder;
import dan200.computercraft.shared.computer.blocks.TileComputer;
import dan200.computercraft.shared.computer.core.ClientComputer;
import dan200.computercraft.shared.computer.core.ComputerFamily;
import dan200.computercraft.shared.peripheral.diskdrive.TileDiskDrive;
import dan200.computercraft.shared.peripheral.printer.TilePrinter;
import dan200.computercraft.shared.turtle.blocks.TileTurtle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.File;

public interface IComputerCraftProxy
{
    void preInit();

    void init();

    void initServer( MinecraftServer server );

    Object getDiskDriveGUI( InventoryPlayer inventory, TileDiskDrive drive );

    Object getComputerGUI( TileComputer computer );

    Object getPrinterGUI( InventoryPlayer inventory, TilePrinter printer );

    Object getTurtleGUI( InventoryPlayer inventory, TileTurtle turtle );

    Object getPrintoutGUI( EntityPlayer player, EnumHand hand );

    Object getPocketComputerGUI( EntityPlayer player, EnumHand hand );

    Object getComputerGUI( ClientComputer computer, int width, int height, ComputerFamily family );

    File getWorldDir( World world );

    void playRecordClient( BlockPos pos, SoundEvent record, String info );

    void showTableClient( TableBuilder table );
}
