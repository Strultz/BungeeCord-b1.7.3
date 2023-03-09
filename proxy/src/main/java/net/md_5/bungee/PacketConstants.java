package net.md_5.bungee;

import net.md_5.bungee.protocol.packet.Packet9Respawn;

public class PacketConstants
{

    public static final Packet9Respawn DIM1_SWITCH = new Packet9Respawn( (byte) 1 );
    public static final Packet9Respawn DIM2_SWITCH = new Packet9Respawn( (byte) -1 );
}
