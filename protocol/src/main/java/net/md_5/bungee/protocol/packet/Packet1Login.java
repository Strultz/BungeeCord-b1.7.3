package net.md_5.bungee.protocol.packet;

import io.netty.buffer.ByteBuf;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Packet1Login extends DefinedPacket
{

    protected int entityId;
    protected String levelType;
    protected long seed;
    protected int dimension;

    protected Packet1Login()
    {
        super( 0x01 );
    }

    public Packet1Login(int entityId, String levelType, long seed, byte dimension)
    {
        this( entityId, levelType, seed, (int) dimension );
    }

    public Packet1Login(int entityId, String levelType, long seed, int dimension)
    {
        this();
        this.entityId = entityId;
        this.levelType = levelType;
        this.seed = seed;
        this.dimension = dimension;
    }

    @Override
    public void read(ByteBuf buf)
    {
        entityId = buf.readInt();
        levelType = readString( buf );
        seed = buf.readLong();
        dimension = buf.readByte();
    }

    @Override
    public void write(ByteBuf buf)
    {
        buf.writeInt( entityId );
        writeString( levelType, buf );
        buf.writeLong( seed );
        buf.writeByte( dimension );
    }

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception
    {
        handler.handle( this );
    }
}
