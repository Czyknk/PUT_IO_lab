package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){

        SystemMonitor monitor = new SystemMonitor();

        // tworzymy obserwatora i dodajemy do monitora
        SystemStateObserver infObserver =  new SystemInfoObserver();
        monitor.addSystemStateObserver(infObserver);

        SystemStateObserver coolerObserver =  new SystemCoolerObserver();
        monitor.addSystemStateObserver(coolerObserver);

        SystemStateObserver garbCollObserver =  new SystemGarbageCollectorObserver();
        monitor.addSystemStateObserver(garbCollObserver);

        SystemStateObserver devObserver =  new USBDeviceObserver();
        monitor.addSystemStateObserver(devObserver);

        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
