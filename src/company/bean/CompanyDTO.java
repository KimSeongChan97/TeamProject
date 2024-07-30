package company.bean;

public class CompanyDTO {
    private int companyId; // 회사 ID
    private String companyName; // 회사 이름
    private String companyAddress; // 회사 주소

    // 기본 생성자
    public CompanyDTO() {
    }

    // 매개변수가 있는 생성자
    public CompanyDTO(int companyId, String companyName, String companyAddress) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }

    // 회사 ID getter 메서드
    public int getCompanyId() {
        return companyId;
    }

    // 회사 ID setter 메서드
    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    // 회사 이름 getter 메서드
    public String getCompanyName() {
        return companyName;
    }

    // 회사 이름 setter 메서드
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    // 회사 주소 getter 메서드
    public String getCompanyAddress() {
        return companyAddress;
    }

    // 회사 주소 setter 메서드
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }
}
