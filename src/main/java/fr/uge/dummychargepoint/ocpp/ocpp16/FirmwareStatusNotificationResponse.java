package fr.uge.dummychargepoint.ocpp.ocpp16;

import fr.uge.dummychargepoint.ocpp.OcppMessageResponse;

/**
 * Empty packet sent by the server to acknowledge the {@link FirmwareStatusNotificationRequest}.
 */
public record FirmwareStatusNotificationResponse() implements OcppMessageResponse {
}
