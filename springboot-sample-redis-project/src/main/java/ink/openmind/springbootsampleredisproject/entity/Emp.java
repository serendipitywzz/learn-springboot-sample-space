package ink.openmind.springbootsampleredisproject.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/12 20:32
 * DESC
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 1L;

    private String empName;
    private Integer empAge;
    private Double empSal;
    private Date hireDate;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empName='" + empName + '\'' +
                ", empAge=" + empAge +
                ", empSal=" + empSal +
                ", hireDate=" + hireDate +
                '}';
    }
}
