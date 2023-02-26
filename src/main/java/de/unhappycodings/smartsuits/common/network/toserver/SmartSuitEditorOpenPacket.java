package de.unhappycodings.smartsuits.common.network.toserver;

import de.unhappycodings.smartsuits.common.container.SmartSuitEditorContainer;
import de.unhappycodings.smartsuits.common.network.base.IPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkHooks;

public class SmartSuitEditorOpenPacket implements IPacket {

    public SmartSuitEditorOpenPacket() {
    }

    public static SmartSuitEditorOpenPacket decode(FriendlyByteBuf buffer) {
        return new SmartSuitEditorOpenPacket();
    }

    @SuppressWarnings("ConstantConditions")
    public void handle(NetworkEvent.Context context) {
        ServerPlayer player = context.getSender();
        NetworkHooks.openGui(player, new SimpleMenuProvider((w, p, pl) -> new SmartSuitEditorContainer(w, p, player.getLevel(), 13), new TextComponent("")), uf -> {
        });

    }

    public void encode(FriendlyByteBuf buffer) {

    }

}
