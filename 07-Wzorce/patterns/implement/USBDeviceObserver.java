package put.io.patterns.implement;

public class USBDeviceObserver implements SystemStateObserver{
    private SystemState lastSystemState = null;
    int devices = 0;
    int devicesState =0;
    public void update(SystemMonitor monitor){

        lastSystemState = monitor.getLastSystemState();

        devices = lastSystemState.getUsbDevices();

        if (devicesState != devices){
            System.out.println(">State of USB devices changed, tej");
        }

        devicesState = lastSystemState.getUsbDevices();
    }
}
