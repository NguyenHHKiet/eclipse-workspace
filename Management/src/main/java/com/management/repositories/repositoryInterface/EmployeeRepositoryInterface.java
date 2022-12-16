package com.management.repositories.repositoryInterface;

import com.management.ConnectionSQL;

public interface EmployeeRepositoryInterface extends CRUDRepository {

	void SearchEmployeeBaseName(ConnectionSQL conn);

	void SearchEmployeeBaseBirth(ConnectionSQL conn);

	void SearchEmployeeBaseDepartment(ConnectionSQL conn);

	void SearchFromToYearOld(ConnectionSQL conn);

	void AddRelative(ConnectionSQL conn);

	void DisplayRelativeBaseEmployee(ConnectionSQL conn);
}
