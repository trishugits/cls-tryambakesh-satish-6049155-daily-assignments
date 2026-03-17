package assignment_7;

import java.util.List;

public class SBU {

    private String sbuCode;
    private String sbuName;
    private String sbuHead;
    private List<Employee> empList;

    public SBU() {}

    public String getSbuCode() {
        return sbuCode;
    }

    public void setSbuCode(String sbuCode) {
        this.sbuCode = sbuCode;
    }

    public String getSbuName() {
        return sbuName;
    }

    public void setSbuName(String sbuName) {
        this.sbuName = sbuName;
    }

    public String getSbuHead() {
        return sbuHead;
    }

    public void setSbuHead(String sbuHead) {
        this.sbuHead = sbuHead;
    }

    public List<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    @Override
    public String toString() {

        return "SBU details\n" +
               "-------------------------\n" +
               "sbuCode=" + sbuCode +
               ", sbuHead=" + sbuHead +
               ", sbuName=" + sbuName +
               "\nEmployee details:\n" +
               empList;
    }
}