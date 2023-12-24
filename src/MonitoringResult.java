public class MonitoringResult {
    public int resultID;
    public int monitoringID;
    public int indicatorID;
    public double resultValue;


    public int getResultID() {
        return resultID;
    }

    // 设置 ResultID
    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    // 获取 MonitoringID
    public int getMonitoringID() {
        return monitoringID;
    }

    // 设置 MonitoringID
    public void setMonitoringID(int monitoringID) {
        this.monitoringID = monitoringID;
    }

    // 获取 IndicatorID
    public int getIndicatorID() {
        return indicatorID;
    }

    // 设置 IndicatorID
    public void setIndicatorID(int indicatorID) {
        this.indicatorID = indicatorID;
    }

    // 获取 ResultValue
    public double getResultValue() {
        return resultValue;
    }

    // 设置 ResultValue
    public void setResultValue(double resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public String toString() {
        return "MonitoringResult{" +
                "resultID=" + resultID +
                ", monitoringID=" + monitoringID +
                ", indicatorID=" + indicatorID +
                ", resultValue=" + resultValue +
                '}';
    }
    // 省略构造方法和其他方法，可根据需要添加
}
