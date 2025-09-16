package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet65Close extends DefinedPacket
{

    private byte windowId;

    private Packet65Close()
    {
        super( 0x65 );
    }
	
	public Packet65Close(int windowId)
    {
		this( (byte) windowId );
	}

    public Packet65Close(byte windowId)
    {
        this();
        this.windowId = windowId;
    }

    @Override
    public void read(ByteBuf buf)
    {
        windowId = buf.readByte();
    }

    @Override
    public void write(ByteBuf buf)
    {
        buf.writeByte( windowId );
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
