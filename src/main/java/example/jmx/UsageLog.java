package example.jmx;

/**
 * @Author Paul Bakker - paul.bakker@luminis.eu
 */
@JMXBean(objectName = "UsageLog")
public class UsageLog implements UsageLogMBean {
    public String[] getNames() {
        return new String[0];
    }
}
