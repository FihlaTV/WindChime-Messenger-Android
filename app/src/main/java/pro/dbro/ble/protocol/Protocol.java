package pro.dbro.ble.protocol;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by davidbrodsky on 10/20/14.
 */
public interface Protocol {

    /** Outgoing
     *
     * Serialize Protocol Objects to raw transmission data
    **/

    // TODO Decide on a consistent API here
    public byte[] serializeIdentity(@NonNull OwnedIdentityPacket ownedIdentity);

    public MessagePacket serializeMessage(@NonNull OwnedIdentityPacket ownedIdentity, String body);

    public NoDataPacket serializeNoDataPacket(@NonNull OwnedIdentityPacket ownedIdentity);

    /** Incoming
     *
     * Deserialize raw transmission data into Protocol Objects
     */

    public IdentityPacket deserializeIdentity(@NonNull byte[] identity);

    /** Deserialize a message where the author identity is known */
    public MessagePacket deserializeMessageWithIdentity(@NonNull byte[] message, @Nullable IdentityPacket identity);

    /** Deserialize a message where the author identity is not known */
    public MessagePacket deserializeMessage(@NonNull byte[] message);

    public byte getPacketType(@NonNull byte[] message);

}
