package com.management.repositories.repositoryInterface;

import com.management.ConnectionSQL;

public interface OrderProjectRepositoryInterface extends CRUDRepository {

	void SetupOrderProject(ConnectionSQL conn);

	void DisplayAllEmployees(ConnectionSQL conn);

	void DisplayAllProject(ConnectionSQL conn);

	void UpdateBonusEmployee(ConnectionSQL conn);

}
