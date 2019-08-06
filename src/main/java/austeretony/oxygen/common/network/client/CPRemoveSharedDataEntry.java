package austeretony.oxygen.common.network.client;

import austeretony.oxygen.client.OxygenManagerClient;
import austeretony.oxygen.common.network.ProxyPacket;
import net.minecraft.network.INetHandler;
import net.minecraft.network.PacketBuffer;

public class CPRemoveSharedDataEntry extends ProxyPacket {

    private int index;

    public CPRemoveSharedDataEntry() {}

    public CPRemoveSharedDataEntry(int index) {
        this.index = index;
    }

    @Override
    public void write(PacketBuffer buffer, INetHandler netHandler) {
        buffer.writeInt(this.index);
    }

    @Override
    public void read(PacketBuffer buffer, INetHandler netHandler) {
        OxygenManagerClient.instance().getSharedDataManager().removePlyerSharedDataEntry(buffer.readInt());
    }
}