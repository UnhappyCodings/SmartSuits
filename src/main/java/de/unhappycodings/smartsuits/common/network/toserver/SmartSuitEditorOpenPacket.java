package de.unhappycodings.smartsuits.common.network.toserver;

import de.unhappycodings.smartsuits.common.container.SmartSuitEditorContainer;
import de.unhappycodings.smartsuits.common.container.base.container.BaseContainer;
import de.unhappycodings.smartsuits.common.network.base.IPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
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

        if (player.getInventory() != null) {

        NetworkHooks.openGui(player, new SimpleMenuProvider((w, p, pl) ->
                new SmartSuitEditorContainer(w, p, player.getLevel(), 13), new TextComponent("")), uf -> {});

        }
    }

    public void encode(FriendlyByteBuf buffer) {

    }

}
