package de.unhappycodings.smartsuits.common.network.toserver;

import de.unhappycodings.smartsuits.common.container.SmartSuitEditorContainer;
import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import de.unhappycodings.smartsuits.common.network.base.IPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

import java.util.UUID;

public class SmartSuitEditorOpenPacket implements IPacket {

    public SmartSuitEditorOpenPacket() {
    }

    public static SmartSuitEditorOpenPacket decode(FriendlyByteBuf buffer) {
        return new SmartSuitEditorOpenPacket();
    }

    @SuppressWarnings("ConstantConditions")
    public void handle(NetworkEvent.Context context) {
        ServerPlayer player = context.getSender();
        Level level = player.getCommandSenderWorld();

        System.out.println(player);
    }

    public void encode(FriendlyByteBuf buffer) {

    }
}