package company.main;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;
import company.service.Company;

public class CompanyList implements Company {

	@Override
	public void execute() {
		System.out.println("이름\t아이디\t입사일\t\t전화번호");
		System.out.println("----------------------------------------");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyDTO companyDTO = new CompanyDTO();
		
		companyDAO.list(companyDTO);
	}

}
