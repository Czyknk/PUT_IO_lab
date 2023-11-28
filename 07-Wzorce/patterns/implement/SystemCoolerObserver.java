package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver{
    private SystemState lastSystemState = null;
    public void update(SystemMonitor monitor){
        lastSystemState = monitor.getLastSystemState();

        // Increase CPU cooling if the temperature is to high
        if (lastSystemState.getCpuTemp() > 60.00){
            System.out.println("> Increasing cooling of the CPU...");
        }
    }
}
