package fr.uge.dummychargepoint.ocpp.ocpp16.data;

/**
 * Defines the status used in {@link fr.uge.dummychargepoint.ocpp.ocpp16.FirmwareStatusNotificationRequest}.<br>
 * It can be :<br>
 * - Downloaded, the firmware has been downloaded ;<br>
 * - DownloadFailed, the firmware couldn't be downloaded ;<br>
 * - Downloading, the chargepoint currently downloads the firmware ;<br>
 * - Idle, the chargepoint is waiting for a process to finish before installing the firmware ;<br>
 * - InstallationFailed, the firmware couldn't be installed on the chargepoint ;<br>
 * - Installing, the chargepoint currently installs the firmware ;<br>
 * - Installed, the firmware has been installed on the chargepoint.
 */
public enum FirmwareStatus {

  DOWNLOADED("Downloaded"),
  DOWNLOAD_FAILED("DownloadFailed"),
  DOWNLOADING("Downloading"),
  IDLE("Idle"),
  INSTALLATION_FAILED("InstallationFailed"),
  INSTALLING("Installing"),
  INSTALLED("Installed");

  private final String status;

  FirmwareStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
