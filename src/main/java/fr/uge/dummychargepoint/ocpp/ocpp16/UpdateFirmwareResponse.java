package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageResponse;

/**
 * An empty packet sent to the server to acknowledge the {@link UpdateFirmwareRequest}.
 */
public record UpdateFirmwareResponse() implements OcppMessageResponse {
}
