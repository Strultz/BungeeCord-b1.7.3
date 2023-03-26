package net.md_5.bungee.api.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.plugin.Cancellable;

/**
 * Event called when a plugin message is sent to the client or server.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PluginMessageEvent extends TargetedEvent implements Cancellable
{

    /**
     * Cancelled state.
     */
    private boolean cancelled;
    /**
     * Data contained in this plugin message.
     */
    private final byte[] data;

    public PluginMessageEvent(Connection sender, Connection receiver, byte[] data)
    {
        super( sender, receiver );
        this.data = data;
    }
}
