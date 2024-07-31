package company.service;

import company.bean.CompanyDTO;
import company.dao.CompanyDAO;

public class CompanyLeaveList implements Company{

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("[퇴사 사원 목록]");
		System.out.println("이름\t아이디\t입사일\t\t퇴사일");
		
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		CompanyDTO companyDTO = new CompanyDTO();
		
		companyDAO.leavelist(companyDTO);
	}
	
}
